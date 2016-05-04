package com.learn.dwstart.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;

public class HelloResourceTest {
	@Rule
    public ResourceTestRule resource = ResourceTestRule.builder()
            .addResource(new HelloResource()).build();

	@Test
	public void testGetGreeting() {
		String expected = "Hello World!";
		//Obtain client from @Rule resource
		Client client = resource.client();
		WebTarget target = client.target("http://localhost:8080/hello");
		//To invoke response we use Invocation.Builder
        //and specify the media type of representation asked from resource.
		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN);
		//Obtain response.
        Response response = builder.get();
        
        //Do assertion
        assertEquals(Response.Status.OK, response.getStatusInfo());
        assertEquals(expected, response.readEntity(String.class));
	}

}
