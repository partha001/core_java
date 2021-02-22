package com.partha.problemSolving.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {

	}
	
	
	static class Solution1 {
	    public boolean containsDuplicate(int[] nums) {
	        Set<Integer> set = new HashSet<>();
	        for(int i=0;i<nums.length;i++){
	            if(set.contains(nums[i])){
	                return true;
	            }else{
	                set.add(nums[i]);
	            }
	        }
	        return false;
	    }
	}
	
	
	static class Solution2 {
	    public boolean containsDuplicate(int[] nums) {
	        
	        Set<Integer> set = new HashSet<Integer>();
	        
	        for (int i : nums) {
	            if (set.contains(i)) {
	                set.remove(i);
	            }
	            else {
	                set.add(i);
	            }
	        }
	        
	        return set.size() != nums.length;
	        
	    }
	}

}
