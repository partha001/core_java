package com.partha.leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.partha.leetcode.TestUtil.TestArray;

public class WallsAndGatesTest {
	
	
	private static class Solution{
		
		//write your code here
		 public static int[][] wallsAndGates(int[][] a, int n, int m) {
			 
			
			 //dummy return statement
			 return new int[1][1];
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
