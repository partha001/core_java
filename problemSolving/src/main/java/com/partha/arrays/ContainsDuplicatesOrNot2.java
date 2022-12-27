package com.partha.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicatesOrNot2 {

	public static void main(String[] args) {
		int[] arr = new int[]{23,12,45,2,12};
		System.out.println(containsDuplicates(arr));
		
	}

	public static boolean containsDuplicates(int[] arr){
		boolean result=false;
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;i++){
			if(set.contains(arr[i])){
				result = true;
				break;
			}else{
				set.add(arr[i]);
			}
		}
		return result;
	}

}
