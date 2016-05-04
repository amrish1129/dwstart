package com.learn.dwstart.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {
	
	@JsonProperty
	private String greeting;

	public Greeting(String greeting) {
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.greeting);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Greeting other = (Greeting) obj;
        if (!Objects.equals(this.greeting, other.greeting)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Greeting{" + "greeting=" + greeting + '}';
    }
	
}
