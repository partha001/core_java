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

	static class Solution1 {
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

	//the above code is also same but written in a smarter way. 
	class Solution2 {
		public int climbStairs(int n) {		    
			if(n==1)
				return 1;

			int[] dp= new int[n+1];
			
			//defining base cases to build upon
			dp[0] = 0; //ways to climb zero stairs since we are already there .
			dp[1] = 1; //ways to climb 1 stair
			dp[2] = 2; //ways to climb 2 stairs
			
			for(int i=3;i<=n;i++){
				dp[i] = dp[i-1] + dp[i-2];
			}
			return dp[n];
		}
	}

}
