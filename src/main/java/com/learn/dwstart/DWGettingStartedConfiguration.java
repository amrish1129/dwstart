package com.learn.dwstart;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

/**
 * The Configuration class.
 * It stores all the project and environment related settings.
 *
 * @author amrish
 */
public class DWGettingStartedConfiguration extends Configuration {

	@NotEmpty //annotation will assure that application will not start if appName value will be not defined.
    private String appName;
	
	@NotNull
	private String login;
	
	@NotNull
	private String password;

    @JsonProperty //allows to deserialise and serialise from a YAML property.
    public String getAppName() {
        return appName;
    }

    @JsonProperty
    public void setAppName(final String appName) {
        this.appName = appName;
    }
    
    @JsonProperty
    public String getLogin() {
    	return login;
    }
    
    @JsonProperty
    public String getPassword() {
    	return password;
    }
}
