package com.partha.problemSolving.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * @author partha
 *
 */
public class FirstMissingPositive {

	public static void main(String[] args) {
		 System.out.println(new Solution2().firstMissingPositive(new int[]{-1,1,2,3}));

	}
	
	/**
	 * timeComplexity : O(n) 
	 * spaceComplexity: n
	 * @author partha
	 *
	 */
	private static class Solution {
	    public int firstMissingPositive(int[] nums) {
	       Set<Integer> set = new HashSet();
	        for(int i: nums){
	            if(i>0 && i<Integer.MAX_VALUE){
	                set.add(i);
	            }
	        }
	        
	        if(!set.contains(1)){
	            return 1;
	        }
	        
	        int result = Integer.MAX_VALUE;
	        for(int i:set){
	            if(!set.contains(i+1))
	                result = Math.min(result , i+1);
	        }
	        return result;
	    }
	}
	
	/**
	 * this is a better solution since its a constant space solution
	 * timeComplexity : O(n) 
	 * spaceComplexity: 1
	 * @author partha
	 *
	 */
	private static class Solution2 {
		static int firstMissingPositive(int[] arr){
		        int i=0;
		        //note that while loop is used since increment happens only if there is no-swap. 
		        // else loop starts from same index thereby reattempting to newly swaped value to be placed in the correct place
		        while(i<arr.length){
		            // correct is the index where the ith element should actually be
		            int correct = arr[i] - 1;
		            if(arr[i]>0 && arr[i]<=arr.length && arr[i]!=arr[correct]){ /* First condition: Ignoring the negatives Second condition: If element=length of the array, just ignore it and move ahead */
		                swap(arr,i,correct); // swap if not at the correct position
		            }else{
		                i++; // else move ahead
		            }
		        }

		        // search for first missing number
		        for (int index = 0; index < arr.length; index++) {
		            if(arr[index]!=index + 1){
		                return index + 1;
		            }
		        }

		        // case 2
		        return arr.length + 1;
		    }

		    static void swap(int[] arr, int first, int second){
		        int temp=arr[first];
		        arr[first]=arr[second];
		        arr[second]=temp;
		    }
		}

}
