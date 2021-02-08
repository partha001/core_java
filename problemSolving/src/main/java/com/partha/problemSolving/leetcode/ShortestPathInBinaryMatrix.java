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

	}
	
	/**
	 * @description abhiske's solution
	 * @author partha
	 *
	 */
	static class Solution1 {
	    
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

}
