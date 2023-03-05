package com.partha.leetcode;

/**
 * https://leetcode.com/problems/ones-and-zeroes
 * @author partha
 *
 */
public class OnesAndZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution1 {
	    public int findMaxForm(String[] strs, int m, int n) {
	        int[][] arr = new int[m+1][n+1];
	        
	        for(String str : strs){
	            int c0 = 0;
	            int c1 = 0;
	            
	            for(char c : str.toCharArray()){
	                if(c == '0') c0++;
	                else c1++;
	            }
	            
	            for(int i=m;i>=c0;i--){
	                for(int j=n;j>=c1;j--){
	                    arr[i][j] = Math.max(arr[i][j],arr[i-c0][j-c1] + 1);
	                }
	            }
	        }
	        return arr[m][n];
	    }
	}
	
	
	/**
	 * zero one knapsack approach
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    int[] zeroes;
	    int[] ones;
	    int[][][] dp;
	    
	    public int findMaxForm(String[] strs, int m, int n) {
	        // knapsack
	        // set of remaining strings, m, n -> largest subset
	        dp = new int[m+1][n+1][strs.length];
	        zeroes = new int[strs.length];
	        ones = new int[strs.length];
	        for (int i = 0; i < strs.length; i++) {
	            zeroes[i] = getCount(strs[i], '0');
	            ones[i] = getCount(strs[i], '1');
	        }
	        return knapsack(m, n, 0);
	        
	    }
	    
	    private int knapsack(int m, int n, int index) {
	        if (m < 0 || n < 0) {
	            return -1;
	        }
	        if (index >= zeroes.length) {
	            return 0;
	        }
	        if (dp[m][n][index] != 0) {
	            return dp[m][n][index];
	        }
	        int subsetCount = Math.max(1+knapsack(m-zeroes[index], n-ones[index], index+1), knapsack(m, n, index+1));
	        dp[m][n][index] = subsetCount;
	        return subsetCount;
	    }
	    
	    private int getCount(String s, char bit) {
	        int count = 0;
	        for (char c : s.toCharArray()) {
	            if (bit == c) {
	                count += 1;
	            }
	        }
	        return count;
	    }
	}

}
