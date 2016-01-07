package com.alacret.raluca;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;


public class AddTest {

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
       Result responseMsg = target.path("rest-calculator/add/1/2/3").request().get(Result.class);
        Assert.assertEquals(6d,responseMsg.getResult(),0d);
    }

    /**
     * Test to see that a zero sum works
     */
    @Test
    public void testZeroSum() {
       Result responseMsg = target.path("rest-calculator/add/0/0/0").request().get(Result.class);
        Assert.assertEquals(0d,responseMsg.getResult(),0d);
    }
}
