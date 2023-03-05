package com.partha.leetcode;

/**
 * https://leetcode.com/problems/repeated-substring-pattern
 * @author partha
 *
 */
public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Time complexity: O(n^2)
	 * SC: O(n)
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    public boolean repeatedSubstringPattern(String s) {
	        String text = s + s;
	        String pattern = s;
	        int pos = text.indexOf(pattern, 1);
	        if (pos != -1 && pos < s.length())
	            return true;
	        return false;
	    }
	}
	
	/**
	 * https://leetcode.com/problems/repeated-substring-pattern/solutions/1694256/java-kmp-solution-with-explanation/
	 * @author partha
	 * KMP algorithm
	 *
	 */
	class Solution {
	    public boolean repeatedSubstringPattern(String s) {
	        int n = s.length(), prevLPS = 0, i = 1;
	        int[] lps = new int[n];
	        while (i < n) {
	            if (s.charAt(i) == s.charAt(prevLPS)) {
	                lps[i++] = ++prevLPS;
	            } else if (prevLPS == 0) {
	                lps[i++] = 0;
	            } else {
	                prevLPS = lps[prevLPS - 1];
	            }
	        }
	        return lps[n - 1] > 0 && n % (n - lps[n - 1]) == 0;
	    }
	}


}
