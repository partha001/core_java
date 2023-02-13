package com.partha.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberOfConnectedComponentTest {


	private static class Solution {
		public int findRedundantConnection(int[][] edges, int numberOfNodes) {
			//write your code here 		
			//dummy return
			return 0;
		}
	}

	@Test
	void test() {
		int[][] edges = new int[][] {{0,1},{1,2},{3,4}};
		assertEquals(new NumberOfConnectedComponent.Solution().findRedundantConnection(edges, 4),  //expected
				new Solution().findRedundantConnection(edges, 4)); //actual
	}

}
