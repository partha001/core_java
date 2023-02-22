package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * @author partha
 *
 */
public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * tc : O(N)
	 * sc : O(1)
	 */
	private static class Solution {
	    public List<String> summaryRanges(int[] nums) {
	       ArrayList<String> al=new ArrayList<>();
	        
	        for(int i=0;i<nums.length;i++){
	            int start=nums[i];
	            while(i+1<nums.length && nums[i]+1==nums[i+1])
	                i++;
	            
	            if(start!=nums[i]){
	                al.add(""+start+"->"+nums[i]);
	            }
	            else{
	                al.add(""+start);
	            }
	        }
	        return al;
	    }
	}

}
