package com.partha.leetcode;

/**
 * @problemDescription https://leetcode.com/problems/container-with-most-water/
 * @tutorial <a href="https://www.youtube.com/watch?v=TI3e-17YAlc">link</a>
 * @author biswaspa
 * 
 * @note 
 * 1.also note the difference with trapping-rain-water. notice in trappingRainWater first 
 * index also holds water . however here we are just interesting in finding the two boundaries
 * which can contain most water. 
 * 
 * 2.since here we are interested only in the water that the max container can hold hence 
 * we are not adding to max. rather replacing max whenever we encounter a new max
 */
public class ContainerWithMostWater {

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
				 // increasing/decreasing the index from the side which is small
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
