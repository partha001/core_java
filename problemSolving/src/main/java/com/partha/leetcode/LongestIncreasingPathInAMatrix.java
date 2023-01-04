package com.partha.leetcode;

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
		System.out.println(new LeetcodeOfficialSolution2().longestIncreasingPath(matrix));
		System.out.println("completed at:"+new Date());

	}



	//this solution though theoretically correct but for large dataset as input2 it keeps running since there is no memoisation
	// Naive DFS Solution
	// Time Limit Exceeded
	// source : leetcode official
	private static  class LeetcodeOfficialSolution1 {
		private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		private int m, n;

		public int longestIncreasingPath(int[][] matrix) {
			if (matrix.length == 0) return 0;
			m = matrix.length;
			n = matrix[0].length;
			int ans = 0;
			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j)
					ans = Math.max(ans, dfs(matrix, i, j));
			return ans;
		}

		private int dfs(int[][] matrix, int i, int j) {
			int ans = 0;
			for (int[] d : dirs) {
				int x = i + d[0], y = j + d[1];
				if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
					ans = Math.max(ans, dfs(matrix, x, y));
			}
			return ++ans;
		}
	}


	// DFS + Memoization Solution
	// Accepted and Recommended
	// source : leetcode official solution
	private static  class LeetcodeOfficialSolution2 {
		
		private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		private int m, n;

		public int longestIncreasingPath(int[][] matrix) {
			if (matrix.length == 0) return 0;
			m = matrix.length; n = matrix[0].length;
			int[][] cache = new int[m][n];
			int ans = 0;
			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j)
					ans = Math.max(ans, dfs(matrix, i, j, cache));
			return ans;
		}

		private int dfs(int[][] matrix, int i, int j, int[][] cache) {
			if (cache[i][j] != 0) return cache[i][j];
			int max =0;
			for (int[] d : dirs) {
				int x = i + d[0], y = j + d[1];
				if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]){
					max =Math.max( max, dfs(matrix, x, y, cache));

				}
			}
			cache[i][j]= max+1;
			return cache[i][j];
		}
	}

}
