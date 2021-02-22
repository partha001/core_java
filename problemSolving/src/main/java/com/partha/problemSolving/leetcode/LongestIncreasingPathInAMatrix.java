package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * @author biswaspa
 *
 */
public class LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution1 {
	    
	    int rows ;
	    int columns;
	    int[] arri = new int[]{0,-1,0,1};
	    int[] arrj = new int[]{-1,0,1,0}; 
	   
	    
	    public int longestIncreasingPath(int[][] matrix) {
	        rows = matrix.length;
	        int result = 0;
	        if(rows==0)
	            return result;
	        
	        columns = matrix[0].length;
	        int[][] dp = new int[rows][columns];
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                if(dp[i][j]==0){
	                    dp[i][j] = dfs(matrix,i,j,dp);
	                    result = Math.max(result,dp[i][j]);
	               }
	            }
	        }
	        return result;
	        
	    }
	    
	    
	   private int dfs(int[][] matrix,int i,int j,int[][] dp){
	       if(dp[i][j]!=0)
	           return dp[i][j];
	       int length = 1;
	       for(int m=0;m<4;m++){
	           int a = i + arri[m];
	           int b = j + arrj[m];
	           
	           if( checkBoundary(a,b) && matrix[i][j]<matrix[a][b])
	               length = Math.max(length,1+dfs(matrix,a,b,dp));          
	       }
	       dp[i][j] = length;
	       return length;
	   }
	    
	    private boolean checkBoundary(int i,int j){
	        if(i>=0 && i<rows && j>=0 && j<columns)
	            return true;
	        return false;
	    }    
	    
	    
	}
}
