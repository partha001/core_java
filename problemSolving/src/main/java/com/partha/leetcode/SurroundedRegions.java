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
		new Solution2().solve(board);
	}


	/**
	 * TC: mn
	 * sc: mn
	 * this solution uses extra space i.e. the vis array
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
		public void solve(char[][] board) {
			int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
			int rows = board.length;
			int cols = board[0].length;
			int[][] vis = new int[rows][cols];
			for(int row=0;row<rows;row++){
				for(int col=0;col<cols;col++){
					if( (row==0 || row==rows-1 || col==0 || col==cols-1 ) && board[row][col]=='O' && vis[row][col]==0){
						dfs(row, col , rows, cols, board, vis, dirs);
					}
				}
			}

			for(int row=0;row<rows;row++){
				for(int col=0;col<cols;col++){
					if(board[row][col]=='O' && vis[row][col]==0)
						board[row][col]='X';
				}
			}

		}


		private void dfs(int row, int col, int rows, int cols, char[][] board, int[][] vis,int[][] dirs){
			vis[row][col]=1;
			for(int[] dir : dirs){
				int x = row + dir[0] ; int y = col + dir[1];
				if( x>=0 && y>=0 && x<rows-1 && y<col-1 && vis[x][y]==0 && board[row][col]=='O')
					dfs(x, y , rows, cols, board, vis, dirs);
			}
		}
	}



	/**
	 * constant space . solution
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {

		public void solve(char[][] board) {
			int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
			int rows = board.length;	        
			int cols = board[0].length;


			for(int row=0;row<rows;row++){ //marking the final 0 cells with differnt character
				for(int col=0;col<cols;col++){
					if(  (row==0 || row==rows-1 || col==0 || col==cols-1) && board[row][col]=='O'){
						dfs(board,row,col,rows,cols,dirs);
					}                   
				}
			}


			for(int row=0;row<rows;row++){
				for(int col=0;col<cols;col++){
					if(board[row][col]=='O')
						board[row][col]='X';
				}
			}

			for(int row=0;row<rows;row++){
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
