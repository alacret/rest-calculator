package com.alacret.raluca;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.HashMap;
import org.glassfish.jersey.server.JSONP;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("rest-calculator")
public class RestCalculator {

    /**
     * Method handling the add operation for up to three params.
     * The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @param double a the first number
     * @param double b the second number
     * @param double c the third number

     * @return String response.
     */
    @GET
    @JSONP
    @Path("/add/{a}/{b}/{c}")
    @Produces({"application/javascript",MediaType.APPLICATION_JSON})
    public Result add(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") double c) {
        Result r = new Result();
	r.setResult(a+b+c);
	return r;
    }


    /**
     * Method handling the substract operation for up to three params.
     * The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @param double a the first number
     * @param double b the second number
     * @param double c the third number

     * @return String response.
     */
    @GET
    @JSONP
    @Path("/substract/{a}/{b}/{c}")
    @Produces({"application/javascript",MediaType.APPLICATION_JSON})
    public Result substract(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") double c) {
        Result r = new Result();
        r.setResult(a-b-c);
        return r;
    }


    /**
     * Method handling the multiply operation for up to three params.
     * The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @param double a the first number
     * @param double b the second number
     * @param double c the third number

     * @return String response.
     */
    @GET
    @JSONP
    @Path("/multiply/{a}/{b}/{c}")
    @Produces({"application/javascript",MediaType.APPLICATION_JSON})
    public Result multiply(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") double c) {
        Result r = new Result();
        r.setResult(a*b*c);
        return r;
    }



    /**
     * Method handling the divide operation for up to two params.
     * The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @param double a the first number
     * @param double b the second number

     * @return String response.
     */
    @GET
    @JSONP
    @Path("/divide/{a}/{b}")
    @Produces({"application/javascript",MediaType.APPLICATION_JSON})
    public Result divide(@PathParam("a") double a, @PathParam("b") double b) {
        Result r = new Result();
	if (b == 0d)
	        r.setResult(Double.NaN);
	else
		r.setResult(a/b);
        return r;
    }


}
