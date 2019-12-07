package com.partha.problemSolving.dynamicProgramming;

/**
 * problem statement : in how many ways totalNoOfStairsToClimb can be climbed if the climber
 * 						can climb either 1 step or 2 steps at a time.
 * @author partha
 *
 */
public class Ex01StairwayToHeaven {

	public static void main(String[] args) {
		int totalNoOfStairsToClimb = 3;
		System.out.println("Number of ways to reach heaven with  stairs is " + stairwayToHeaven(totalNoOfStairsToClimb));
	}


	// Assuming 'n' is not below 1
	private static int stairwayToHeaven(int n){

		// Initializing ways array
		int[] ways = new int[n + 1];
		
		//setting the values for base cases
		ways[0] = 1; //ways to climb 0 stairs is 1 . since we are already there
		ways[1] = 1; //ways to climb 1 stairs is 1 .

		//starting the loop from 2 since we have already stored 2 base case results
		for(int i = 2; i <= n; i++){
			ways[i] = ways[i - 1] + ways[i - 2];
		}
		
		return ways[n];
	}


}

/*
 * note: we have initialized the array with size n+1 is because 
 * n can be found in (n-1) ways since starting from 0 .
 * now since we have two base cases to that adds up to n+1
 * 
 */
