package com.partha.coreJava.serialization.example05.customSerialization01;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable{

	private String username;
	private transient String password;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	//this callback methos is called automatically during serialization
	private void writeObject(ObjectOutputStream oos) throws Exception{
		oos.defaultWriteObject();
		//let this be my simple encryption algorithm
		String ecryptedPassword="***"+this.password;
		//note that the encrypted attribute is serialized separately
		oos.writeObject(ecryptedPassword);	
	}
	
	//this callback method is called automatically during deserialization
	private void readObject(ObjectInputStream ois) throws Exception {
		//reading the default user object
		ois.defaultReadObject();
		//reading the encrypted password separately
		String encryptedPassword=(String)ois.readObject();
		//decrypting the password
		this.password=encryptedPassword.substring(3);
	}
}
