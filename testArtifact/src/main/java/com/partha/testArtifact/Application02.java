package com.partha.testArtifact;

import java.util.HashMap;
import java.util.Map;

public class Application02 {

	public static void main(String[] args) {
		Emp emp1=new Emp("partha");
		Emp emp2=new Emp("anirban");
		Map<Emp,Emp> map=new HashMap<Emp, Emp>();
		System.out.println(emp1.hashCode()+" "+emp1);
		System.out.println(emp2.hashCode()+" "+emp2);
		map.put(emp1, emp1);
		map.put(emp2, emp2);
		
		for(Object obj:map.keySet()){
			System.out.println("key:"+ obj);
		}
		
		System.out.println("\n\nnow changing the empname");
		emp1.setEmpname("anirban");
		System.out.println(emp1.hashCode()+" "+emp1);
		for(Object obj:map.keySet()){
			System.out.println("key:"+ obj);
		}
		
		System.out.println("end");
	}

}
