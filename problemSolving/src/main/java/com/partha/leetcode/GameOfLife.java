package com.partha.leetcode;

/**
 * https://leetcode.com/problems/game-of-life/
 * @author partha
 *
 */
public class GameOfLife {

	public static void main(String[] args) {

	}


	/**
	 * 
	 * @author partha
	 *
	 */
	private static class Solution1 {
		// Using named constants for readability
		private final static int IS_ALIVE = 1;
		private final static int IS_DEAD = 0;    
		private final static int WAS_ALIVE_NOW_DEAD = 2;
		private final static int WAS_DEAD_NOW_ALIVE = 3;

		public void gameOfLife(int[][] board) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					int live = countNeighbors(i, j, board, IS_ALIVE);
					int dead = countNeighbors(i, j, board, IS_DEAD);
					board[i][j] = updatedStatus(getExistingState(board[i][j]), live, dead);
				}
			}
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == WAS_ALIVE_NOW_DEAD) board[i][j] = IS_DEAD;
					if (board[i][j] == WAS_DEAD_NOW_ALIVE) board[i][j] = IS_ALIVE;
				}
			}
		}

		private int updatedStatus(int state, int liveCount, int deadCount) {
			if (state == IS_ALIVE && liveCount < 2) return WAS_ALIVE_NOW_DEAD;
			if (state == IS_ALIVE && (liveCount == 2 || liveCount == 3)) return state;
			if (state == IS_ALIVE && liveCount > 3) return WAS_ALIVE_NOW_DEAD;
			if (state == IS_DEAD && liveCount == 3) return WAS_DEAD_NOW_ALIVE;
			return state;
		}


		private int countNeighbors(int i, int j, int[][] board, int state) {
			int ctr = 0;
			if (i - 1 >= 0 && j - 1 >= 0 && getExistingState(board[i - 1][j - 1]) == state) {
				ctr++;
			} 
			if (i - 1 >= 0 && getExistingState(board[i - 1][j]) == state) {
				ctr++;
			} 
			if (j - 1 >= 0 && getExistingState(board[i][j - 1]) == state) {
				ctr++;
			} 
			if (i + 1 < board.length && j + 1 < board[0].length && getExistingState(board[i + 1][j + 1]) == state) {
				ctr++;
			} 
			if (i + 1 < board.length && getExistingState(board[i + 1][j]) == state) {
				ctr++;
			} 
			if (j + 1 < board[0].length && getExistingState(board[i][j + 1]) == state) {
				ctr++;
			} 
			if (i - 1 >= 0 && j + 1 < board[0].length && getExistingState(board[i - 1][j + 1]) == state) {
				ctr++;
			} 
			if (i + 1 < board.length  && j - 1 >= 0 && getExistingState(board[i + 1][j - 1]) == state) {
				ctr++;
			} 
			return ctr;
		}

		private int getExistingState(int value) {
			if (value == IS_ALIVE || value == WAS_ALIVE_NOW_DEAD) return IS_ALIVE;
			else return IS_DEAD;
		}

	}
}
