package com.learn.dwstart.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;

public class SecuredHelloResourceTest {
	
	/**
     * Setup in order to provide tests with javax.ws.rs.client.Client in
     * order to access resources from Java.
     */
	@Rule
	public ResourceTestRule rule = ResourceTestRule.builder().addResource(new SecuredHelloResource()).build();
	
	@Test
	public void testgetGreeting() {
		String expected = "Hello world!";
		
		Client client = rule.client();
		WebTarget target = client.target("http://localhost:8080/secured_hello");
		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN);
		
		Response response = builder.get();
		
		assertEquals(Response.Status.OK, response.getStatusInfo());
		assertEquals(expected, response.readEntity(String.class));
	}
}
