package com.learn.dwstart.auth;

import com.google.common.base.Optional;
import com.learn.dwstart.core.User;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class GreetingAuthenticator implements Authenticator<BasicCredentials, User>{
	
	private String login;
	private String password;
	
	public GreetingAuthenticator(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	//private static final String PASSWORD = "password";
	
	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
		if(password.equals(credentials.getPassword())
				&& login.equals(credentials.getUsername())) {
			return Optional.of(new User(credentials.getUsername()));
		} else {
			return Optional.absent();
		}
	}

}
