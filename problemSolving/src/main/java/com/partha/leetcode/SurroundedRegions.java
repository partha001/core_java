package com.partha.leetcode;
/**
 * https://leetcode.com/problems/surrounded-regions/
 * @author biswaspa
 *
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		//char[][] board = new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		new Solution1().solve(board);
	}


	/**
	 * constant space . solution
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {

		public void solve(char[][] board) {
			int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
			int rows = board.length;	        
			int cols = board[0].length;


			for(int row=0;row<rows;row++){ //marking the cells which are not surrounded by a different character
				for(int col=0;col<cols;col++){
					if(  (row==0 || row==rows-1 || col==0 || col==cols-1) && board[row][col]=='O'){
						dfs(board,row,col,rows,cols,dirs);
					}                   
				}
			}


			for(int row=0;row<rows;row++){ //now marking the cells which are fully surrounded as X
				for(int col=0;col<cols;col++){
					if(board[row][col]=='O')
						board[row][col]='X';
				}
			}

			for(int row=0;row<rows;row++){ //finally marking the cell that we overwrote in first loop to character '0' to get the final result
				for(int col=0;col<cols;col++){
					if(board[row][col]=='*')
						board[row][col]='O';
				}
			}
		}


		private void dfs(char[][] board,int row,int col,int rows, int columns,int[][] dirs){
			board[row][col] = '*';
			for(int[] dir:dirs){
				int x = row+ dir[0];
				int y = col+ dir[1];
				if(x>=0 && x<rows && y>=0 && y<columns && board[x][y]=='O')
					dfs(board,x,y,rows, columns,dirs);
			}
		}

	}

}
