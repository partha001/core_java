package com.partha.problemSolving.stringRelated;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any string");
		String enteredString = sc.nextLine();
		findFirstNonRepeatingCharacter(enteredString);
	}
	
	
	/**
	 * algo: taking character occurance count from left to right in a map
	 * 		 to preserve the left to right ordering using linkedhashmap
	 * 		 finally traversing the map to see if there is any character present with count 1 or not
	 * @param s
	 */
	public static void findFirstNonRepeatingCharacter(String s){
		Map<Character, Integer> map=new LinkedHashMap<>();
		
		for(char c: s.toCharArray()){
			map.put(c, map.containsKey(c)?map.get(c)+1:1);
		}
		
		
		boolean isFirstNonRepeatingCharPresent =false;
		for(char c:map.keySet()){
			if(map.get(c)==1){
				System.out.println("first non-repeating character is :"+c);
				isFirstNonRepeatingCharPresent=true;
				break;
			}
		}
		
		if(!isFirstNonRepeatingCharPresent)
			System.out.println("no non-repeating character present");
		
	}

}
