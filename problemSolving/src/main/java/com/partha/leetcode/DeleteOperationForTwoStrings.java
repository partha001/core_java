package com.partha.leetcode;

import java.util.Arrays;

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
	 * this is space optimized tabulation. this is the most optimized approach
	 */
	private static class Solution3 {
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
	
	/**
	 * tabulation method. practice this solution
	 */
	private static class Solution2 {
	       public int minDistance(String s, String t) {
	        
	        int m = s.length(), n = t.length();
	        int[][] dp = new int[m + 1][n + 1];
	        for(int[] row : dp) 
	        	Arrays.fill(row, -1);
	        
	        for(int i = 0; i <= m; i++)
	            dp[i][0] = i;
	        
	        for(int j = 0; j <= n; j++)
	            dp[0][j] = j;
	            
	        for(int i = 1; i <= m; i++){
	            for(int j = 1; j <= n; j++){
	                if(s.charAt(i - 1) == t.charAt(j - 1))
	                    dp[i][j] = dp[i - 1][j - 1];
	                else{
	                    int deleteInS = dp[i - 1][j];
	                    int deleteInT = dp[i][j - 1];
	                    dp[i][j] = Math.min(deleteInS, deleteInT) + 1;
	                }
	            }
	        }
	        
	        return dp[m][n];
	    }
	}
	
	
	/**
	 * naive recursive solution. hence runs of time if the strings are very large
	 */
	private static class Solution1 {
	    public int minDistance(String word1, String word2) {
	        return solve(word1, word2, word1.length(), word2.length());
	    }

	    private int solve(String s, String t, int m, int n){
	        
	        if(m == 0 || n == 0) return  m + n;
	        
	        if(s.charAt(m - 1) == t.charAt(n - 1)) 
	            return solve(s, t, m - 1, n - 1);
	        
	        int deleteInS = solve(s, t, m - 1, n);
	        int deleteInT = solve(s, t, m, n - 1);
			
	        return Math.min(deleteInS, deleteInT) + 1;
	    }
	}

}
