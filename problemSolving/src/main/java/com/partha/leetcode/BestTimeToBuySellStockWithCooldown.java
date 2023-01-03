package com.partha.leetcode;

public class BestTimeToBuySellStockWithCooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @approach Dynamic Programming With State Machine
	 * @source Leetcode
	 * @TC O(n)
	 * @TC O(1)
	 * @author biswaspa
	 */
	private static class LeetcodeOfficialSolution1 {
		public int maxProfit(int[] prices) {

			int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

			for (int price : prices) {
				int preSold = sold;

				sold = held + price;
				held = Math.max(held, reset - price);
				reset = Math.max(reset, preSold);
			}

			return Math.max(sold, reset);
		}
	}
	
	/**
	 * @approach yet another dynamica programming approach
	 * @source Leetcode
	 * @TC O(N^2)
	 * @TC O(N)
	 * @author biswaspa
	 */
	private static class LeetcodeOfficialSolution2 {
		  public int maxProfit(int[] prices) {
		    int[] MP = new int[prices.length + 2];

		    for (int i = prices.length - 1; i >= 0; i--) {
		      int C1 = 0;
		      // Case 1). buy and sell the stock
		      for (int sell = i + 1; sell < prices.length; sell++) {
		        int profit = (prices[sell] - prices[i]) + MP[sell + 2];
		        C1 = Math.max(profit, C1);
		      }

		      // Case 2). do no transaction with the stock p[i]
		      int C2 = MP[i + 1];

		      // wrap up the two cases
		      MP[i] = Math.max(C1, C2);
		    }
		    return MP[0];
		  }
		}

}
