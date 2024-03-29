package com.partha.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle
 * @author biswaspa
 *
 */
public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * @approach  Dynamic Programming - Better Brute Force on Histograms
	 * @TC O(N^2 * M)
	 * @SC O(N*M)
	 * @author biswaspa
	 *
	 */
	private static class LeetcodeOfficialSolution1 {
	    public int maximalRectangle(char[][] matrix) {

	        if (matrix.length == 0) return 0;
	        int maxarea = 0;
	        int[][] dp = new int[matrix.length][matrix[0].length];

	        for(int i = 0; i < matrix.length; i++){
	            for(int j = 0; j < matrix[0].length; j++){
	                if (matrix[i][j] == '1'){

	                    // compute the maximum width and update dp with it
	                    dp[i][j] = j == 0? 1 : dp[i][j-1] + 1;

	                    int width = dp[i][j];

	                    // compute the maximum area rectangle with a lower right corner at [i, j]
	                    for(int k = i; k >= 0; k--){
	                        width = Math.min(width, dp[k][j]);
	                        maxarea = Math.max(maxarea, width * (i - k + 1));
	                    }
	                }
	            }
	        } return maxarea;
	    }
	}
	
	
	/**
	 * @approach  Dynamic Programming - Better Brute Force on Histograms
	 * @TC O(N * M)
	 * @SC O(M)
	 * @author biswaspa
	 *
	 */
	private static class LeetcodeOfficialSolution2 {

	    // Get the maximum area in a histogram given its heights
	    public int leetcode84(int[] heights) {
	        Stack < Integer > stack = new Stack < > ();
	        stack.push(-1);
	        int maxarea = 0;
	        for (int i = 0; i < heights.length; ++i) {
	            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
	                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
	            stack.push(i);
	        }
	        while (stack.peek() != -1)
	            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
	        return maxarea;
	    }

	    public int maximalRectangle(char[][] matrix) {

	        if (matrix.length == 0) return 0;
	        int maxarea = 0;
	        int[] dp = new int[matrix[0].length];

	        for(int i = 0; i < matrix.length; i++) {
	            for(int j = 0; j < matrix[0].length; j++) {

	                // update the state of this row's histogram using the last row's histogram
	                // by keeping track of the number of consecutive ones

	                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
	            }
	            // update maxarea with the maximum area from this row's histogram
	            maxarea = Math.max(maxarea, leetcode84(dp));
	        } return maxarea;
	    }
	}
	
	/**
	 * @approach  Dynamic Programming - maximum height at each point
	 * @TC O(N * M)
	 * @SC O(M)
	 * @author biswaspa
	 *
	 */
	private static class Solution3 {

	    public int maximalRectangle(char[][] matrix) {
	        if (matrix.length == 0)
	            return 0;
	        int m = matrix.length;
	        int n = matrix[0].length;

	        int[] left = new int[n]; // initialize left as the leftmost boundary possible
	        int[] right = new int[n];
	        int[] height = new int[n];

	        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

	        int maxarea = 0;
	        for (int i = 0; i < m; i++) {
	            int cur_left = 0, cur_right = n;
	            // update height
	            for (int j = 0; j < n; j++) {
	                if (matrix[i][j] == '1')
	                    height[j]++;
	                else
	                    height[j] = 0;
	            }
	            // update left
	            for (int j = 0; j < n; j++) {
	                if (matrix[i][j] == '1')
	                    left[j] = Math.max(left[j], cur_left);
	                else {
	                    left[j] = 0;
	                    cur_left = j + 1;
	                }
	            }
	            // update right
	            for (int j = n - 1; j >= 0; j--) {
	                if (matrix[i][j] == '1')
	                    right[j] = Math.min(right[j], cur_right);
	                else {
	                    right[j] = n;
	                    cur_right = j;
	                }
	            }
	            // update area
	            for (int j = 0; j < n; j++) {
	                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
	            }
	        }
	        return maxarea;
	    }
	}
	

}
