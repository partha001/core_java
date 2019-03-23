package com.partha.problemSolving.arrays;

import java.util.stream.IntStream;

/**
 * @link : https://leetcode.com/problems/move-zeroes/description/
 * @comments : this is self-written solution.
 * @complexity : O(n)
 * @author partha
 *
 */
public class MoveZeroes01 {

	public static void main(String[] args) {
		int[] arr= new int[]{4,0,3,0,2};
		 int n = arr.length; 
	     pushZerosToEnd(arr, n); 
	     IntStream.range(0, n).forEach(i -> {
	    	 System.out.print(arr[i] + " ");
	     });
	}


	/**
	 * 
	 * @param arr = input array
	 * @param n = length of the array
	 */
    static void pushZerosToEnd(int arr[], int n) 
    { 
    	  int count = 0;  // Count of non-zero elements 
    	  
          // Traverse the array. If element encountered is 
          // non-zero, then replace the element at index 'count' 
          // with this element 
          for (int i = 0; i < n; i++) 
              if (arr[i] != 0) 
                  arr[count++] = arr[i]; // here count is 
                                         // incremented 
    
          // Now all non-zero elements have been shifted to 
          // front and 'count' is set as index of first 0. 
          // Make all elements 0 from count to end. 
          while (count < n) 
              arr[count++] = 0; 
    } 
  

}
