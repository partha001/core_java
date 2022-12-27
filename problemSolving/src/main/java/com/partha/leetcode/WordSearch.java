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

}
