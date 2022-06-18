package com.partha.problemSolving.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/target-sum/
 * @author partha
 *
 */
public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution {
	    public int findTargetSumWays(int[] nums, int target) {
	        HashMap<String,Integer> map = new HashMap<String,Integer>();
	        return helper(nums,target,nums.length-1,map);
	    }
	    
	    public int helper(int[] nums , int target, int index, HashMap<String,Integer> map)
	    {
	        if(index==-1)
	        {
	            if(target==0) // this is needed as if the target is met before the last Index it should 
				//return length with less that nums.length. Therefore the entire array needs to traversed.
	                return 1;
	            else
	                return 0;
	        }
	        if(map.containsKey(index+"/"+target)) // DP + Memoization. As many paths would overlap this checks reduces runtime. 
	            return map.get(index+"/"+target);
	        
			//below we are following a recursive solution to traverse all ways. 
			//Each nums[index] would be either subtracted or added to the target.
	        int add = helper(nums,target+nums[index],index-1,map);        
	        int subtract = helper(nums,target-nums[index],index-1,map);
	        
	        map.put(index+"/"+target,add+subtract);
	        return add+subtract;
	    }
	}

}
