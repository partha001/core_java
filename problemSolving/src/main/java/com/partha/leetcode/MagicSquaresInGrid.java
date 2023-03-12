package com.partha.leetcode;

import java.util.HashSet;

/**
 * 
 * @author partha
 *
 */
public class MagicSquaresInGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution1 {
	    public int numMagicSquaresInside(int[][] grid) {
	        int res = 0;
	        if(grid.length < 3 || grid[0].length < 3) return 0;
	        for(int i = 0; i < grid.length - 2; i++){
	            for(int j = 0; j < grid[0].length - 2; j ++){
	                if(checkMagic(grid, i, j)) res++;
	            }
	        }
	        return res;
	    }
	    boolean checkMagic(int[][] grid, int top, int left){
	        int sum = 0;
	        for(int i = 0; i < 3; i ++){
	            sum += grid[top + i][left+i];
	        }
	        HashSet<Integer> set = new HashSet<>(); 
	        for(int i = 0; i < 3; i++){
	            int dig = 0, row = 0, col = 0;
	            for(int j = 0; j < 3; j++){
	                if(grid[top+i][left+j] > 9 || grid[top+i][left+j] < 1) return false;       
	                set.add(grid[top+i][left+j]);
	                dig += grid[top + j][left + 2 - j];
	                row += grid[top + i][left + j];
	                col += grid[top + j][left + i];
	            }
	            if(dig != sum || row != sum || col != sum) return false;
	        }
	        return set.size() == 9;
	    }
	}

}
