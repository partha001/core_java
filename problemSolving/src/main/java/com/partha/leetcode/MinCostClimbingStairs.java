package com.partha.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * @author biswaspa
 *
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * approach1: bottom-up/tabulation Dynamic Programming
	 * @Source leetcode official solution
	 * @TC: O(N)
	 * @SC O(N)
	 */
	private static class Solution1 {
	    public int minCostClimbingStairs(int[] cost) {
	        // The array's length should be 1 longer than the length of cost
	        // This is because we can treat the "top floor" as a step to reach
	        int minimumCost[] = new int[cost.length + 1];
	        
	        // Start iteration from step 2, since the minimum cost of reaching
	        // step 0 and step 1 is 0
	        for (int i = 2; i < minimumCost.length; i++) {
	            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
	            int takeTwoSteps = minimumCost[i - 2] + cost[i - 2];
	            minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
	        }
	        
	        // The final element in minimumCost refers to the top floor
	        return minimumCost[minimumCost.length - 1];
	    }
	}
	
	/**
	 * approach1:top-down  Dynamic Programming [recursion + memoization]
	 * @Source leetcode official solution
	 * @TC: O(N)
	 * @SC O(N)
	 */
	private static class Solution2 {
	    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

	    public int minCostClimbingStairs(int[] cost) {
	        return minimumCost(cost.length, cost);
	    }

	    private int minimumCost(int i, int[] cost) {
	        // Base case, we are allowed to start at either step 0 or step 1
	        if (i <= 1) {
	            return 0;
	        }

	        // Check if we have already calculated minimumCost(i)
	        if (memo.containsKey(i)) {
	            return memo.get(i);
	        }

	        // If not, cache the result in our hash map and return it
	        int downOne = cost[i - 1] + minimumCost(i - 1, cost);
	        int downTwo = cost[i - 2] + minimumCost(i - 2, cost);
	        memo.put(i, Math.min(downOne, downTwo));
	        return memo.get(i);
	    }
	}
	
	

	/**
	 * approach1:bottom-up constant space 
	 * @Source leetcode official solution
	 * @TC: O(N)
	 * @SC O(1)
	 */
	class Solution {
	    public int minCostClimbingStairs(int[] cost) {
	        int downOne = 0;
	        int downTwo = 0;
	        for (int i = 2; i < cost.length + 1; i++) {
	            int temp = downOne;
	            downOne = Math.min(downOne + cost[i - 1], downTwo + cost[i - 2]);
	            downTwo = temp;
	        }
	        
	        return downOne;
	    }
	}

}
