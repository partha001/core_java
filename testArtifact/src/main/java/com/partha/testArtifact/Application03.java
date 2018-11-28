package com.partha.testArtifact;

import java.util.HashMap;
import java.util.Map;

public class Application03 {

	public static void main(String[] args) {
		System.out.println("anirban".hashCode()+" "+"partha".hashCode());
		
		Emp emp1=new Emp("partha");
		Emp emp2=new Emp("anirban");
		Map<String,Emp> map=new HashMap<String, Emp>();
		System.out.println(emp1.hashCode()+" "+emp1);
		System.out.println(emp2.hashCode()+" "+emp2);
		map.put(emp1.getEmpname(), emp1);
		map.put(emp2.getEmpname(), emp2);
		
		for(String key:map.keySet()){
			System.out.println("key:"+ key.hashCode()+ "    value.name:"+map.get(key).getEmpname());
		}
		
		System.out.println("\n\nnow changing the empname");
		emp1.setEmpname("anirban");
		System.out.println(emp1.hashCode()+" "+emp1);
		for(String key1:map.keySet()){
			System.out.println("key:"+ key1.hashCode()+ "   value.name:"+map.get(key1).getEmpname());
		}
		//conclusion: on changing the name of emp1 , its hashcode value changes. however the value of key
		//previously stored in the map doesnt change as the key was calculated before while inserting the 
		//object. however the value now contains the updated name i.e. anirban
		
		System.out.println("\n\nmaking another entry in the map");
		map.put("anirban", new Emp("saikat"));
		System.out.println("");
		for(String key2:map.keySet()){
			System.out.println("key:"+ key2.hashCode()+ "   value.name:"+map.get(key2).getEmpname());
		}
		//conclusion2: as we try to make entry it calculates the hash for the key anirban. then it updates 
		//only that record for which it finds match of hashcode and key both. thus only one record gets updated
		
		System.out.println("end");
	}

}
