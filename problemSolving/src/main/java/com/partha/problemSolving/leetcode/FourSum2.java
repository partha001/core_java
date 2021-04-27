package com.partha.problemSolving.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/4sum-ii/
 * @author partha
 *
 */
public class FourSum2 {

	public static void main(String[] args) {
	}
	
	
	private static class Solution {
	    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
	        Map<Integer,Integer>  map = new HashMap();
	        int result = 0;
	        for(Integer num1: nums1){
	            for(Integer num2: nums2){
	                map.put( num1 + num2 , map.getOrDefault(num1 + num2,0)+1);
	            }
	        }
	        
	        
	         for(Integer num3: nums3){
	            for(Integer num4: nums4){
	                result = result +  map.getOrDefault( (num3 + num4) * -1, 0 );
	            }
	        }
	        return result;
	    }
	}

}
