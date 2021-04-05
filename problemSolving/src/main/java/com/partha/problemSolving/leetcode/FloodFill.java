package com.partha.problemSolving.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/flood-fill/
 * @author partha
 *
 */
public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//using visited matrix
	private static class Solution1 {
	    int arrx[] = new int[]{-1,0,1,0};
	     int arry[] = new int[]{0,-1,0,1};
	    

	    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        
	        int row = image.length;
	        int col = image[0].length;
	        int oldColor = image[sr][sc];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[]{sr,sc});
	        
	        int[][] visited = new int[row][col];

	        image[sr][sc] = newColor;
	        while(!queue.isEmpty()){
	                int []pair = queue.poll();
	                visited[pair[0]][pair[1]] = 1;
	                
	                for(int k = 0;k<4;k++){
	                    int r = arrx[k] + pair[0];
	                    int c = arry[k] + pair[1];
	                    
	                    if(r>=0 && r<row && c>=0 && c<col && image[r][c] == oldColor && visited[r][c]==0){
	                        image[r][c] = newColor;
	                        queue.add(new int[]{r,c});
	                    }
	                    
	                }
	        }	        
	        return image;	        
	    }

	}
	
	
	//same algo but not using visited matrix .
	//since not using visited matrix so have added the below condition to avoid reprocessing
	//image[r][c]!= newColor
	private static class Solutio2n {
	    int arrx[] = new int[]{-1,0,1,0};
	     int arry[] = new int[]{0,-1,0,1};   

	    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	        //Time : O(row*col) space: O(row*col) 
	        
	        int row = image.length;
	        int col = image[0].length;
	        int oldColor = image[sr][sc];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[]{sr,sc});

	        image[sr][sc] = newColor;
	        while(!queue.isEmpty()){            
	                int []pair = queue.poll();
	                for(int k = 0;k<4;k++){
	                    int r = arrx[k] + pair[0];
	                    int c = arry[k] + pair[1];                 
	                    if(r>=0 && r<row && c>=0 && c<col && image[r][c] == oldColor && image[r][c]!= newColor){
	                        image[r][c] = newColor;
	                        queue.add(new int[]{r,c});
	                    }          
	                }     
	        }
	        
	        return image;
	        
	    }

	}

}
