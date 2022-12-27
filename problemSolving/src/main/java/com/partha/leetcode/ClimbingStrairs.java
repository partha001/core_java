package com.partha.leetcode;

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

			//starting the loop from 2 as given the step constraint a stair can be reached and only from its previous and previous.previous 
			//thus from ways[2] the previous two values are already found. hence we can build upon them.
			for(int i = 2; i <= n; i++){
				ways[i] = ways[i - 1] + ways[i - 2];
			}
			
			return ways[n];
	    }
	}

}
