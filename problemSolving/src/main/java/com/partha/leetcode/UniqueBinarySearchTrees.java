package com.partha.leetcode;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	/**
	 * @approach Dynamic Progamming Approach
	 * @source Leetcode official solution
	 * @TC and LC  refer to https://drive.google.com/file/d/1stAQGMLGQi2LXzReuYbUsfqLZSa0uPDQ/view
	 * @author biswaspa
	 *
	 */
	private static  class LeetcodeOfficialSolution1 {
		  public int numTrees(int n) {
		    int[] G = new int[n + 1];
		    G[0] = 1;
		    G[1] = 1;

		    for (int i = 2; i <= n; ++i) {
		      for (int j = 1; j <= i; ++j) {
		        G[i] += G[j - 1] * G[i - j];
		      }
		    }
		    return G[n];
		  }
		}
	
	
	/**
	 * @approach Mathematical deduction
	 * @source Leetcode official solution
	 * @TC O(n)
	 * @SC O(1)
	 * @author biswaspa
	 *
	 */
	private static  class LeetcodeOfficialSolution2 {
		  public int numTrees(int n) {
		    // Note: we should use long here instead of int, otherwise overflow
		    long C = 1;
		    for (int i = 0; i < n; ++i) {
		      C = C * 2 * (2 * i + 1) / (i + 2);
		    }
		    return (int) C;
		  }
		}

}
