package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 * @author partha
 *
 */
public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @approach bruteForce [this will exceed time limit]
	 * @source leetcode official solution
	 * @author partha
	 * @TC O(S^n)
	 * @SC O(n)
	 *
	 */
	private class LeetcodeOfficialSolution1 {

		  public int coinChange(int[] coins, int amount) {
		    return coinChange(0, coins, amount);
		  }

		  private int coinChange(int idxCoin, int[] coins, int amount) {
		    if (amount == 0)
		      return 0;
		    if (idxCoin < coins.length && amount > 0) {
		      int maxVal = amount/coins[idxCoin];
		      int minCost = Integer.MAX_VALUE;
		      for (int x = 0; x <= maxVal; x++) {
		        if (amount >= x * coins[idxCoin]) {
		          int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
		          if (res != -1)
		            minCost = Math.min(minCost, res + x);
		        }
		      }
		      return (minCost == Integer.MAX_VALUE)? -1: minCost;
		    }
		    return -1;
		  }
		}

		
	
	
	/**
	 * approach2: Dynamic Programming top-down approach 
	 * @source leetcode official solution
	 * @TC O(S*n)
	 * @TC O(S)
	 */
	private static  class LeetcodeOfficialSolution2 {

		  public int coinChange(int[] coins, int amount) {
		    if (amount < 1) return 0;
		    return coinChange(coins, amount, new int[amount]);
		  }

		  private int coinChange(int[] coins, int rem, int[] count) {
		    if (rem < 0) return -1;
		    if (rem == 0) return 0;
		    if (count[rem - 1] != 0) return count[rem - 1];
		    int min = Integer.MAX_VALUE;
		    for (int coin : coins) {
		      int res = coinChange(coins, rem - coin, count);
		      if (res >= 0 && res < min)
		        min = 1 + res;
		    }
		    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		    return count[rem - 1];
		  }
		}
	
	
	/**
	 * approach2: Dynamic Programming Bottom-up approach 
	 * @source leetcode official solution
	 * @TC O(S*n)
	 * @TC O(S)
	 * @referrenceVideo https://www.youtube.com/watch?v=H9bfqozjoqs
	 */
	private static  class LeetcodeOfficialSolution3 {
		  public int coinChange(int[] coins, int amount) {
		    int max = amount + 1;
		    int[] dp = new int[amount + 1];
		    Arrays.fill(dp, max);
		    dp[0] = 0;
		    for (int i = 1; i <= amount; i++) {
		      for (int j = 0; j < coins.length; j++) {
		        if (coins[j] <= i) {
		          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
		        }
		      }
		    }
		    return dp[amount] > amount ? -1 : dp[amount];
		  }
		}

}
