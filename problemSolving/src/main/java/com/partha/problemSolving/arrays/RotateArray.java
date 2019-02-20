package com.partha.problemSolving.arrays;

import java.util.stream.IntStream;

/**
 * rotate array by d elements
 * @problem_definition  https://leetcode.com/problems/rotate-array/description/
 * @solution_link: https://www.geeksforgeeks.org/array-rotation/
 * @author parbiswa
 * @complexity : time complexity :O(n)<br>
 * space complexity : O(d)
 *
 */
public class RotateArray {

	public static void main(String[] args) {

		int[] arr= new int[]{4,0,3,0,2};
		 int n = arr.length; 
		 rotateArray(arr, 2); 
	     IntStream.range(0, n).forEach(i -> {
	    	 System.out.print(arr[i] + " ");
	     });
	

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

}
