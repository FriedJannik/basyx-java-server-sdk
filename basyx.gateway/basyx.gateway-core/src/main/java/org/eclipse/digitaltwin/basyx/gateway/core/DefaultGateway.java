/*******************************************************************************
 * Copyright (C) 2024 the Eclipse BaSyx Authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * SPDX-License-Identifier: MIT
 ******************************************************************************/

package org.eclipse.digitaltwin.basyx.gateway.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.aasregistry.main.client.factory.AasDescriptorFactory;
import org.eclipse.digitaltwin.basyx.aasregistry.main.client.mapper.AttributeMapper;
import org.eclipse.digitaltwin.basyx.aasrepository.client.ConnectedAasRepository;
import org.eclipse.digitaltwin.basyx.core.exceptions.RepositoryRegistryLinkException;
import org.eclipse.digitaltwin.basyx.gateway.core.exception.BaSyxComponentNotHealthyException;
import org.eclipse.digitaltwin.basyx.gateway.core.exception.RegistryUnavailableException;
import org.eclipse.digitaltwin.basyx.gateway.core.feature.Gateway;
import org.eclipse.digitaltwin.basyx.http.Aas4JHTTPSerializationExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.digitaltwin.basyx.aasregistry.client.ApiException;
import org.eclipse.digitaltwin.basyx.aasregistry.client.api.RegistryAndDiscoveryInterfaceApi;
import org.eclipse.digitaltwin.basyx.aasregistry.client.model.AssetAdministrationShellDescriptor;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DefaultGateway implements Gateway {

    private Logger logger = LoggerFactory.getLogger(DefaultGateway.class);

    @Override
    public void createAAS(AssetAdministrationShell aas, String aasRepository, String aasRegistry) throws BaSyxComponentNotHealthyException {
        logger.info("Creating AAS {} in AAS Repository {} and linking it with AAS Registry {}", aas.getId(), aasRepository, aasRegistry);

        validateRepository(aasRepository);

        ConnectedAasRepository aasRepo = new ConnectedAasRepository(aasRepository);
        aasRepo.createAas(aas);

        if (aasRegistry == null) {
            return;
        }

        validateRegistry(aasRegistry);

        try {
            integrateAasWithRegistry(aas, aasRegistry, aasRepository);
        } catch (RepositoryRegistryLinkException e) {
            handleRegistryLinkException(aasRepo, aas, aasRepository, aasRegistry, e);
        }
    }

    private void validateRepository(String aasRepository) throws BaSyxComponentNotHealthyException {
        if (aasRepository == null) {
            throw new UnsupportedOperationException("No AAS Repository configured");
        }
        throwExceptionIfIsUnhealthyBaSyxRepository(aasRepository);
    }

    private void validateRegistry(String aasRegistry) throws BaSyxComponentNotHealthyException {
        throwExceptionIfIsUnhealthyBaSyxRegistry(aasRegistry);
    }

    private void handleRegistryLinkException(ConnectedAasRepository aasRepo, AssetAdministrationShell aas, String aasRepository, String aasRegistry, RepositoryRegistryLinkException e) throws RegistryUnavailableException {
        logger.error("Unable to link AAS {} with registry {}. Rolling back...", aas.getId(), aasRegistry);
        aasRepo.deleteAas(aas.getId());
        logger.error("Rollback in AAS Repository {} completed.", aasRepository);
        throw new RegistryUnavailableException("Unable to link AAS with registry. Changes in AAS Repository rolled back.");
    }


    private void throwExceptionIfIsUnhealthyBaSyxRepository(String componentURL) {
        componentURL = formatURL(componentURL);

        if (isBaSyxRepository(componentURL) && !isHealthy(componentURL)) {
            throw new BaSyxComponentNotHealthyException(componentURL + " is not healthy");
        }
    }

    private void throwExceptionIfIsUnhealthyBaSyxRegistry(String componentURL) {
        componentURL = formatURL(componentURL);

        if (isBaSyxRegistry(componentURL) && !isHealthy(componentURL)) {
            throw new BaSyxComponentNotHealthyException(componentURL + " is not healthy");
        }
    }

    private String formatURL(String componentURL) {
        try {
            URL url = new URL(componentURL);
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            if (port == -1) { // no port specified, use default port
                port = url.getDefaultPort();
            }
            componentURL = protocol + "://" + host + ":" + port;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return componentURL;
    }

    private boolean isBaSyxRepository(String componentURL) {
        try {
            HttpURLConnection connection = getRequest(componentURL, "/shells");

            String aasMiddleware = connection.getHeaderField("aas_middleware");

            return "BaSyx".equals(aasMiddleware);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }
    private boolean isBaSyxRegistry(String componentURL) {
        try {
            HttpURLConnection connection = getRequest(componentURL, "/shell-descriptors");

            String aasMiddleware = connection.getHeaderField("aas_middleware");

            return "BaSyx".equals(aasMiddleware);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    private boolean isHealthy(String componentURL){
        try {
            HttpURLConnection connection = getRequest(componentURL, "/actuator/health");

            String body = new String(connection.getInputStream().readAllBytes());

            return connection.getResponseCode() == 200 && body.contains("UP");

        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    private static HttpURLConnection getRequest(String componentURL, String path) throws IOException {
        URL url = new URL(componentURL + path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        return connection;
    }

    private void integrateAasWithRegistry(AssetAdministrationShell shell,String aasRegistryUrl, String aasRepositoryUrl) throws RepositoryRegistryLinkException{
        List<String> aasRepositoryURLs = List.of(aasRepositoryUrl);
        AttributeMapper attributeMapper = getAttributeMapper();

        AssetAdministrationShellDescriptor descriptor = new AasDescriptorFactory(shell, aasRepositoryURLs, attributeMapper).create();

        RegistryAndDiscoveryInterfaceApi registryApi = new RegistryAndDiscoveryInterfaceApi(aasRegistryUrl);

        try {
            registryApi.postAssetAdministrationShellDescriptor(descriptor);

        } catch (ApiException e) {
            throw new RepositoryRegistryLinkException(shell.getId(), e);
        }
        logger.info("Shell '{}' has been automatically linked with the Registry", shell.getId());

    }

    private static AttributeMapper getAttributeMapper() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().serializationInclusion(JsonInclude.Include.NON_NULL);
        Aas4JHTTPSerializationExtension extension = new Aas4JHTTPSerializationExtension();
        extension.extend(builder);
        ObjectMapper objectMapper = builder.build();
        AttributeMapper attributeMapper = new AttributeMapper(objectMapper);
        return attributeMapper;
    }
}
