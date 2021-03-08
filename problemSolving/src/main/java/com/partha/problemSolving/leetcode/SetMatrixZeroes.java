package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * @author biswaspa
 *
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
		new Solution1().setZeroes(matrix);
	}
	
	
	/**
	 * solution spaceComplexity : O(m + n)
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
		   
	    
	    public void setZeroes(int[][] matrix) {
	        int rows = matrix.length;
	        if(rows==0)
	            return;
	        int columns = matrix[0].length;
	        int[] rows0 = new int[rows];
	        int[] columns0 = new int[columns];
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                if(matrix[i][j]==0 ){
	                    rows0[i] = 1;
	                    columns0[j] = 1;
	                }
	            }
	        }
	        
	        
	        //updating row
	        for(int i=0;i<rows;i++){
	            if(rows0[i]==1){
	                for(int j=0;j<columns;j++){
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        //updating for columns
	        for(int j=0;j<columns;j++){
	            if(columns0[j]==1){
	                for(int i=0;i<rows;i++){
	                    matrix[i][j] =0;
	                }
	            }
	        }
	        
	    }	    
	   
	}
	

}
