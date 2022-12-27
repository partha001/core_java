package com.partha.arrays;

/**
 * @description: here also we are doing the brute-force approach i.e. find all possible sub-array sum
 * however we have slightly changed the order of the operation. i.e. instead of having subarraysize based loop 
 * as outermost we take subarray-index as the outermost loop.<br><br>
 * 
 * also we understand that subarraysum( for k elements ) = subarraysum( for k-1 elements )+ k-th element
 * thus we take a subArraySum variable
 * @complexity : O(n^2)
 * @author partha
 * @link : https://www.youtube.com/watch?v=ohHWQf1HDfU&vl=en
 *
 */
public class MaximumSubArraySum02 {

	public static void main(String[] args) {
		int[] arr= new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maximumSubArraySum(arr, arr.length));
	}
	
	/**
	 * this method prints the maximum subarray sum
	 * 
	 * @param arr : input array
	 * @param n : size of the input array
	 */
	public static int maximumSubArraySum(int arr[], int n){
		
		int result = Integer.MIN_VALUE;
		
		//loop for iterating over the start indexes
		for(int startIndex=0;startIndex < n ; startIndex++){
			
			int subArraySum =0;
			//loop for iterating every subarray sizes
			for(int subarraySize=1; subarraySize<=n;subarraySize++){
				
				//the below condition is avoid out of bound array index
				if(startIndex+ subarraySize> n)
					break;
				subArraySum = subArraySum +arr[startIndex + subarraySize -1];
				result = result < subArraySum ? subArraySum : result ;
			}		
		}
		
		return result;
	}

}
