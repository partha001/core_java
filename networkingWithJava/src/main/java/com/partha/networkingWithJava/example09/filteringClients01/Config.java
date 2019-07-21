package com.partha.networkingWithJava.example09.filteringClients01;

import java.util.Collection;

public interface Config {
	
	Collection<String> getAllowedIps();
	
	Collection<String> getDeniedIps();

}
