package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 * @author biswaspa
 *
 */
public class CombinationSum4 {

	public static void main(String[] args) {
		System.out.println(new Solution1().combinationSum4(new int[] {1, 2, 3}, 3));
	}
	

	static class Solution1 {
	    public int combinationSum4(int[] nums, int target) {
	        Arrays.sort(nums);
	        List<List<Integer>> result = new ArrayList();
	        List<Integer> sublist = new ArrayList();
	        combination(nums,target,result,sublist,0,0);
	        return result.size();
	    }
	    
	    
	    public void combination(int[] nums, 
	                            int target,
	                            List<List<Integer>> result , 
	                            List<Integer> sublist,
	                           int sum,
	                           int start){
	        if(sum==target){
	            result.add(new ArrayList(sublist));
	            return;
	        }
	        if(sum>target){
	            return;
	        }
	        if(sum<target){
	            for(int i=start;i<nums.length;i++){
	                sublist.add(nums[i]);
	                combination(nums,target,result,sublist,sum+nums[i],start);
	                sublist.remove(sublist.size()-1);                    
	            }
	            
	        }
	    }
	}
}
