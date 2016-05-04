package com.learn.dwstart.auth;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.google.common.base.Optional;
import com.learn.dwstart.core.User;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;

public class GreetingAuthenticatorTest extends Mockito {
	
	@Mock
	BasicCredentials credentials;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAuthenticate() throws AuthenticationException {
		when(credentials.getPassword()).thenReturn("password");
		when(credentials.getUsername()).thenReturn("User");
		
		GreetingAuthenticator authenticator = new GreetingAuthenticator("User", "password");
		Optional<User> user = authenticator.authenticate(credentials);
		
		assertEquals("User", user.get().getUserId());
		
	}
	
}
