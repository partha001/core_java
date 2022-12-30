package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 * @author partha
 *
 */
public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {

	}
	
	
	private static class Solution {

	    int rows = 0;
	    int cols =0;



	    public List<List<Integer>> pacificAtlantic(int[][] heights) {
	        rows= heights.length;
	        cols = heights[0].length;
	        HashSet<String> pacific = new HashSet();
	        HashSet<String> atlantic = new HashSet();

	        //dfs on first and last row to populate pacific and atlantic set respectively
	        for(int i=0;i<cols;i++){
	            dfs(0,i,pacific, heights[0][i], heights); 
	            dfs(rows-1,i, atlantic, heights[rows-1][i], heights);
	        }

	        //dfs on first and last column to populate pacific and atlantic set respecctively
	        for(int i=0;i<rows;i++){
	            dfs(i,0,pacific, heights[i][0],heights);
	            dfs(i,cols-1, atlantic, heights[i][cols-1], heights);
	        }


	        List<List<Integer>> result = new ArrayList();
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<cols;j++){
	                String key= "row:"+i+"col:"+j;
	                if(pacific.contains(key) && atlantic.contains(key)){
	                    result.add(new ArrayList(Arrays.asList(i,j)));
	                }
	                    
	            }
	        }
	        return result;
	    }


	    private void dfs(int row, int col, HashSet<String> visited, int prevHeight, int[][] heights){
	        if(visited.contains( "row:"+row+"col:"+col)  //visited
	        || row<0 || row>=rows || col<0 || col>= cols //indexOutOfBound
	        || heights[row][col]< prevHeight) //since going from sea to land
	            return;

	        //valid cell
	        visited.add("row:"+row+"col:"+col);
	        dfs(row, col-1, visited, heights[row][col], heights);
	        dfs(row-1, col, visited, heights[row][col], heights);
	        dfs(row, col+1, visited, heights[row][col], heights);
	        dfs(row+1, col, visited, heights[row][col], heights);
	    }
	}

}
