package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/unique-paths/
 * @author biswaspa
 *
 */
public class Day14UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public int uniquePaths(int m, int n) {
	        int[][] dp = new int[m][n];
	        for(int i=0;i<n;i++){ //ways for first row
	            dp[0][i] = 1;
	        }
	        
	        for(int i=0;i<m;i++){ //ways for first column
	            dp[i][0] = 1;
	        }
	        
	        //filling for rest of the columsn 
	        for(int i=1;i<m;i++){
	            for(int j=1;j<n;j++){
	                dp[i][j] = dp[i][j-1] + dp[i-1][j];
	            }
	        }
	        return dp[m-1][n-1];
	    }
	}

}
