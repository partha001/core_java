package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/edit-distance/
 * @author biswaspa
 *
 * tutorial : https://www.youtube.com/watch?v=We3YDTzNXEk
 */
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	/**
	 * memoisation  using top down
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
		   
		public int minDistance(String word1, String word2) {
		       
		       int[][] dp =  new int[word1.length()+1][word2.length()+1];
		       return memo(word1, word2,dp);
		   }
		   
		   private int memo (String s1,String s2, int[][] dp){
		       
		       if(s1.length() == 0)
		           return s2.length();
		       
		       if(s2.length() == 0)
		           return s1.length();
		       
		       if(dp[s1.length()][s2.length()] != 0){
		           return dp[s1.length()][s2.length()];
		       }
		       
		       if(s1.charAt(0) == s2.charAt(0)){
		           return dp [s1.length()][s2.length()] = memo(s1.substring(1), s2.substring(1), dp);
		       }else{
		           int opt1 = memo(s1.substring(1),s2, dp);
		           int opt2 = memo(s1,s2.substring(1), dp);
		           int opt3 = memo(s1.substring(1), s2.substring(1), dp);
		           return dp [s1.length()][s2.length()] = 1 + Math.min(opt1, Math.min(opt2,opt3));		           
		       }
		   }
		}
	
	
	/**
	 * tabulation method using bottom-up
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {
		   public int minDistance(String s1, String s2) {
		       
		       int[][] dp =  new int[s1.length()+1][s2.length()+1];
					 for(int i = 0; i<=s1.length(); i++){
		               for(int j =0; j<=s2.length(); j++){
						   if(i == 0) 
							   dp[i][j] =  j;
						   else if(j == 0)
							   dp[i][j] = i;
						   else if(s1.charAt(i-1) == s2.charAt(j-1)){
							   dp[i][j] = dp[i-1][j-1];
						   }else{
							   dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
						   }
		               }
		           }
				return dp[s1.length()][s2.length()];
		   }
		}

}
