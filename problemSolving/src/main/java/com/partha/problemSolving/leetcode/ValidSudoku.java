package com.partha.problemSolving.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * @author partha
 *
 */
public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        Set<String> rowSet = new HashSet();
	        Set<String> colSet = new HashSet();
	        Set<String> squareSet = new HashSet();
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[i].length;j++){
	                if(board[i][j]!='.' && (
	                    !rowSet.add("element:"+board[i][j]+" row:"+i) ||
	                    !colSet.add("element:"+board[i][j]+" col:"+j) ||
	                    !squareSet.add("element:"+board[i][j]+ " row:"+i/3+" col:"+j/3)
	                )){
	                    return false;
	                }
	            }
	        }

	        return true;
	    }
	}

}
