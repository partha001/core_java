package com.partha.networkingWithJava.example09.filteringClients03;

import java.util.Collection;

public interface Config {
	
//	Collection<String> getAllowedIps();
//	
//	Collection<String> getDeniedIps();
	
	Collection<String> getAllowedDomains();
	
	Collection<String> getDeniedDomains();

}
