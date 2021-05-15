package com.partha.problemSolving.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * @author biswaspa
 *
 */
public class ShortestPathInBinaryMatrix {

	public static void main(String[] args) {
		int[][] grid = new int[][] {{0,0,0},{1,1,0},{1,1,0}};
		System.out.println(new Solution2().shortestPathBinaryMatrix(grid));
	}
	
	/**
	 * @description abhiske's solution
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    
	    int r[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; // co-ordinates
	    int c[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
	    
	    public int shortestPathBinaryMatrix(int[][] grid) {
	         if(grid.length == 0){
	             return 0;
	         }
	          
	         int n = grid.length;
	         int m = grid[0].length;
	         
	        boolean vis[][] = new boolean[n][m];
	        
	        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) {
	            return -1;
	        }
	        
	        for(int i = 0;i<n;i++){
	            for(int j = 0;j<m;j++){
	                vis[i][j] = false;
	            }
	        }
	        
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[]{0,0});
	        
	        vis[0][0] = true;
	        int path = 0;
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            
	            for(int i = 0;i<size;i++){
	                int [] pair = queue.poll();
	                
	                if(pair[0] == n-1 && pair[1] == m-1){  // final case when user reach the target
	                    return path + 1;
	                }
	                 for(int k  = 0;k<8; k++){
	                     int x = pair[0] + r[k];
	                     int y = pair[1] + c[k];
	                     if(x>=0 && x<n && y>=0 && y<m && grid[x][y] == 0 && vis[x][y] == false){
	                         vis[x][y] = true;
	                         queue.add(new int[]{x, y});
	                     }
	                 }
	            }
	            
	            path = path + 1;
	        }
	        
	        return -1;
	    }
	}
	
	
	private static class Solution2 {
	    
	    int length = Integer.MAX_VALUE;;
	    int n = 0;   
	    int[] arrX = new int[]{0,-1,-1,-1,0,1,1,1};
	    int[] arrY = new int[]{-1,-1,0,1,1,1,0,-1}; 
	    
	    public int shortestPathBinaryMatrix(int[][] grid) {
	        n = grid.length;
	        if(n==0) //edge case1
	            return 0;
	        
	        if(grid[0][0]==1 || grid[n-1][n-1]==1) //edge case2
	            return -1;
	        
	        if(n==1 && grid[0][0]==0) //edge case3
	            return 1;
	        
	        
	        int[][] visited = new int[n][n];
	        visited[0][0] = 1;
	        dfs(grid,visited,0,0,1);
	        return this.length;
	    }
	    
	    
	    public void dfs(int[][] grid,int[][] visited,int x,int y,int currentLength){            
	            
	            if(x==n-1 && y==n-1){
	                this.length = Math.min(currentLength,this.length);
	                return; 
	            }
	                
	            
	            for(int i=0;i<8;i++){
	                int newx = x + arrX[i];
	                int newy = y + arrY[i];
	                if(validateCoordinate(newx,newy) && visited[newx][newy]==0 && grid[newx][newy]==0){
	                    visited[newx][newy] = 1;
	                    dfs(grid,visited,newx,newy,currentLength+1);
	                    visited[newx][newy] = 0;
	                }
	            }
	            
	        
	    }
	    
	    public boolean validateCoordinate(int x,int y){
	        if(x>=0 && x<n && y>=0 && y<n)
	            return true;
	        return false;
	    }
	}

}
