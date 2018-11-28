package com.partha.coreJava.serialization.example02.tansient01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * this program shows that transient variables are not serialized
 * @author partha
 *
 */
public class Application {

	public static void main(String[] args) {
		try {
			//creating the object to be serialized
			Dog dog=new Dog();
			dog.setId(1);
			dog.setName("tommy");
			System.out.println("hashcode of the object to be serialized:"+dog.hashCode());

			//serialization
			FileOutputStream fos=new FileOutputStream("test.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(dog);
			
			
			//deserialization
			FileInputStream fis=new FileInputStream("test.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);
			Dog dog2=(Dog)ois.readObject();
			
			System.out.println("id:"+dog2.getId()+" name:"+dog2.getName());
			System.out.println("hashcode of the object deserialized:"+dog2.hashCode());
			    


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
