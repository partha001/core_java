package com.partha.leetcode;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/
 * @author partha
 *
 */
public class LongestUncommonSusequence1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * TC O(N)
	 * SC O(1)
	 * @author partha
	 * 1. If the strings are the same, return -1, because there is no uncommon subsequence.
	 * 2. If the strings are different, return the length of the string that is longer, 
	 * because that string will always be an uncommon subsequence of the other string.
	 */
	private static class Solution {
	    public int findLUSlength(String a, String b) {
	       if(a.equals(b)){
	           return -1;
	       } 
	       return Math.max(a.length(),b.length());
	    }
	}

}
