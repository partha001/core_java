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
		 System.out.println(new Solution().firstMissingPositive(new int[]{3,4,-1,1}));

	}
	
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

}
