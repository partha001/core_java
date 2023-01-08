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
	 * https://www.youtube.com/watch?v=ruMqWViJ2_U
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    public int change(int amount, int[] coins) {
	        int rows = coins.length+1;
	        int cols = amount+1;
	        int[][] cache = new int[rows][cols]; //sum =row, and coins=cols
	       //filling the first columns
	       for(int i=0;i<rows;i++)
	            cache[i][0] = 1; //i.e. in how many ways 0 amount can be achieved

	        //now filling the cache
	        for(int i=1;i<rows;i++){
	            for(int j=1;j< cols; j++){
	                //here we have 2 possiblities i.e. to include current coin or not
	                if(j>= coins[i-1])  //ie if we include the current coin
	                    cache[i][j] = cache[i][j-coins[i-1]] + cache[i-1][j];
	                else //i.e. current cant be included
	                    cache[i][j] = cache[i-1][j];

	            }
	        }

	        return cache[rows-1][cols-1];
	        
	    }
	}
	
	
	/**
	 * @source leetcode official solution
	 * @author partha
	 * @TC O(N*amount)
	 * @SC: O(amount)
	 * @referrenceVideo: https://www.youtube.com/watch?v=Mjy4hd2xgrs
	 */
	private static class LeetcodeOfficialSolution1 {
		  public int change(int amount, int[] coins) {
		    int[] cache = new int[amount + 1];
		    cache[0] = 1;

		    for (int coin : coins) {
		      for (int x = coin; x < amount + 1; ++x) {
		        cache[x] += cache[x - coin];
		      }
		    }
		    return cache[amount];
		  }
		}

}
