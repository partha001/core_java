package com.partha.leetcode;

/**
 * https://leetcode.com/problems/coin-change-ii
 * @author partha
 *
 */
public class CoinChange2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * @source leetcode official solution
	 * @author partha
	 * @TC O(N*amount)
	 * @SC: O(amount)
	 */
	private static class Solution {
		  public int change(int amount, int[] coins) {
		    int[] dp = new int[amount + 1];
		    dp[0] = 1;

		    for (int coin : coins) {
		      for (int x = coin; x < amount + 1; ++x) {
		        dp[x] += dp[x - coin];
		      }
		    }
		    return dp[amount];
		  }
		}

}
