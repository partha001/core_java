package com.partha.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * two sum problem 
 * https://leetcode.com/problems/two-sum/
 * @author biswaspa
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		//System.out.println(new SolutionTest().twoSum(new int[] {3,2,4}, 6));
	}

	/**
	 * method : brute-force
	 * TimeComplexity : O(nxn)
	 * MemoryComplexity : O(1)
	 * @author biswaspa
	 *
	 */
	private static class Solution {
	    public int[] twoSum(int[] nums, int target) {
	       for(int i=0;i<nums.length-1;i++){
	           for(int j=i+1;j<nums.length;j++){
	               if(nums[i]+nums[j]==target)
	                   return new int[]{i,j};
	           }
	       }
	        return new int[2];
	    }
	}
	
	
	/**
	 * method: one pass
	 * TimeComplexity : O(n)
	 * spaceComplexity : O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution3 {
		
		public int[] twoSum(int[] nums, int target) {
		    Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        if (map.containsKey(complement)) {
		            return new int[] { map.get(complement), i };
		        }
		        map.put(nums[i], i);
		    }
		    throw new IllegalArgumentException("No two sum solution");
		}
		
	}
	
	
	/**
	 * however if the array is sorted then two pointer approach can be used
	 * @author biswaspa
	 *
	 */
	static class Solution4 {
		
		public int[] twoSum(int[] nums, int target) {
			Arrays.sort(nums);
			
			int left=0;
			int right=nums.length-1;
			while(left<right) {
				int sum=nums[left]+nums[right];
				if(sum==target) {
					return new int[] {left,right};
				}else if(sum<target) {
					left++;
				}else {
					right--;
				}
			}
			throw new RuntimeException("no such pair found");
		}
	}


}
