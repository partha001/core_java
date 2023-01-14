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
	
	
	private static class Solution2 {
	    public int maxAreaOfIsland(int[][] grid) {
	        int rows = grid.length;
	        int cols = grid[0].length;
	        int[][] vis = new int[rows][cols];
	        int result =0;
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<cols;j++){
	                if(grid[i][j]==1 && vis[i][j]==0){
	                    result = Math.max(result, dfs(i,j, rows, cols, grid, vis));
	                }
	            }
	        }
	        return result;
	    }


	    private int dfs(int i, int j, int rows, int cols, int[][] grid,int[][] vis){
	        vis[i][j] = 1;
	        int area=0;
	        int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
	        for(int[] dir: dirs){
	            int x = i + dir[0];
	            int y = j + dir[1];
	            if(x>=0 && x<rows && y>=0 & y<cols && vis[x][y]==0 && grid[x][y]==1)
	                area += dfs(x,y, rows, cols, grid, vis);
	        }
	        return area+1; //adding one for the current cell
	    }
	}



}
