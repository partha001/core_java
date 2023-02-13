package com.partha.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.partha.leetcode.TestUtil.TestArray;

public class WallsAndGatesTest {
	
	
	private static class Solution{
		
		//write your code here
		 public static int[][] wallsAndGates(int[][] a, int n, int m) {
			 int[][] dir = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
			 Queue<int[]> queue = new LinkedList<>();
			 int[][] vis = new int[n][m];
			 for(int i=0;i<n;i++) {
				 for(int j=0;j<m;j++) {
					 if(a[i][j]==0) {
						 queue.add(new int[] {i,j});
					 	vis[i][j] = 1;
					 }
				 }
			 }
			 
			
			 int dist = 0;
			 while(!queue.isEmpty()) {
				 int size = queue.size();
				 for(int i=0;i<size;i++) {
					 int[] current = queue.poll();
					 int row = current[0];
					 int col = current[1];				
					 a[row][col] = dist;
					 for(int j = 0;j<4;j++) {
						 int newRow = row + dir[j][0];
						 int newCol = col + dir[j][1];
						 if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol]==0 ) {
							 queue.add(new int[] {newRow,newCol});
							 vis[newRow][newCol] = 1;
						 }
					 }		 
				 }
				 dist++;
						 
			 }
				 
				 
			return a; 
			
			 //dummy return statement
			 //return new int[1][1];
		}
	}

	@Test
	public void test() {
		Faker faker = new Faker();
		for(int i=0;i<100;i++) {
			
			TestArray  data= TestUtil.getTest2dArray(0, 5);
			int[][] a = data.arr;
			int n = data.rows;
			int m = data.cols;		
			assertArrayEquals(new WallsAndGates.Solution2().wallsAndGates(a, n, m) , new Solution().wallsAndGates(a, n, m));
		}
		
	}

}
