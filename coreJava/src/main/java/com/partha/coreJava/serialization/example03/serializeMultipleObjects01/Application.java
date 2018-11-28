package com.partha.coreJava.serialization.example03.serializeMultipleObjects01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * this example show how to serialize multiple objects
 * note: the order of serializtion and deserializtion should be same
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
			
			Cat cat1=new Cat();
			cat1.setId(1);
			cat1.setName("pussy");
			
			Rat rat1=new Rat();
			rat1.setId(1);
			rat1.setName("harry");

			//serialization
			FileOutputStream fos=new FileOutputStream("test.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(dog);
			oos.writeObject(cat1);
			oos.writeObject(rat1);
			 
			
			//deserialization
			FileInputStream fis=new FileInputStream("test.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);
			//thus the order in which the objects are deserialized should be the same as
			//the order in which objects are serialized
			Dog dog2=(Dog)ois.readObject();
			Cat cat2=(Cat)ois.readObject();
			Rat rat2=(Rat)ois.readObject();
			
			
			
			
			    


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
