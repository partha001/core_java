package com.partha.problemSolving.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges
 * @author biswaspa
 *
 */
public class RottingOranges {

	public static void main(String[] args) {

	}
	
	
	static class Solution {
	    public int orangesRotting(int[][] grid) {
	        int m = grid.length;
	        int n = grid[0].length;
	        
	        Queue<int[]> Q = new LinkedList<>();
	        int fresh=0;     
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(grid[i][j] == 1) fresh++; //fresh count
	                else if(grid[i][j]==2) Q.offer(new int[]{i,j}); // add rotton oranges to the queue
	            }
	        }
	        
	        if(fresh==0) return 0; 
	        
	        int moves[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}}; // 4 directions to moves
	        int minute=-1; //here minute represents bfs level
	        
	        while(!Q.isEmpty()){
	            int size = Q.size(); // to keep track of the current level elements 
	            minute++; 
	            while(size-- > 0){
	                int[] d = Q.poll(); // poll the rotten orange
	                for(int[] dir : moves){ //visit all 4 directions
	                    int x = d[0]+dir[0];
	                    int y = d[1]+dir[1];
	                    if(x<0 || y<0 || x>= m || y>=n || grid[x][y]==0 || grid[x][y]==2) continue; //already rotten or invalid coordinate
	                    grid[x][y] = 2; // mark the adjacent orange as visited( rotten)
	                    fresh--; // decrease the fresh count
	                    Q.offer(new int[]{x,y}); // add this rotten orange for next minute(level)
	                }
	            }
	        }
	             
	        return fresh==0 ? minute : -1;        
	    }    
	}

}
