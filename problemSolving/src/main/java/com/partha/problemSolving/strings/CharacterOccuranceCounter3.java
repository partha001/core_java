package com.partha.problemSolving.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
	
/**
 * take an input string . count occurance of character and then print in the ascending order of occurance
 * @author partha
 * sampleinput1: partha
 */
public class CharacterOccuranceCounter3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter any string");
		String input = sc.nextLine();
		operation(input);


	}


	public static  void operation(String input){
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		for(Character c: input.toCharArray()){
			map1.put(c, map1.containsKey(c)? map1.get(c)+1 : 1);
		}


		//		// imparative approach		
		//		TreeSet<MyClass> myset = new TreeSet<MyClass>();
		//		for(Character c: map1.keySet()){
		//			MyClass item = new MyClass(map1.get(c), c);
		//			myset.add(item);
		//		}

		
		//		//functional approach		
		Set<MyClass> myset=  map1.keySet().stream()
				.map(key ->  new MyClass(map1.get(key),key))
				.collect(
						()-> new TreeSet<>() //supplier
						,(set , item)-> set.add(item) //accumulator
						,(set1, set2)-> set1.addAll(set2) //combiner
						);


		myset.stream().
		forEach(item -> System.out.println(item.count + "   "+ item.c));

	}


	static class MyClass implements Comparable<MyClass>{
		int count;
		char c;

		public MyClass(int count, char c) {
			super();
			this.count = count;
			this.c = c;
		}

		@Override
		public int compareTo(MyClass o) {
			int result = 0;
			if(this.count>=o.count)
				result =1 ;
			else if(this.count< o.count)
				result = -1;
			return result;
		}


	}

}
