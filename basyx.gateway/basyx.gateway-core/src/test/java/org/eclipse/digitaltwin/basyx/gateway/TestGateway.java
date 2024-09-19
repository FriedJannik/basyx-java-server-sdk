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

package org.eclipse.digitaltwin.basyx.gateway;

import org.apache.http.HttpStatus;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetInformation;
import org.eclipse.digitaltwin.basyx.gateway.core.DefaultGateway;
import org.eclipse.digitaltwin.basyx.gateway.core.exception.BaSyxComponentNotHealthyException;
import org.eclipse.digitaltwin.basyx.gateway.core.feature.Gateway;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpResponse;
import org.mockserver.verify.VerificationTimes;

public class TestGateway {

    public static ClientAndServer mockBaSyxAasRepository;
    public static ClientAndServer mockAasRegistry;
    private Gateway gateway;

    @Before
    public void setUp(){
        mockBaSyxAasRepository = ClientAndServer.startClientAndServer(6006);
        gateway = new DefaultGateway();
    }

    @After
    public void tearDown(){
        mockBaSyxAasRepository.stop();
    }

    @Test
    public void testCreateAASWithHealthyBaSyxComponent(){
        getExpectations(HttpResponse.response()
                .withStatusCode(HttpStatus.SC_OK)
                .withHeader("AASMiddleware", "BaSyx"), "{'status':'UP'}");
        gateway.createAAS(getDummyShell(), "http://localhost:6006", null);
        verifyCall("/shells",1);
        verifyCall("/actuator/health",1);
    }

    @Test(expected = BaSyxComponentNotHealthyException.class)
    public void testCreateAASWithUnhealthyBaSyxComponent(){
        getExpectations(HttpResponse.response()
                .withStatusCode(HttpStatus.SC_OK)
                .withHeader("AASMiddleware", "BaSyx"), "{'status':'DOWN'}");
        gateway.createAAS(getDummyShell(), "http://localhost:6006", null);
    }

    @Test
    public void testCreateAASWithNonBaSyxComponent(){
        getExpectations(org.mockserver.model.HttpResponse.response()
                .withStatusCode(HttpStatus.SC_OK), "{'status':'UP'}");
        gateway.createAAS(getDummyShell(), "http://localhost:6006", null);
        verifyCall("/shells",1);
        verifyCall("/actuator/health",0);
    }

    private static void getExpectations(HttpResponse SC_OK, String responseBody) {
        new MockServerClient("localhost", 6006)
                .when(org.mockserver.model.HttpRequest.request()
                        .withMethod("GET")
                        .withPath("/shells"))
                .respond(SC_OK
                        .withBody("{}"));
        new MockServerClient("localhost", 6006)
                .when(org.mockserver.model.HttpRequest.request()
                        .withMethod("POST")
                        .withPath("/shells"))
                .respond(HttpResponse.response()
                        .withStatusCode(HttpStatus.SC_OK)
                        .withHeader("AASMiddleware", "BaSyx")
                        .withBody("{}"));
        new MockServerClient("localhost", 6006)
                .when(org.mockserver.model.HttpRequest.request()
                        .withMethod("GET")
                        .withPath("/actuator/health"))
                .respond(HttpResponse.response()
                        .withStatusCode(HttpStatus.SC_OK)
                        .withBody(responseBody));
    }

    private void verifyCall(String path, int timesCalled) {
        new MockServerClient("localhost", 6006).verify(org.mockserver.model.HttpRequest.request().withMethod("GET")
                .withPath(path)
                , VerificationTimes.exactly(timesCalled));
    }

    private AssetAdministrationShell getDummyShell(){
        return new DefaultAssetAdministrationShell.Builder().id("TestId").idShort("test").assetInformation(new DefaultAssetInformation.Builder().build()).build();
    }
}
