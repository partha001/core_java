package com.partha.problemSolving.arrays;

/**
 * https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/
 * https://leetcode.com/problems/single-number/ 
 * this is just of opposite of the problem statement in the above link
 * [leetcode problem number : 136]
 * @author parbiswa
 *
 */
public class FindDuplicate {

	public static void main(String[] args) {
		int[] arr= new int[]{10,20,30,30};
		System.out.println("the duplicate number is = "+ findDuplicate(arr));
	}

	public static int findDuplicate(int[] arr){
		// Do OR of all elements and return 
		int res = arr[0]; 
		for (int i = 1; i < arr.length; i++) 
			res = res | arr[i]; 
		return res; 
	}
	
}
