package com.partha.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuySellStockWithCooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution1().maxProfit(new int[] {1,2,4}));
	}
	
	
	/**
	 * solution not working . there is some bug which has to be debugged and fixed
	 * @video https://www.youtube.com/watch?v=I7j0F7AHpb8
	 * 
	 */
	private static class Solution1 {
	    public int maxProfit(int[] prices) {
	        Map<String,Integer> map = new HashMap(); //key:dayIndex+canBuy 
	        return dfs(prices, 0, true, map);
	    }


	    private int dfs(int[] prices, int index, boolean canBuy,Map<String,Integer> map ){
	        if(index >= prices.length)
	            return 0;
	        
	        String currentKey="day:"+index+"canBuy:"+canBuy;
	        if(map.containsKey(currentKey))
	            return map.get(currentKey);
	        
	        if(canBuy){
	            int buy = dfs(prices, index+1, false, map) - prices[index];
	            int cooldown = dfs(prices, index+1, true, map);
	            map.put(currentKey, Math.max(buy, cooldown));
	        }else{
	            int sell = dfs(prices, index+2, false, map) + prices[index];
	            int cooldown = dfs(prices, index+1, true, map);
	            map.put(currentKey, Math.max(sell, cooldown));
	        }
	        return map.get(currentKey);
	    }

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
