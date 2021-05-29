package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/number-of-provinces/
 * @author biswaspa
 *
 */
public class NumberOfProvince {

	public static void main(String[] args) {
		new Solution1();
	}
	
	static class Solution1 {
	    
		public int findCircleNum(int[][] isConnected) {
	        int n = isConnected.length;
	        boolean[] visited = new boolean[n];
	        int ans = 0;

	        for (int i = 0; i < n; i++) {
	            if (dfs(i, isConnected, visited) > 0) 
	                ans++;
	        }

	        return ans;
	    }

	    private int dfs(int index, int[][] isConnected, boolean[] visited) {
	        int count = 0;
	        if (visited[index]) 
	            return count;
	        visited[index] = true;

	        for (int i = 0; i < isConnected[index].length; i++) {
	            if (isConnected[index][i] == 0) 
	                continue;
	            count = count + dfs(i, isConnected, visited);
	        }

	        return count + 1;
	    }
	}
	
	
	private static class Solution2 {
	    public int findCircleNum(int[][] isConnected) {
	        boolean [] cities = new boolean[isConnected.length];
	        int count = 0;
	        for(int i = 0;i < isConnected.length;i++) {
	            if(!cities[i])  {
	                visit(isConnected, cities, i);
	                count++;
	            }
	        }
	        return count;
	    }
	    
	    public void visit(int [][] isConnected, boolean [] cities, int cityIndex) {
	        cities[cityIndex] = true;
	        for(int col = 0; col < isConnected.length;col++) {
	            if(isConnected[cityIndex][col] == 1) {
	                isConnected[cityIndex][col] = 0;
	                isConnected[col][cityIndex] = 0;
	                if(!cities[col]) {
	                    visit(isConnected, cities, col);
	                }
	            }
	        }
	    }
	}
	

}
