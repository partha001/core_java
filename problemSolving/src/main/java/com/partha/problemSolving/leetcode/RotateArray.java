package com.partha.problemSolving.leetcode;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/rotate-array/
 * @author biswaspa
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		new Solution1().rotate(new int[] {10,11,12},1);
	}


	/**
	 * @algorithm first picking up d elements from front to a temporary array<br>
	 * then shifting the remaining elements in the array.<br>
	 * finally adding the temp array elements to the back of real array starting frm index n-d
	 * @param arr
	 * @param d
	 */
	public static void rotateArray(int[] arr, int d){
		int[] temparr = new int[d];
		IntStream.range(0, d).forEach(i -> temparr[i]=arr[i]);

		for(int i= d ; i <arr.length; i++){
			arr[i-d]=arr[i];
		}

		int c=0;
		for(int i=arr.length-d;i<arr.length;i++){
			arr[i]=temparr[c++];
		}

		System.out.println("hi");
	}



	//this is the more elegant solution
	static class Solution1 {

		public void rotate(int[] nums, int k) {
			int[] temparr = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				temparr[(i + k) % nums.length] = nums[i];
			}
			
			//just copying from the temp array
			for (int i = 0; i < nums.length; i++) {
				nums[i] = temparr[i];
			}

			IntStream.range(0, nums.length).forEach(i -> System.out.println(nums[i]));
		}
	}


}
