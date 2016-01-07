package com.alacret.raluca;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


public class SubstractionTest {

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
       Result responseMsg = target.path("rest-calculator/substract/4/2/1").request().get(Result.class);
        Assert.assertEquals(1d,responseMsg.getResult(),0d);
    }

    /**
     * Test to see that a zero sum works
     */
    @Test
    public void testZeroSub() {
       Result responseMsg = target.path("rest-calculator/substract/0/0/0").request().get(Result.class);
        Assert.assertEquals(0d,responseMsg.getResult(),0d);
    }
}
