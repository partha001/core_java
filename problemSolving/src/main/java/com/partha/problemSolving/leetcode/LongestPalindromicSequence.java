package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/ 
 * @author biswaspa
 *
 */
public class LongestPalindromicSequence {

	public static void main(String[] args) {
		System.out.println(new Solution1().longestPalindromeSubseq("cbbd"));
	}

	/**
	 * using recursion
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {

		public int longestPalindromeSubseq(String s) {
			if(s==null || s.length()==0)
				return 0;
			if(s.length()==1)
				return 1;
			return lps(s, 0, s.length() -1);
		}


		int lps(String s, int low, int high){

			if(low == high){
				return 1;
			}
			else if(s.charAt(low) == s.charAt(high) && (high - low) == 1){
				return 2;
			}
			else if(s.charAt(low)== s.charAt(high) && (high-low)>1){
				return 2 + lps(s, low+1, high-1);
			}
			else
				return Math.max(lps(s, low+1, high), lps(s, low, high-1));
		}

	}



	/**
	 * solution using dp
	 * timeComplexity : n^2 and spaceComplexity: n^2
	 */
	private static class Solution2 {

		public int longestPalindromeSubseq(String s) {
			int[][] dp = new int[s.length()][s.length()];
			for(int gap=0;gap<s.length();gap++) {
				for(int left=0;left<s.length()-gap;left++) {
					int right = left + gap;
					if(gap==0) {
						dp[left][right]=1;
					}else if(gap==1) {
						if(s.charAt(left)==s.charAt(right))
							dp[left][right] = 2;
						else
							dp[left][right] = 1;
					}else {
						if(s.charAt(left)==s.charAt(right)) {
							dp[left][right] = 2 + dp[left+1][right-1];
						}else {
							dp[left][right] = Math.max(dp[left+1][right], dp[left][right-1]);
						}
					}
				}
			}
			return dp[0][s.length()-1];
		}

	}





}
