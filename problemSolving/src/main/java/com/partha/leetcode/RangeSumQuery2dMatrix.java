package com.partha.leetcode;



/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * @author partha
 *
 */
public class RangeSumQuery2dMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	/**
	 * https://www.youtube.com/watch?v=KE8MQuwE2yA
	 * @author partha
	 *
	 */
	private static class NumMatrix {

	    int[][] prefixSum;

	    public NumMatrix(int[][] matrix) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        prefixSum = new int[rows+1][cols+1];
	        for(int i=0;i<rows;i++){
	            int prefix =0;
	            for(int j=0;j<cols;j++){
	                prefix += matrix[i][j]; 
	                int above = prefixSum[i][j+1];
	                prefixSum[i+1][j+1]= prefix + above;        
	            }
	        }

	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        row1++;
	        col1++;
	        row2++;
	        col2++;
	        int bottomRight = prefixSum[row2][col2];
	        int above = prefixSum[row1-1][col2];
	        int left = prefixSum[row2][col1-1];
	        int topLeft = prefixSum[row1-1][col1-1];
	        return bottomRight - above - left + topLeft;
	    }
	}


}
