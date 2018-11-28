package com.partha.coreJava.serialization.example06.inheritence02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * case: when parent class is serializable and child class doesnt implement serializable
 * note: though dog class doesnt implement serializable still we are successfull
 * in serializing it since it gets the serializable property from the parent by inheritence
 * @author partha
 */
public class Application {

	public static void main(String[] args) {
		try {
			//creating the object to be serialized
			Dog dog1=new Dog();
			dog1.setI(10);
			dog1.setJ(20);
			
			//serialization
			FileOutputStream fos=new FileOutputStream("test.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(dog1);			 
			
			//deserialization
			FileInputStream fis=new FileInputStream("test.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);
			Dog dog2=(Dog)ois.readObject();
			
			System.out.println("i:"+ dog2.getI()+"  j:"+dog2.getJ());
			
			

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
