/*
 * Copyright 2014 John D. Ament
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.
 *
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package ws.ament.hammock.test;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;

import org.apache.log4j.BasicConfigurator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.weld.environment.se.events.ContainerInitialized;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ws.ament.hammock.core.WebServerLauncher;
import ws.ament.hammock.core.annotations.ApplicationConfig;
import ws.ament.hammock.core.annotations.ManagementConfig;

//@RunWith(Arquillian.class)
public class LaunchTest {
    @Deployment
    public static JavaArchive createArchive() {
        BasicConfigurator.configure();
        return ShrinkWrap.create(JavaArchive.class,LaunchTest.class.getSimpleName()+".jar")
                .addPackages(true, WebServerLauncher.class.getPackage())
                .addAsManifestResource(new StringAsset("ws.ament.hammock.core.impl.ClassScannerExtension\n" +
                        "org.jboss.resteasy.cdi.ResteasyCdiExtension"),"services/javax.enterprise.inject.spi.Extension")
                .addAsManifestResource(new StringAsset("\n" +
                        "<beans xmlns=\"http://xmlns.jcp.org/xml/ns/javaee\"\n" +
                        "       xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                        "       xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/javaee\n" +
                        "\t\thttp://xmlns.jcp.org/xml/ns/javaee/beans_1_1.xsd\"\n" +
                        "       bean-discovery-mode=\"all\">\n" +
                        "</beans>"),"beans.xml")
                .addClasses(ApplicationConfigBean.class,EchoResource.class,
                        ManagementConfigBean.class,ManagementEchoResource.class);
    }

    @Inject
    @ApplicationConfig
    private ApplicationConfigBean applicationConfigBean;

    @Inject
    @ManagementConfig
    private ManagementConfigBean mgmtConfigBean;

    @Test
    @Ignore
    public void testGetApp() throws InterruptedException {
        CDI.current().getBeanManager().fireEvent(new ContainerInitialized());
        String value = ClientBuilder.newClient().target("http://localhost:"+applicationConfigBean.getPort()).path("/api/echo")
                .request().get(String.class);
        Assert.assertEquals("hello", value);
    }

    @Test
    @Ignore
    public void testGetMgmt() throws InterruptedException {
        CDI.current().getBeanManager().fireEvent(new ContainerInitialized());
        String value = ClientBuilder.newClient().target("http://localhost:"+mgmtConfigBean.getPort()).path("/mgmt/echom")
                .request().get(String.class);
        Assert.assertEquals("management", value);
    }

    @Test
    @Ignore
    public void testGetWrongPaths() throws InterruptedException {
        CDI.current().getBeanManager().fireEvent(new ContainerInitialized());
        try {
            String value = ClientBuilder.newClient().target("http://localhost:"+applicationConfigBean.getPort()).path("/api/echom")
                    .request().get(String.class);
            Assert.fail("Request was processed");
        }
        catch (WebApplicationException e) {
            Assert.assertEquals(404,e.getResponse().getStatus());
        }
        try {
            String value = ClientBuilder.newClient().target("http://localhost:"+mgmtConfigBean.getPort()).path("/mgmt/echo")
                    .request().get(String.class);
            Assert.fail("Request was processed");
        }
        catch (WebApplicationException e) {
            Assert.assertEquals(404,e.getResponse().getStatus());
        }
    }
}
