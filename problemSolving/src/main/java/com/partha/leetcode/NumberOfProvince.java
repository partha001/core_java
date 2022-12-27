package com.partha.leetcode;

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
	        int row = isConnected.length;
	        int col = isConnected[0].length;
	        boolean[] vis = new boolean[row];
	        int result = 0;
	        for(int i=0;i<row;i++){
	            if(!vis[i])
	            result++; 
	            dfs(isConnected,vis,i,row,col);
	        }
	        return result;
	    }
	    
	    public void dfs(int[][] isConnected,boolean[] vis,int i,int row,int col){
	        vis[i] = true;
	        for(int j=0;j<col;j++){
	            if(!vis[j] && isConnected[i][j]==1){
	                dfs(isConnected,vis,j,row,col);
	            }
	        }
	    }
	}
	

}
