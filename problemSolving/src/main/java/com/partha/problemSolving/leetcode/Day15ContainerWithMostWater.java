package com.partha.problemSolving.leetcode;

/**
 * problemDescription: https://leetcode.com/problems/container-with-most-water/
 * referrence : https://www.youtube.com/watch?v=TI3e-17YAlc
 * @author biswaspa
 *
 */
public class Day15ContainerWithMostWater {

	public static void main(String[] args) {

	}
	
	
	/**
	 * Solution : O(n*n)
	 * @author biswaspa
	 *
	 */
	static class Solution1{
		 public int maxArea(int[] height) {
			 int maxHeight = Integer.MIN_VALUE;
			 for(int i=0;i<height.length-1;i++) {
				 for(int j=i+1;j<height.length;j++) {
					int min = Math.min(height[i], height[j]);
					maxHeight = Math.max(maxHeight, (j-i) * min);
				 }
			 }
			 return maxHeight;
		 }
		
	}
	
	/*
	 * solution : O(n)
	 */
	static class Solution2 {
		 public int maxArea(int[] height) {
			 int max = Integer.MIN_VALUE;
			 int i=0;
			 int j=height.length-1;
			 while(i<j) {
				 int min = Math.min(height[i], height[j]);
				 max = Math.max(max, min * (j-i));
				 if(height[i]<height[j]) {
					 i++;
				 }else {
					 j--;
				 }
			 }
			 return max;
		 }
	}


}
