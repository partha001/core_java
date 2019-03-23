package com.partha.problemSolving.numbers;

/**
 * @problemDefition : https://leetcode.com/problems/missing-number/
 * @leetCodeProblemNumber : 268
 * @author partha
 *
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = new int[]{0,1,2,4}
	}
	
	
	public static void findMisingNumber(int[] arr){
		int max= arr[0];
		
		int arrsum =0;
		for(int i=0;i<arr.length;i++){
			sum += arr[i];
			if(arr[i]> max)
				max= arr[i];
		}
		
		 sum = max*(max+1)/2;
		
	}

}
