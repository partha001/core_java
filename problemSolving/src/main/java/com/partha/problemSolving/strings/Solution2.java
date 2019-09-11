package com.partha.problemSolving.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution2 {

	public static void main(String[] args) {

		String[] arr=new String[]{"U1,U2","U3,U4","U2,U1","U1,U5"};
	    compareFriends(Arrays.asList(arr));

	}

	/**
	 * the below method is the solution
	 * @param frndsList
	 * @return
	 */
	public static List<String> compareFriends(List<String> frndsList){
		List<String> result = new ArrayList<String>();
		Set<String> set = new TreeSet<>();

		for(String s:frndsList){

			String person1 = s.substring(0, s.indexOf(","));
			String person2 = s.substring(s.indexOf(",")+1, s.length());

			if(person2.compareTo(person1)>0){
				if(!set.contains(s)){
					set.add(s);
				}
			}else{
				if(!set.contains(person2+","+person1))
					set.add(s);
			}

		}
		result = set.stream().collect(Collectors.toList());
		return  result;
	}
}
