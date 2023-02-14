package com.partha.leetcode;

/**
 * https://leetcode.com/problems/word-search/
 * @author biswaspa
 *
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(new Solution1().exist(board, "ABC"));
	}


	static class Solution1 {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		public boolean exist(char[][] board, String word) {
			if((board.length == 0 || board[0].length == 0 || board == null)&&word.length()!=0) 
				return false;
			if(word.length() == 0) return true;
			int m = board.length;
			int n = board[0].length;
			boolean[][] vis = new boolean[m][n];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					if(board[i][j]!=word.charAt(0)) continue;
					vis[i][j] = true;
					if(dfs(i, j, 0, board, vis, word)) return true;
					vis[i][j] = false;
				}
			}
			return false;
		}
		public boolean dfs(int i, int j, int index, char[][] board, boolean[][] vis, String word){
			if(word.charAt(index)!=board[i][j]) return false;
			else if(index == word.length() - 1) return true;
			for(int k = 0; k < 4; k++){
				int newx = i+dx[k];
				int newy = j+dy[k];
				if(newx >= 0 && newx < board.length && newy >=0 && newy < board[0].length && vis[newx][newy]==false){
					vis[newx][newy] = true;
					if(dfs(newx, newy, index+1, board, vis, word)) {
						vis[newx][newy] = false;
						return true;
					}
					vis[newx][newy] = false;
				}
			}
			return false;
		}
	}



	/**
	 * commemt: same algo as above written in better way with better in[][]vis management
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {

		public boolean exist(char[][] board, String word) {
			int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
			if((board.length == 0 || board[0].length == 0 || board == null)&&word.length()!=0) 
				return false;
			if(word.length() == 0) return true;
			int rows = board.length;
			int cols = board[0].length;
			boolean[][] vis = new boolean[rows][cols];
			for(int row = 0; row < rows; row++){
				for(int col = 0; col < cols; col++){
					if(dfs(row, col, 0, board, vis, word,dirs)) 
						return true;
				}
			}
			return false;
		}


		public boolean dfs(int row, int col, int index, char[][] board, boolean[][] vis, String word, int[][] dirs){         
			if(word.charAt(index)!=board[row][col]) {
				return false;
			}
			else if(index == word.length() - 1) 
				return true;

			vis[row][col] = true;
			for(int[] dir:dirs){
				int newx = row+ dir[0];
				int newy = col+ dir[1];
				if(newx >= 0 && newx < board.length && newy >=0 && newy < board[0].length && vis[newx][newy]==false){
					if(dfs(newx, newy, index+1, board, vis, word,dirs)) {
						return true;
					}
					vis[newx][newy] = false;
				}
			}
			vis[row][col] = false;
			return false;

		}

	}

}
