package com.partha.problemSolving.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * @author partha
 *
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int[] topKFrequent(int[] nums, int k) {
	        int[] result = new int[k];
	        if(nums.length==0)
	            return result;
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<nums.length;i++){
	            map.put(nums[i],map.getOrDefault(nums[i], 0).intValue()+1);
	        }
	        
	        return result;
	    }
	}

}
