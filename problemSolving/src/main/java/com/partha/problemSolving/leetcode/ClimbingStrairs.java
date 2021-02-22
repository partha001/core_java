package com.partha.problemSolving.leetcode;

/**
 * @link : https://leetcode.com/problems/climbing-stairs/
 * @author biswaspa
 *
 */
public class ClimbingStrairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public int climbStairs(int n) {
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

}
