package com.partha.problemSolving.leetcode;

import java.util.Date;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * @author biswaspa
 *
 */
public class LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		//int[][] matrix = new int[][]{{7,8,9},{9,7,6},{7,2,3}};
		
		//input2
		int[][] matrix = new int[][]{{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
		System.out.println("started at:"+new Date());
		System.out.println(new Solution2().longestIncreasingPath(matrix));
		System.out.println("completed at:"+new Date());

	}
	
	
	
	//this solution though theoretically correct but for large dataset as input2 it keeps running since there is no memoisation
	private static class Solution2 {
	    int result =0;
	    int directions[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}}; 
	    
	    public int longestIncreasingPath(int[][] matrix) {
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        System.out.println("rows:"+rows+ " columns:"+columns);
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	            	System.out.println("calculating for i="+i+ "  j:"+j);
	                int[][] visited = new int[rows][columns];
	                visited[i][j] = 1;
	                dfs(matrix,visited,i,j,1);
	            }
	        }
	        return result;
	    }
	    
	    private void dfs(int[][] matrix,int[][] visited,int i,int j,int currentLength){
	        result = Math.max(result,currentLength);
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        for(int[] direction : directions){
	            int newi = i+ direction[0];
	            int newj = j+ direction[1];
	            if(newi>=0 && newi<rows && newj>=0 && newj<columns && visited[newi][newj]==0 && matrix[i][j]<matrix[newi][newj]){
	                visited[newi][newj] = 1;
	                dfs(matrix,visited,newi,newj,currentLength+1); 
	                visited[newi][newj] = 0; //for a simple dfs making it unvisited is important
	            }
	            else{
	                continue;
	            }
	        }
	    }  
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
