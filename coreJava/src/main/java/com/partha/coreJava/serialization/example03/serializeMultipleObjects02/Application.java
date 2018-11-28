package com.partha.coreJava.serialization.example03.serializeMultipleObjects02;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * this example show how to serialize and deserialize multiple objects when
 * we dont know the order of serialization
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
			//incase if we dont know the order in which the order in which the objects have been 
			//serialized then that can be taken care as shown below
			Object obj= ois.readObject();
			while(obj!=null){
				if(obj instanceof Dog){
					System.out.println("dog object is deserialize");
				}
				else if(obj instanceof Cat){
					System.out.println("cat object is deserialize");
				}
				else if(obj instanceof Rat){
					System.out.println("rat object is deserialize");
				}
				try{
				obj=ois.readObject();
				}catch(EOFException ex){
					break;
				}
			}
			

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
