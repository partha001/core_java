package com.partha.sets;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

	public static void main(String[] args) {
		int[] arr =new int[]{23, 33 , 45, 1 , 2 , 33 , 2};
		findFirstRecurringCharacterSolution1(arr);
		findFirstRecurringCharacterSolution2(arr);
	}
	
	/**
	 * this is the first most intutive approach that comes mind
	 * @Complexity : O(n ^ 2)
	 * @param arr
	 */
	public static void findFirstRecurringCharacterSolution1(int[] arr){
		boolean flag = false ;
		for(int i=0;i < arr.length-1;i ++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]==arr[j]){
					System.out.println("first recurring character is "+arr[i]);
					flag = true;
					break;
				}
				if(flag)
					break;
			}
		}
	}
	
	
	/**
	 * @comment :this is a better solution
	 * @timeComplexity : O(n)	 * 
	 * @param arr
	 */
	public static void findFirstRecurringCharacterSolution2(int[] arr){
		Set<Integer> set = new HashSet<>();
		for(int i=0 ; i < arr.length ; i++){
			if(!set.add(arr[i])){
				System.out.println("first recurring character is "+arr[i]);
				break;
			}
		}
	}

}
