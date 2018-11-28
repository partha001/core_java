package com.partha.coreJava.serialization.example02.tansient02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *this example is to see the effect of transient on static and final
 *<p>
 *note1: static members are attributes of the class thus it doesnt participate in serialization.
 *thus whether we are declaring it transient or not doesnt make any difference. note that 
 *the static value that we are printing is attibute of the class and not an attribute of the 
 *deserialize object . thus it prints the same value.
 *
 *<p>
 *note2: all the final values are replaced at compile time. thus while serialization jvm doesnt see the 
 *attribute as variable but sees its value. hence it doent check whether its transient or not. so using 
 *transient doesnt have any effect on final varible. thus the value get written to file and later it is also
 *read from file while deserialization
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
			System.out.println("noOflegs:"+Dog.noOflegs+" noOfEyes:"+dog2.getNoOfEyes()+" noOfEars:"+Dog.noOfEars);
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
