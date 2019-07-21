package com.partha.networkingWithJava.example11.sendingMails;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class SessionBuilder {
	
	public static Session build(Properties props,String user , String password){
		return Session.getDefaultInstance(props, 
				new Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(user,password);
					}
			
		});
	}

}
