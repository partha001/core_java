package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-queens/
 * @author partha
 *
 */
public class NQueenProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * https://www.youtube.com/watch?v=Ph95IHmRp5M
	 * brute force backtracking solution
	 */
	public class Solution {
	    private Set<Integer> col = new HashSet<Integer>();
	    private Set<Integer> diag1 = new HashSet<Integer>();
	    private Set<Integer> diag2 = new HashSet<Integer>();
	    
	    public List<List<String>> solveNQueens(int n) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        dfs(res,new ArrayList<String>(), 0, n);
	        return res;
	    }
	    private void dfs(List<List<String>> res, List<String> list, int row, int n){
	    	//codition when all the queens are placed
	    	//if all queens are not placed then another placement order/ie another traversal path is explored after
	    	//reverting back the board
	        if (row == n){ 
	            res.add(new ArrayList<String>(list));
	            return;
	        }
	        for (int i = 0; i < n; i++){
	            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
	            
	            char[] charArray = new char[n];
	            Arrays.fill(charArray, '.');
	            charArray[i] = 'Q';
	            String rowString = new String(charArray);
	            
	            list.add(rowString);
	            col.add(i);
	            diag1.add(row + i);
	            diag2.add(row - i);
	            
	            dfs(res, list, row + 1, n);
	            
	            //erasing values after backtracking
	            list.remove(list.size() - 1);
	            col.remove(i);
	            diag1.remove(row + i);
	            diag2.remove(row - i);
	        }
	    }
	}

}
