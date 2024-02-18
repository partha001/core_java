package com.partha.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * @author partha
 *
 */
public class SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * https://www.youtube.com/watch?v=fFVZt-6sgyo
	 * @author partha
	 *
	 */
	 static class Solution1 {
	    public int subarraySum(int[] nums, int k) {
	        int result =0;
	        int currentSum =0;
	        Map<Integer, Integer> map = new HashMap<Integer,Integer>(); //key: prefixSum and value:count [as the prefix sum can occur in multiple subarrays in the prefix]
	        map.put(0,1);
	        for(int i : nums){
	            currentSum += i;
	            int difference = currentSum -k;
	            result += map.getOrDefault(difference,0);
	            map.put(currentSum , map.getOrDefault(currentSum,0)+1);
	        }
	        return result;
	    }
	}

}
