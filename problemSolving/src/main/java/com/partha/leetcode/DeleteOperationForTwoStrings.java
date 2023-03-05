package com.partha.leetcode;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * @author partha
 *
 */
public class DeleteOperationForTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * source: https://leetcode.com/problems/delete-operation-for-two-strings/solutions/2149327/detailed-java-recursive-memoization-dp-buttom-up-space-optimization/
	 * TC : O(m*n)
	 * SC : O(2m)
	 * @author partha
	 *
	 */
	private static class Solution {
		public int minDistance(String word1, String word2) {
		        int m = word1.length();
		        int n = word2.length();
		        
		        int[] dp = new int[n+1];
		        // as java already contain 0 as default value no need to initailize the dp array
		        for(int i = 1 ; i < m+1 ;i++){
		            int[] temp = new int[n+1];
		            for(int j = 1 ; j < n+1 ; j++){
		                if(word1.charAt(i-1) == word2.charAt(j-1))
		                     temp[j] = 1+dp[j-1];
		                 
		                 else
		                     temp[j] = Math.max(dp[j] , temp[j-1]);       
		            }
		            dp = temp;
		        }
		         return m+n-(2*dp[n]);
		     }
		}

}
