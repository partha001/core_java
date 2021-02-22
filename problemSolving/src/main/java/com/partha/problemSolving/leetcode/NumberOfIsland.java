package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/number-of-islands/
 * @author biswaspa
 *
 */
public class NumberOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Solution {

		int r[] = new int[] {0, -1, 0, 1};
		int c[] = new int[] {-1, 0, 1, 0};

		public int numIslands(char[][] grid) {
			int n = grid.length;
			int m = grid[0].length;

			boolean vis[][] = new boolean[n][m];		        
			int island = 0;

			for(int i = 0;i<n;i++){
				for(int j = 0;j<m;j++){
					if(grid[i][j] == '1' && vis[i][j] == false){
						DFS(grid, vis, i, j, n ,m);//1
						island++;//1 2 3
					}
				}
			}		        
			return island;
		}

		public void DFS(char grid[][], boolean vis[][], int i, int j, int n, int m){
			vis[i][j] = true;

			for(int k = 0;k<4;k++){
				int row = i + r[k];
				int col = j + c[k];
				if(row>=0 && row< n && col>=0 && col<m && grid[row][col] == '1' && vis[row][col] == false){
					DFS(grid, vis, row, col, n, m);
				}
				//backtrack
			}
		}    

	}

}
