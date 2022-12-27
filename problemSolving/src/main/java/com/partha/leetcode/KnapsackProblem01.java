package com.partha.leetcode;

/**
 * https://www.geeksforgeeks.org/java-program-for-dynamic-programming-set-10-0-1-knapsack-problem/
 * @author partha
 *
 */
public class KnapsackProblem01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * recursive approach . timeComplexity : O(2^n)
	 * @author partha
	 *
	 */
	private static class Solution1 {
		
		int knapsackRec(int[] w, int[] v, int n, int W) {
		    if (n <= 0) { 
		        return 0; 
		    } else if (w[n - 1] > W) {
		        return knapsackRec(w, v, n - 1, W);
		    } else {
		        return Math.max(knapsackRec(w, v, n - 1, W), v[n - 1] 
		          + knapsackRec(w, v, n - 1, W - w[n - 1]));
		    }
		}
	}
	
	
	/**
	 * time complexity : O(nW)
	 * dynamic programming solution
	 * @author partha
	 *
	 */
	private static class Solution2 {
		
		int knapsackDP(int[] w, int[] v, int n , int W) {
		    if (n <= 0 || W <= 0) {
		        return 0;
		    }

		    int[][] m = new int[n + 1][W + 1];
		    for (int j = 0; j <= W; j++) {
		        m[0][j] = 0;
		    }

		    for (int i = 1; i <= n; i++) {
		        for (int j = 1; j <= W; j++) { 
		            if (w[i - 1] > j) {
		                m[i][j] = m[i - 1][j];
		            } else {
		                m[i][j] = Math.max(
		                  m[i - 1][j], 
		                  m[i - 1][j - w[i - 1]] + v[i - 1]);
		            }
		        }
		    }
		    return m[n][W];
		}
		
	}

}
