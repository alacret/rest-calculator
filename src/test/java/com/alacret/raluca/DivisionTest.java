package com.alacret.raluca;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


public class DivisionTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {

        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to simple sum
     */
    @Test
    public void testSimple() {
       Result responseMsg = target.path("rest-calculator/divide/22/2").request().get(Result.class);
        Assert.assertEquals(11d,responseMsg.getResult(),0d);
    }

    /**
     * Test to see that a zero sum works
     */
    @Test
    public void testZeroDiv() {
        Response response = target.path("rest-calculator/divide/99/0").request().get();
        Result responseMsg  = null;
        try {
            responseMsg = target.path("rest-calculator/divide/99/0").request().get(Result.class);
            Assert.fail();
        }catch (WebApplicationException e){
            System.out.print("Division by cero is Inifinite");
        }
        Assert.assertNull(responseMsg);

    }
}
