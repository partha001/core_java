package com.partha.leetcode;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * @author partha
 *
 */
public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		new MaxAreaOfIsland.Solution1().maxAreaOfIsland(grid);
	}
	
	
	private static class Solution1 {
	    
	    int[][] mvs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	    
	    public int maxAreaOfIsland(int[][] grid) {
	        
	        int max = 0;
	        for (int i = 0; i < grid.length; i++)
	            for (int j = 0; j < grid[i].length; j++) {
	                if (grid[i][j] == 0)
	                    continue;
	            
	                max = Math.max(max, dfs(grid, i, j));
	            }
	            
	        return max;
	    }
	    
	    public int dfs(int[][] grid, int i, int j) {
	        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0)
	            return 0;
	        
	        int vals = 1;
	        grid[i][j] = 0; // don't revisit
	        
	        for (int[] mv : this.mvs)
	            vals += dfs(grid, i + mv[0], j + mv[1]);
	        
	        return vals;
	    }
	}



}
