package com.partha.strings;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {

	public static void main(String[] args) {
		processStrings("ABC","BC");
		processStrings("BC","BANGALORE");

	}

	/**
	 * the below is the required solution method
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static List<String> processStrings(String str1,String str2){
		List<String> result = new ArrayList<String>();
		String s1 = "";
		String s2 = "";
		Set<Character> set = new LinkedHashSet<Character>();
		
		for(Character c: str1.toCharArray()){
			set.add(c);
		}
		for(Character c:str2.toCharArray()){
			set.remove(c);
		}
		for(Character c:set){
			s1+=c;
		}
		
		set.clear();
		for(Character c: str2.toCharArray()){
			set.add(c);
		}
		for(Character c:str1.toCharArray()){
			set.remove(c);
		}
		for(Character c:set){
			s2+=c;
		}

		result.add(s1);
		result.add(s2);


		return result;

	}

}
