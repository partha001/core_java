package com.partha.problemSolving.stringRelated;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * uses map to maintain character and its count
 */
public class CharacterOccuranceCounter1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any string");
		String enteredString = sc.nextLine();
		countOccurance(enteredString);
	}
	
	
	public static void countOccurance(String enteredString){
		Map<Character, Integer> map=new HashMap<>();
		for(char c: enteredString.toCharArray()){
			map.put(c, map.containsKey(c)?map.get(c)+1:1);
		}
		
		for(Character c: map.keySet()){
			System.out.println("character: "+c+"    occurance_count: "+map.get(c));
		}
		
		
	}

}
