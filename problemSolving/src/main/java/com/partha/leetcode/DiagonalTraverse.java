package com.partha.leetcode;

/**
 * https://leetcode.com/problems/diagonal-traverse
 * @author biswaspa
 *
 */
public class DiagonalTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * TC O(M*N)
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
	    public int[] findDiagonalOrder(int[][] mat) {

	        int m = mat.length;
	        int n = mat[0].length;
	        int[] answer = new int[n * m];
	        int col = 0, row = 0;

	        for (int i = 0; i < m * n; i++) {

	            answer[i] = mat[row][col];

	            if ((row + col) % 2 == 0) { // go up to the right

	                if (col == n - 1) row++;
	                else if (row == 0) col++;
	                else {
	                    row--;
	                    col++;
	                }
	            } else {  // go down to the left

	                if (row == m - 1) col++;
	                else if (col == 0) row++;
	                else {
	                    row++;
	                    col--;
	                }
	            }
	        }

	        return answer;
	    }
	}
	
	/**
	 * Observations:
    1. There are m + n - 1 diagonals in the matrix.
    2. If we number the diagonals non-descending, starting from mat[0][0] as diagonal 0, down to diagonal (m + n - 1), it turns out, that "even" diagonals go up to the right, and "odd" diagonals go down to the left.
    3. Going up to the right, we may leave the matrix at row 0, or col (n - 1). In this cases we must handle the column and row indexes special. In a turn through the middle of the matrix we increment the column and decrement the row.
    4. Going down to the left, we may leave the matrix at column 0, or row (m - 1). In this cases, we must handle the column and row indexes special. In a turn through the middle of the matrix we decrement the column and increment the row.
    5. The solution can handle the corner cases (m or n, one or both, are 1). No special handling necessary.
    6. The surrounding for-loop takes care, that we traverse all m * n numbers in the matrix.
    7. The traversal algorithm itself is done by the row/col manipulation logic inside the loop.

	 */

}
