package com.partha.testArtifact;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Application05 {

	public static void main(String[] args) {
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
	
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));		
		
		Map<Integer, String> hashMap= new HashMap<Integer, String>();
		hashMap.put(i1, "partha");
		hashMap.put(i2, "saikat");
		System.out.println("size of hashmap is ="+hashMap.size());
	
		
		Map<Integer, String> identityHashMap= new IdentityHashMap<Integer, String>();
		identityHashMap.put(i1, "partha");
		identityHashMap.put(i2, "saikat");
		System.out.println("size of identityHashMap is ="+identityHashMap.size());
	
	}

}
