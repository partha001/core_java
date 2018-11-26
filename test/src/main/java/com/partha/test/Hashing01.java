package com.partha.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hashing01 {

	public static void main(String[] args) {
		
//		List<String> list= new LinkedList()<>();
//		for(int i=0;i<10;i++){
//			list.add(""+i);
//		}
		
		Set<String> myset= new HashSet<>();
		String s="FB";
		String f="Ea";
		System.out.println(s.hashCode()+" "+f.hashCode());
		myset.add(s);
		myset.add(f);
		System.out.println(myset.size());
		
//		System.out.println((int)"vartha".charAt(0));
//		System.out.println(118&15);
		
//		Map<String,String > mymap = new HashMap<>();
//		for(int i=0;i<2000;i++){
//			if(i==1999){
//				System.out.println("");
//			}
//			mymap.put(""+i, ""+i);
//		}
	}

}
