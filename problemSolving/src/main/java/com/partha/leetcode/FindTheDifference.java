package com.partha.leetcode;

/**
 * https://leetcode.com/problems/find-the-difference
 * @author biswaspa
 *
 */
public class FindTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * TC: O(n)
	 * SC: O(1)
	 * doing XOR operation
	 * @author biswaspa
	 *
	 */
	class Solution {
	    public char findTheDifference(String s, String t) {

	        String str = s+t;
	        int n = 0;
	        for(int i =0; i<str.length(); i++) {
	            n ^= str.charAt(i);
	        }

	        return (char)n;
	    }
	}

}
