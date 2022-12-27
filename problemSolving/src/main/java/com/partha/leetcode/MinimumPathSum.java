package com.partha.leetcode;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * @author biswaspa
 *
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static class Solution1 {
	    public int minPathSum(int[][] grid) {
	        
	        int rows = grid.length;
	        int columns = grid[0].length;
	        
	        int[][] result= new int[rows][columns];
	        result[0][0] = grid[0][0];
	        
	        for(int i=1;i<columns;i++){ //filling for first row
	            result[0][i] = result[0][i-1] + grid[0][i];
	        }
	        
	        for(int i=1;i<rows;i++){    //filling for first column
	            result[i][0] = result[i-1][0] + grid[i][0];
	        }
	        
	        for(int i=1;i<rows;i++){    //calculating for rest of the columns
	            for(int j=1;j<columns;j++){ 
	                int top = grid[i][j]+ result[i-1][j];
	                int left = grid[i][j] + result[i][j-1];
	                result[i][j] = Math.min(top,left);
	            }
	        }
	        return result[rows-1][columns-1];
	    }	    	    
	}
	
	/**
	 * the solution remains same . only the extra array to store the result have been eliminated  by 
	 * ovewriting values in the input array
	 * @author biswaspa
	 *
	 */
	static class Solution2 {
	    public int minPathSum(int[][] grid) {
	        
	        int rows = grid.length;
	        int columns = grid[0].length;
	        
	        
	        for(int i=1;i<columns;i++){ //filling for first row
	            grid[0][i] = grid[0][i-1] + grid[0][i];
	        }
	        
	        for(int i=1;i<rows;i++){    //filling for first column
	            grid[i][0] = grid[i-1][0] + grid[i][0];
	        }
	        
	        for(int i=1;i<rows;i++){    //calculating for rest of the columns
	            for(int j=1;j<columns;j++){ 
	                int top = grid[i][j]+ grid[i-1][j];
	                int left = grid[i][j] + grid[i][j-1];
	                grid[i][j] = Math.min(top,left);
	            }
	        }
	        return grid[rows-1][columns-1];
	    }
	        
	    
	}

}
