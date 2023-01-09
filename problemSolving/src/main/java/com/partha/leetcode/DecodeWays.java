package com.partha.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @source : https://leetcode.com/problems/decode-ways/
 * @author partha
 *
 */
public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/*
    recursive approach(s)
        if s is empty, return 1
        counts  = recurse using 1 char +
                  recurse using 2 chars     << check if it is possible to recurse using 2 chars - also validate that value is < 27
    --
    improve time complexity using dp top/down memoization
    dp cache is a hash map of key string and value integer containing the counts for a given string
	 */
	private static class Solution1 {

		public int numDecodings(String s) {
			return decodeWays(s, new HashMap<>());
		}

		private int decodeWays(String s, Map<String, Integer> dp){
			if(s.isEmpty()){
				return 1;
			}

			if(s.startsWith("0")){
				return 0;
			}

			if(dp.containsKey(s)){
				return dp.get(s);
			}

			int counts = decodeWays(s.substring(1), dp);
			if(s.length() > 1){
				int twoDigits = Integer.parseInt(s.substring(0,2));
				if(twoDigits < 27) {
					counts += decodeWays(s.substring(2), dp);
				}
			}

			dp.put(s, counts);

			return dp.get(s);
		}
	}


	/**************** leetcode official solutions *********************/	


	/**
	 * @approach recursive approach with memoization
	 * @author partha
	 *@TC O(N)
	 *@SC O(N)
	 */
	private static class LeetcodeOfficialSolution1 {

		Map<Integer, Integer> memo = new HashMap<>();

		public int numDecodings(String s) {
			return recursiveWithMemo(0, s);
		}

		private int recursiveWithMemo(int index, String str) {
			// Have we already seen this substring?
			if (memo.containsKey(index)) {
				return memo.get(index);
			}

			// If you reach the end of the string
			// Return 1 for success.
			if (index == str.length()) {
				return 1;
			}

			// If the string starts with a zero, it can't be decoded
			if (str.charAt(index) == '0') {
				return 0;
			}

			if (index == str.length() - 1) {
				return 1;
			}


			int ans = recursiveWithMemo(index + 1, str);
			if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
				ans += recursiveWithMemo(index + 2, str);
			}

			// Save for memoization
			memo.put(index, ans);

			return ans;
		}
	}




	/**
	 * @approach iterative with memoization
	 * @author partha
	 *@TC O(N)
	 *@SC O(N)
	 */
	private static class LeetcodeOfficialSolution2 {

		public int numDecodings(String s) {
			// DP array to store the subproblem results
			int[] dp = new int[s.length() + 1];
			dp[0] = 1;

			// Ways to decode a string of size 1 is 1. Unless the string is '0'.
			// '0' doesn't have a single digit decode.
			dp[1] = s.charAt(0) == '0' ? 0 : 1;

			for(int i = 2; i < dp.length; i++) {
				// Check if successful single digit decode is possible.
				if (s.charAt(i - 1) != '0') {
					dp[i] = dp[i - 1];  
				}

				// Check if successful two digit decode is possible.
				int twoDigit = Integer.valueOf(s.substring(i - 2, i));
				if (twoDigit >= 10 && twoDigit <= 26) {
					dp[i] += dp[i - 2];
				}
			}

			return dp[s.length()];
		}
	}



	/**
	 * @approach iterative with constant space
	 * @author partha
	 *@TC O(N)
	 *@SC O(1)
	 */
	private static class LeetcodeOfficialSolution3 {
		public int numDecodings(String s) {  
			if (s.charAt(0) == '0') {
				return 0;
			}

			int n = s.length();
			int twoBack = 1;
			int oneBack = 1;
			for (int i = 1; i < n; i++) {
				int current = 0;
				if (s.charAt(i) != '0') {
					current = oneBack;
				}
				int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
				if (twoDigit >= 10 && twoDigit <= 26) {
					current += twoBack;
				}

				twoBack = oneBack;
				oneBack = current;
			}
			return oneBack;
		}
	}

}
