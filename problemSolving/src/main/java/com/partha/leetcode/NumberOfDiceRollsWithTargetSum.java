package com.partha.leetcode;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum
 * @author biswaspa
 *
 */
public class NumberOfDiceRollsWithTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * @approach Top-down dynamic progamming
	 * @TC O( N* T* K )   here N is the number of dice, K is the number of faces each dice have, and T is the target value
	 * @SC O(N * T)
	 * @author biswaspa 
	 *
	 */
	private static class LeetcodeOfficialSolution1 {
	    final int MOD = 1000000007;
	    
	    int waysToTarget(Integer[][] memo, int diceIndex, int n, int currSum, int target, int k) {
	        // All the n dice are traversed, the sum must be equal to target for valid combination
	        if (diceIndex == n) {
	            return currSum == target ? 1 : 0;
	        }
	        
	        // We have already calculated the answer so no need to go into recursion
	        if (memo[diceIndex][currSum] != null) {
	            return memo[diceIndex][currSum];
	        }
	        
	        int ways = 0;
	        // Iterate over the possible face value for current dice
	        for (int i = 1; i <= Math.min(k, target - currSum); i++) {
	            ways = (ways + waysToTarget(memo, diceIndex + 1, n, currSum + i, target, k)) % MOD;
	        }
	        return memo[diceIndex][currSum] = ways;
	    }
	    
	    public int numRollsToTarget(int n, int k, int target) {
	        Integer[][] memo = new Integer[n + 1][target + 1];
	        return waysToTarget(memo, 0, n, 0, target, k);
	    }
	}
	
	
	/**
	 * @approach Bottom-up dynamic progamming
	 * @TC O( N* T* K )   here N is the number of dice, K is the number of faces each dice have, and T is the target value
	 * @SC O(N * T)
	 * @author biswaspa 
	 *
	 */
	class LeetcodeOfficialSolution2 {
	    final int MOD = 1000000007;
	    
	    public int numRollsToTarget(int n, int k, int target) {
	        int[][] memo = new int[n + 1][target + 1];
	        // Intialize the base case
	        memo[n][target] = 1;
	        
	        for (int diceIndex = n - 1; diceIndex >= 0; diceIndex--) {
	            for (int currSum = 0; currSum <= target; currSum++) {
	               int ways = 0;
	                
	                // Iterate over the possible face value for current dice
	                for (int i = 1; i <= Math.min(k, target - currSum); i++) {
	                    ways = (ways + memo[diceIndex + 1][currSum + i]) % MOD;
	                }
	                
	                memo[diceIndex][currSum] = ways;
	            }
	        }
	        
	        return memo[0][0];
	    }
	}

}
