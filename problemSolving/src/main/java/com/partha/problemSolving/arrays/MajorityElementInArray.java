package com.partha.problemSolving.arrays;

import java.util.HashMap;

/**
 * @problemDefinition : https://leetcode.com/problems/majority-element/
 * @leetCodeProbNumber : 169
 * @author partha
 *
 */
public class MajorityElementInArray {

	public static void main(String[] args) {
		int[] arr = new int[]{1,1,2,2,2,2,2};
		findMajority(arr);
		
	}
	
	public static void findMajority(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++)
			map.put(arr[i], map.containsKey(arr[i])? map.get(arr[i])+1: 1);
		
		boolean majorityExists = false;
		int number = -1;
		for(Integer i: map.keySet()){
			if(map.get(i)>= arr.length/2){
				majorityExists = true;
				number =  i;
				break;
			}
		}
		System.out.println( majorityExists ? " majority exits="+ majorityExists + " and the number is="+ number:"majority doesnt exist");
	}

}
