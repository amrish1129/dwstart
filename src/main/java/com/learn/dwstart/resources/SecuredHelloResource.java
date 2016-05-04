package com.learn.dwstart.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.learn.dwstart.core.User;

import io.dropwizard.auth.Auth;

@Path("/secured_hello")
public class SecuredHelloResource {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(@Auth User user) {
        return "Hello world!";
    }
}
