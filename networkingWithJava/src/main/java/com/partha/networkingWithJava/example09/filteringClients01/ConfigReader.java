package com.partha.networkingWithJava.example09.filteringClients01;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigReader {
	
	final List<String> allowedIps;
	final List<String> deniedIps;
	
	public ConfigReader(){
		final Properties filterProperties = new Properties();
		try{
			filterProperties.load(getClass().getClassLoader().getResourceAsStream("filter01.properties"));
		} catch(IOException ignored){
			
		}finally{
			final String allowedIpsCSV = filterProperties.getProperty("allowed");
			final String deniedIpsCSV =  filterProperties.getProperty("denied");
			allowedIps = Arrays.asList(allowedIpsCSV.split(","));
			deniedIps = Arrays.asList(deniedIpsCSV.split(","));
		}
	}
	
	public Config getConfig(){
		return new Config(){
			
		}
	}

}
