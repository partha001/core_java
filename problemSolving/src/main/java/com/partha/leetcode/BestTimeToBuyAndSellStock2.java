package com.partha.leetcode;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author partha
 *
 */
public class BestTimeToBuyAndSellStock2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution {
	    public int maxProfit(int[] prices) {
	      int max=0;
	        for(int i=1 ; i<prices.length ; i++)
	        {
	            if(prices[i]>prices[i-1])
	            {
	            	max = max + ( prices[i] -prices[i-1] );
	            	//it can also be written as max+=prices[i] -prices[i-1]
	            }
	        }
	        return max;
	    }
	}

}
