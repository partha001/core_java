package com.partha.coreJava.serialization.example05.customSerialization01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * this is an example of customized serialization.
 * 
 * note how the password attribute is serialized and then deserialized separately 
 * using callback methods since its transient.
 * @author partha
 */
public class Application {

	public static void main(String[] args) {
		try {
			//creating the object to be serialized
			User user =new User("partha", "mypassword");
			
			//serialization
			FileOutputStream fos=new FileOutputStream("test.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(user);
			
			 
			
			//deserialization
			FileInputStream fis=new FileInputStream("test.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);
			User user2=(User)ois.readObject();
			System.out.println("username:"+user2.getUsername()+"  password:"+user2.getPassword());
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
