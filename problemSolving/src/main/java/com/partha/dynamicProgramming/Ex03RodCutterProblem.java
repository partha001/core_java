package com.partha.dynamicProgramming;

/**
 * @problemStatement:  you are given a rod of length n-inches and an array
 * 						of prices. this aray contains prices of smaller pieces of that rod when sold.
 * 						find the maximum value that could be earned by cutting up the 
 * 						rod and selling the pieces
 * 
 * @exampleInput : rod length=100 and input array = [0,2,4,5,7,11,13] for lengths 0,1,2,,,6 units
 * 
 * @author partha
 *
 */
public class Ex03RodCutterProblem {

	public static void main(String[] args) {

		int[] cost = {0, 2, 4, 7, 8};

		int size = 4;                
		// n is always 1 less than cost array length because 0th element is cost[0]
		System.out.println("Maximum value that can be earned by cutting up the rod and selling the pieces of the cost array {0, 2, 4, 7, 8} is: " + rodCutter(cost, size));
	}
	
	//solution from internet
	private static int rodCutter(int[] cost, int n){
		// Initializing rod array

		int[] rod = new int[n + 1];
		rod[0] = 0;

		// Loop for each rod length 'i'
		for(int i = 1; i <= n; i++){
			int maxValue = Integer.MIN_VALUE;
			// Loop for smaller cut lengths 'j'
			for(int j = 1; j <= i; j++){
				// Updating maxValue
				maxValue = Math.max(maxValue, cost[j] + rod[i - j]);
			}
			rod[i] = maxValue;

		}
		return rod[n];

	}
	

}
