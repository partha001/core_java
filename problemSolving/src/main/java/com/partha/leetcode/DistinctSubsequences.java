package com.partha.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 * @author biswaspa
 *
 */
public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * @approach: recursion + memoization
	 * @source leetcode official solution
	 * @TC O(M*N)
	 * @SC  O(M*N)
	 * @author biswaspa
	 *
	 */
	private static class LeetcodeOfficialSolution1 {

		// Dictionary that we will use for memoization
		private HashMap<Map.Entry<Integer, Integer>, Integer> memo;

		private int recurse(String s, String t, int i, int j) {

			int M = s.length();
			int N = t.length();

			// Base case
			if (i == M || j == N || M - i < N - j) {
				return j == t.length() ? 1 : 0;
			}

			Map.Entry<Integer, Integer> key = Map.entry(i, j);

			// Check to see if the result for this recursive  call is already cached
			if (this.memo.containsKey(key)) {
				return this.memo.get(key);
			}

			// Always calculate this result since it's required for both the cases
			int ans = this.recurse(s, t, i + 1, j);

			// If the characters match, then we make another recursion call and add the result to "ans"
			if (s.charAt(i) == t.charAt(j)) {
				ans += this.recurse(s, t, i + 1, j + 1);
			}

			// Cache the result
			this.memo.put(key, ans);
			return ans;
		}

		public int numDistinct(String s, String t) {

			this.memo = new HashMap<Map.Entry<Integer, Integer>, Integer>();        
			return this.recurse(s, t, 0, 0);
		}
	}	



	/**
	 * @approach: itarative dynamic programming
	 * @source leetcode official solution
	 * @TC O(M*N)
	 * @SC  O(M*N)
	 * @author biswaspa
	 *
	 */
	private static class LeetcodeOfficialSolution2 {

		public int numDistinct(String s, String t) {

			int M = s.length();
			int N = t.length();

			int[][] dp = new int[M + 1][N + 1];

			// Base case initialization
			for (int j = 0; j <= N; j++) {
				dp[M][j] = 0;
			}

			// Base case initialization
			for (int i = 0; i <= M; i++) {
				dp[i][N] = 1;
			}

			// Iterate over the strings in reverse so as to satisfy the way we've modeled our recursive solution
			for (int i = M - 1; i >= 0; i--) {
				for (int j = N - 1; j >= 0; j--) {

					// Remember, we always need this result
					dp[i][j] = dp[i + 1][j];

					// If the characters match, we add the result of the next recursion call (in this case, the value of a cell in the dp table
					if (s.charAt(i) == t.charAt(j)) {
						dp[i][j] += dp[i + 1][j + 1];
					}
				}
			}

			return dp[0][0];
		}
	}


	/**
	 * @approach: space optimized dynamic programming
	 * @source leetcode official solution
	 * @TC O(M*N)
	 * @SC  O(N)
	 * @author biswaspa
	 *
	 */
	private static class LeetcodeOfficialSolution3 {

		public int numDistinct(String s, String t) {

			int M = s.length();
			int N = t.length();

			int[] dp = new int[N];

			int prev = 1;

			// Iterate over the strings in reverse so as to satisfy the way we've modeled our recursive solution
			for (int i = M - 1; i >= 0; i--) {

				// At each step we start with the last value in the row which is always 1. Notice how we are
				// starting the loop from N - 1 instead of N like in the previous solution.
				prev = 1;

				for (int j = N - 1; j >= 0; j--) {

					// Record the current value in this cell so that we can use it to calculate the value of dp[j - 1]
					int old_dpj = dp[j];

					// If the characters match, we add the result of the next recursion call (in this
					// case, the value of a cell in the dp table
					if (s.charAt(i) == t.charAt(j)) {
						dp[j] += prev;
					}

					// Update the prev variable
					prev = old_dpj;    
				}
			}

			return dp[0];
		}
	}

}
