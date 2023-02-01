package com.partha.leetcode;

/**
 * https://leetcode.com/problems/maximal-square/
 * @author partha
 *
 */
public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution {
		
	    public int maximalSquare(char[][] matrix) {
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        int max =0;
	        
	        if(rows==0){
	            return 0;
	        }
	        
	        int[][] dp = new int[rows][columns];
	        
	        //populating first row
	        for(int i=0;i<columns;i++){
	            dp[0][i] = matrix[0][i]-48;
	            max = Math.max(max,dp[0][i]);
	        }
	        
	        
	        //populating first column
	        for(int i=0;i<rows;i++){
	            dp[i][0] = matrix[i][0]-48;
	            max = Math.max(max,dp[i][0]);
	        }
	        
	          
	        
	        //populating rest of the cells
	        for(int i=1;i<rows;i++){
	            for(int j=1;j<columns;j++){
	                if(matrix[i][j]!='0'){
	                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
	                    max = Math.max(max,dp[i][j]);
	                }
	            }
	        }
	        
	        return max*max;        
	        
	    }
	}
	
	
	
	/**
	 * same algo as above written in a different way
	 * TC : O(m*n)
	 * SC: O(m*n)
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    public int maximalSquare(char[][] matrix) {
	        int rows = matrix.length;
	        if(rows==0)
	            return 0;
	        int cols = matrix[0].length;
	        int[][] result = new int[rows][cols];
	        int max = 0;
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<cols;j++){
	                if(matrix[i][j]=='1'){
	                    if(i==0){ //for first row
	                        result[i][j]=1;
	                    }else if(j==0){ //first column
	                        result[i][j] = 1;
	                    }else{ //other cells
	                        result[i][j] = Math.min( Math.min(result[i][j-1], result[i-1][j-1]), result[i-1][j])+1;
	                    }
	                    max = Math.max(max, result[i][j]);
	                }
	            }
	        }
	        return max*max;
	    }
	}

}
