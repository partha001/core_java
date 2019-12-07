package com.partha.problemSolving.dynamicProgramming;

/**
 * problemStatement: we are located at the top left corner of a m x n grid .
 * 						one can either move right or down at a given instance of time.
 * 						home is located at the bottom right corner of the grid
 * 						in how many unique ways can we reach home.
 * @author Partha
 *
 */
public class Ex02OnTheWayHome {

	public static void main(String[] args) {
		System.out.println(findNumberOfWaysToReachHome(5,6));
		System.out.println(numWays(5,6));
	}
	
	
	//solution by me and its correct as it produces the same result as the below method
	public static int findNumberOfWaysToReachHome(int m, int n) {
		
		
		int[][] ways = new int[m][n];
		
		for(int i=0;i<n;i++)
			ways[0][i]=1;
		
		
		for(int i=0;i<m;i++)
			ways[i][0]=1;
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				ways[i][j]= ways[i-1][j] + ways[i][j-1];
			}
		}
		
		return ways[m-1][n-1];
		
	}
	
	
	
	//solution from internet
    // Assusming the dimensions m and n are non-negative integers
    private static int numWays(int m, int n){
        int[][] ways = new int[m][n];
        
        // Number of ways to reach bottom right corner from last column of grid is 1
        for(int i = 0; i <= m - 1; i++){
            ways[i][n - 1] = 1;
        }
        
        // Number of ways to reach bottom right from corner last row of grid is 1 too
        for(int j = 0; j <= n - 1; j++){
            ways[m - 1][j] = 1;
        }
        
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                ways[i][j] = ways[i][j + 1] + ways[i + 1][j];
            }
        }
        
        return ways[0][0];
    }

}
