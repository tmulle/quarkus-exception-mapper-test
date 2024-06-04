package org.acme;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    /**
     * This one triggers
     * 
     * @return
     */
    @GET
    @Path("/boom")
    @Produces(MediaType.TEXT_PLAIN)
    public String blowup() {
        throw new WebApplicationException("BOOM!", Response.Status.BAD_REQUEST);
    }

    /**
     * This one doesn't trigger Exception mapper
     * 
     * @return
     */
    @GET
    @Path("/boom2")
    @Produces(MediaType.TEXT_PLAIN)
    public String blowUp2() {
        Response r = Response.status(Response.Status.BAD_REQUEST).entity("BOOM 2!").build();
        throw new BadRequestException(r);
    }

    /**
     * This one works!
     * 
     * @return
     */
    @GET
    @Path("/boom3")
    @Produces(MediaType.TEXT_PLAIN)
    public String blowUp3() {
        Response r = Response.status(Response.Status.BAD_REQUEST).entity("BOOM 2!").build();
        throw new BadRequestException("BOOM 3!");
    }
}
