package com.partha.problemSolving.arrays;

/**
 * @description :this is the brute-force-approach. i.e. we find all possible sub-array of different sizes
 * problem definition : https://leetcode.com/problems/maximum-subarray/description/
 * @complexity : O(n^3) 
 * @link: https://www.youtube.com/watch?v=ohHWQf1HDfU&vl=en 
 * @author partha
 *
 */
public class MaximumSubArraySum01 {

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
		
		//the below loop is  iterating of all possible sub array sizes
		for(int subArraySize =1 ; subArraySize <=n; subArraySize++){
			
			//the below  loop is iterating over all possible start indices
			for(int startIndex=0;startIndex <n; startIndex++){
				
				if(startIndex+ subArraySize > n) //subarray exceeds array bound
					break;
				
				int sum =0;
				//below loop calculates sum for every valid subarray
				for(int i = startIndex ; i < (startIndex+ subArraySize);i++){
					sum = sum+arr[i];
				}
				
				result = sum > result ? sum : result;				
			}
		}
		
		return result;
	}

}
