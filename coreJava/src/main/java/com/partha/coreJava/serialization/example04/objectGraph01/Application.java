package com.partha.coreJava.serialization.example04.objectGraph01;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * this example shows : all the related objects to the serialized object is also serialized.
 * here emp -> address->Country  . this is the order of dependency.
 * 
 * note:since all the objects related to the serialized object are serialized hence all the 
 * related objects also need to implements serializable.else we will get NotSerializableException
 * 
 * the object that we are trying to serialize and all its related objects together form the object graph
 * @author partha
 */
public class Application {

	public static void main(String[] args) {
		try {
			//creating the object to be serialized
			Country country=new Country("india");
			Address address=new Address("some_residency", country);
			Employee emp=new Employee("partha", address);

			//serialization
			FileOutputStream fos=new FileOutputStream("test.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(emp);
			
			 
			
			//deserialization
			FileInputStream fis=new FileInputStream("test.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);
			Employee emp2=(Employee)ois.readObject();
			System.out.println("getting country using the deserialized emp object :"+ emp2.getAddress().getCountry().getName());
			
			

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
