package com.learn.dwstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.learn.dwstart.auth.GreetingAuthenticator;
import com.learn.dwstart.core.User;
import com.learn.dwstart.resources.HelloResource;
import com.learn.dwstart.resources.SecuredHelloResource;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Environment;

/**
 * The application class.
 *
 * @author Amrish
 */
public class DWGettingStartedApplication extends Application<DWGettingStartedConfiguration> {
	public static final Logger LOGGER = LoggerFactory.getLogger(DWGettingStartedApplication.class);

	@Override
	public void run(final DWGettingStartedConfiguration configuration, Environment environment) throws Exception {
		// TODO Auto-generated method stub
		
		environment.jersey().register(
				AuthFactory.binder(
						new BasicAuthFactory<>(
								new GreetingAuthenticator(configuration.getLogin(), 
										configuration.getPassword()), 
								"SECURITY REALM", User.class)));
		
		environment.jersey().register(new HelloResource());
		environment.jersey().register(new SecuredHelloResource());
	}

	/**
	 * The main method of the application.
	 *
	 * @param args
	 *            command-line arguments
	 * @throws Exception
	 *             any exception while executing the main() method.
	 */
	public static void main(final String[] args) throws Exception {
		new DWGettingStartedApplication().run(args);
	}
}
