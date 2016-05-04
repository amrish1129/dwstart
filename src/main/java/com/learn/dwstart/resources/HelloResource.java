package com.learn.dwstart.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.learn.dwstart.core.Greeting;

@Path(value = "/hello")
public class HelloResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getGreeting() {
		return "Hello World!";
		
	}
	
	@Path("/hello_json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting getJSONGreeting() {
        return new Greeting("Hello world!");
    }
	
	public String getTailoredGreetingWithQueryParam(
            @QueryParam("name") Optional<String> name) {
        if (name.isPresent()) {
            return "Hello " + name.get();
        } else {
            return "Hello world";
        }
    }
}
