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

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.gateway.core.exception.BaSyxComponentNotHealthyException;
import org.eclipse.digitaltwin.basyx.gateway.core.feature.Gateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultGateway implements Gateway {

    private Logger logger = LoggerFactory.getLogger(DefaultGateway.class);

    @Override
    public void createAAS(AssetAdministrationShell aas, String aasRepository, String aasRegistry) throws BaSyxComponentNotHealthyException{
        throwExceptionIfIsUnhealthyBaSyxComponent(aasRepository);
        if(aasRegistry != null){
            throwExceptionIfIsUnhealthyBaSyxComponent(aasRegistry);
        }
    }

    private void throwExceptionIfIsUnhealthyBaSyxComponent(String componentURL) {
        componentURL = formatURL(componentURL);

        if (isBaSyxComponent(componentURL) && !isHealthy(componentURL)) {
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

    private boolean isBaSyxComponent(String componentURL) {
        try {
            HttpURLConnection connection = getRequest(componentURL, "/shells");

            String aasMiddleware = connection.getHeaderField("AASMiddleware");

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

            return connection.getResponseCode() == 200 && body.equals("{'status':'UP'}");

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
}
