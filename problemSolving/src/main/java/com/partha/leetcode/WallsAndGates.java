package com.partha.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.codingninjas.com/codestudio/problems/walls-and-gates_1092887
 * @author partha
 *
 */
public class WallsAndGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	/**
	 * @bfs 
	 * @author partha
	 * @source : leetcode official solution
	 * : https://leetcode.com/problems/walls-and-gates/solutions/127819/walls-and-gates/
	 * @TC: O(MN)
	 * @SC: O(MN)
	 */
	private static class LeetcodeOfficialSolution {
		private static final int EMPTY = Integer.MAX_VALUE;
		private static final int GATE = 0;
		private static final List<int[]> DIRECTIONS = Arrays.asList(
		        new int[] { 1,  0},
		        new int[] {-1,  0},
		        new int[] { 0,  1},
		        new int[] { 0, -1}
		);



		public void wallsAndGates(int[][] rooms) {
		    int m = rooms.length;
		    if (m == 0) return;
		    int n = rooms[0].length;
		    Queue<int[]> q = new LinkedList<>();
		    for (int row = 0; row < m; row++) {
		        for (int col = 0; col < n; col++) {
		            if (rooms[row][col] == GATE) {
		                q.add(new int[] { row, col });
		            }
		        }
		    }
		    while (!q.isEmpty()) {
		        int[] point = q.poll();
		        int row = point[0];
		        int col = point[1];
		        for (int[] direction : DIRECTIONS) {
		            int r = row + direction[0];
		            int c = col + direction[1];
		            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
		                continue;
		            }
		            rooms[r][c] = rooms[row][col] + 1;
		            q.add(new int[] { r, c });
		        }
		    }
		}
	}
	
	
	/**
	 * https://www.youtube.com/watch?v=e69C6xhiSQE
	 * @author partha
	 *
	 */
	private static class Solution2 {
		       
	    public static int[][] wallsAndGates(int[][] a, int n, int m) {
	        int[][] directions = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
	        int rows = n;
	        int cols = m;
	        int[][] vis = new int[n][m];
	        Queue<int[]> queue = new LinkedList<int[]>();
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(a[i][j]==0) {// if gate then adding to queue
	                    queue.add(new int[]{i,j});
	                    vis[i][j] = 1;
	                }
	            }
	        }
	        
	        while(!queue.isEmpty()){
	           int[] current = queue.remove();
	            int row = current[0];
	            int col = current[1];    
	            for(int i=0;i<4;i++){
	                int newx = row + directions[i][0];
	                int newy = col + directions[i][1];
	                if(newx>=0 && newx<n && newy>=0 && newy<m 
	                   && vis[newx][newy]==0 && a[newx][newy]==Integer.MAX_VALUE){
	                    vis[newx][newy] = 1;
	                    a[newx][newy] = a[row][col]+1;  
	                    //since the gates=0 so as we fan out we increase the value by 1
	                    //also since we are marking the node as visited so its wont be processed again and
	                    //will only contain the min value since the nearest gate will update its value and mark it valid
	                    //since are fanning out from the gate nodes
	                    queue.add(new int[]{newx,newy});
	                }
	                
	            }
	        }
	        return a; 
	        
	    }
	}


}

