package com.partha.problemSolving.arrays;

/**
 * https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/
 * https://leetcode.com/problems/single-number/ 
 * [leetcode problem number : 136]
 * @author parbiswa
 *
 */
public class SingleNumber {

	public static void main(String[] args) {
		int[] arr= new int[]{10,20,30,20,10};
		System.out.println("the single number is = "+ findSingle(arr));
	}

	public static int findSingle(int[] arr){
		// Do XOR of all elements and return 
		int res = arr[0]; 
		for (int i = 1; i < arr.length; i++) 
			res = res ^ arr[i]; 
		return res; 
	}
	
}
