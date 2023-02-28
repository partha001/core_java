package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups
 * @author biswaspa
 *
 */
public class PositionsOfLargeGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * TC O(N)
	 * SC O(1)
	 * @author biswaspa
	 *
	 */
	private static class Solution {
	    public List<List<Integer>> largeGroupPositions(String s) {
	       List<List<Integer>> result = new ArrayList();
	       int i=0;
	       while(i<s.length()){
	           char c = s.charAt(i);
	           int count=0;
	           int start=i;
	           int end=i;
	           while(i<s.length() && s.charAt(i)==c){
	                end=i;
	                i++;
	                count++;
	           }

	           if(count>=3){
	            List<Integer> list = new ArrayList(Arrays.asList(start,end));
	             result.add(list);
	           }
	            
	       }
	       return result;
	    }
	}

}
