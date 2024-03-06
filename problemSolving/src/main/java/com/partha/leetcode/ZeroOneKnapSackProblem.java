package com.partha.leetcode;

/**
 * problem link : https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 * solution link:  https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * @author biswaspa
 *
 */
public class ZeroOneKnapSackProblem {

	//special note: it is to be remembered that the weight array need to be in ascending order
	//if its not in ascending order then sort it first.
	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 }; //value or pofit
		int wt[] = new int[] { 10, 20, 30 };  //weight of item
		int W = 50; //total capacity of the bag
		int n = val.length; //number of items and not index
		System.out.println(KnapsackSolution2.knapSack(W, wt, val, n));

	}

	/* A Naive recursive implementation
	of 0-1 Knapsack problem */
	// TC: O(2^n)
	// Auxilary space: O(1)
	private static class KnapsackSolution1 {

		// Returns the maximum value that
		// can be put in a knapsack of
		// capacity W
		public static int knapSack(int W, int wt[], int val[], int n)
		{
			// Base Case
			if (n == 0 || W == 0)
				return 0;

			// If weight of the nth item is
			// more than Knapsack capacity W,
			// then this item cannot be included
			// in the optimal solution
			if (wt[n - 1] > W)
				return knapSack(W, wt, val, n - 1);

			// Return the maximum of two cases:
			// (1) nth item included
			// (2) not included
			else
				return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), //knapsack for current element
						knapSack(W, wt, val, n - 1)); //knapsack for previous element
		}

	}



	// A Dynamic Programming based solution
	// for 0-1 Knapsack problem
	// TC:  O(N*W). 
	// SC: O(N*W). 
	private static class KnapsackSolution2 {

		// Returns the maximum value that can
		// be put in a knapsack of capacity W
		public static int knapSack(int W, int wt[],int val[], int n)
		{
			int[][] dp = new int[n + 1][W + 1];

			// Build table K[][] in bottom up manner
			for (int i = 0; i <= n; i++){
				for (int w = 0; w <= W; w++) {
					if (i == 0 || w == 0) { //case1:  when either item or weight is zero. this will fill up the first row and first col
						dp[i][w] = 0;
					} else if (wt[i - 1] <= w) { //caae2: when more weight can be added . then pick max( (currentWeight + dp[previousRow][remainingWeight]  or dp[adjacentTopCellValue]
						dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
					} else { //case3: dp[adjacentTopCellValue]
						dp[i][w] = dp[i - 1][w];
					}
				}
			}

			return dp[n][W];
		}

	}
	/**
	 * it is also to be noted that in the above solution we have taken the dp size as n+1,w+1 as to accomodate 0 elements and 0 capacity 
	 * it is because of this while reading current weight we are doing wt[i-1]
	 */


	// A Dynamic Programming based solution
	// for 0-1 Knapsack problem
	// TC:  O(N*W). 
	// SC: O(2*W). 
	// optimizing space complexity by using a 2 array of space 2*W
	private static class KnapsackSolution3 {

		// we can further improve the above Knapsack function's space
		// complexity
		public static int knapSack(int W, int wt[], int val[], int n)
		{

			int[][] dp = new int[2][W + 1];

			// We know we are always using the the current row or
			// the previous row of the array/vector . Thereby we can
			// improve it further by using a 2D array but with only
			// 2 rows i%2 will be giving the index inside the bounds
			// of 2d array K
			for (int i = 0; i <= n; i++) {
				for (int w = 0; w <= W; w++) {
					if (i == 0 || w == 0)
						dp[i % 2][w] = 0;
					else if (wt[i - 1] <= w)
						dp[i % 2][w] = Math.max(	val[i - 1]	+ dp[(i - 1) % 2][w - wt[i - 1]]
								, dp[(i - 1) % 2][w]);
					else
						dp[i % 2][w] = dp[(i - 1) % 2][w];
				}
			}
			return dp[n % 2][W];
		}

	}



	// Here is the top-down approach of  dynamic programming
	//using 1d array as timeComplexity
	// TC:  O(N*W). 
	// SC: O(W). 
	private static class KnapsackSolution4{


		public static int knapSack(int W, int wt[], int val[], int n)
		{
			// making and initializing dp array
			int []dp = new int[W + 1];


			for (int i = 1; i < n + 1; i++) {
				for (int w = W; w >= 0; w--) {

					if (wt[i - 1] <= w)

						// finding the maximum value
						dp[w] = Math.max(dp[w],   dp[w - wt[i - 1]] + val[i - 1]);
				}
			}
			return dp[W]; // returning the maximum value of knapsack
		}
	}


}
