package com.partha.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
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
	
	
	
	
	// same code as above written in different style . difference in condition in line98. [i.e. if condition]
	private static class Solution2 {
        
	    public int orangesRotting(int[][] grid) {
	        int m = grid.length;     
	        int n=grid[0].length;
	        int freshCount = 0;
	        
	        Queue<int[]> queue = new LinkedList<>();
	        for(int row=0;row<m;row++){
	            for(int column=0;column<n;column++){
	                if(grid[row][column]==2) // adding rotten to queue
	                    queue.add(new int[]{row,column});
	                else if(grid[row][column]==1)
	                    freshCount++;
	            }
	        }
	        
	        if(freshCount==0)
	            return 0;
	        
	        int[][] arr = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
	        
	        int minutes =-1; //note that its iniitialized with -1
	        int converted = 0; //keeps track of how many gets rotten
	        
	        while(!queue.isEmpty()){
	            minutes++;
	            int size = queue.size();
	            //for loop also gives same result but execution time increases from 2ms to 12ms
	            //for(int j=0;j<size;j++){ 
	            
	            //also it is to be noted that since we are adding elements to the queue in the inner loop 
	            //so we should read the queue size first and take it into a variable as shown above and not use forLopp as shown below
	            //for(int j=0;j<queue.size();j++){ 
	            
	            while(size-- > 0){
	                int[] current = queue.remove();
	                int x = current[0];
	                int y = current[1];
	                for(int[] dir: arr){
	                    int newx = x + dir[0];
	                    int newy = y + dir[1];                    
	                    if((newx>=0 && newx<m && newy>=0 && newy < n) && grid[newx][newy]==1){ 
	                        converted++;
	                        grid[newx][newy]=2;
	                        queue.add(new int[]{newx,newy});
	                    }
	                }
	            }              
	        }
	        return (converted==freshCount)? minutes:-1;     
	    }
	    
	    
	}

}
