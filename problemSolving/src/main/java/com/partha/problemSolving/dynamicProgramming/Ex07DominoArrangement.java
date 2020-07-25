package com.partha.problemSolving.dynamicProgramming;

/**
 * @problemStatement: you are given a 2xN grid and infinite domino of size 1x2 . 
 * 						Find the number of ways in which you can fill this grid using this dominos
 * @author biswaspa
 *
 */
public class Ex07DominoArrangement {

	public static void main(String[] args) {
		countWays(5);
	}
	
	/**
	 * 2 x n grid that we have to tile
	 * @param n
	 */
	public static void countWays(int n) { 
		int[] arr= new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		//arr[2] = 2;
		for(int i=2; i<n+1;i++) {
			arr[i]= arr[i-1] + arr[i-2];
		}
		
		System.out.println(arr[n]);
		
	}

}
