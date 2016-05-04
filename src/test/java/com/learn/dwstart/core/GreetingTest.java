package com.learn.dwstart.core;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;
import io.dropwizard.testing.FixtureHelpers;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class GreetingTest {
	
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    
    //@Test
    public void serializeObjectToJason() throws JsonProcessingException {
    	Greeting greeting = new Greeting("Hello world!");
    	String actual = MAPPER.writeValueAsString(greeting);
    	String expected = FixtureHelpers.fixture("fixtures/greeting.json");
    	
    	Assertions.assertThat(actual).isEqualTo(expected);
    }
    
   //@Test
    public void deserializeJsonToObject() throws JsonParseException, JsonMappingException, IOException {
    	String text = FixtureHelpers.fixture("fixtures/greeting.json");
    	Greeting expected = new Greeting("Hello world!");
    	
    	Greeting actual = MAPPER.readValue(text, Greeting.class);
    	Assert.assertEquals(expected, actual);
    }
 
}
