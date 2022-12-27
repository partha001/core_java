package com.partha.leetcode;

/**
 * @description <a>https://leetcode.com/problems/trapping-rain-water/</a>
 * @exaplanation <a href="https://www.youtube.com/watch?v=ZI2z5pq0TqA">tutorial</a> 
 * @author biswaspa
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {

	}

	
	/**
	 * source: https://www.geeksforgeeks.org/trapping-rain-water/
	 * timecomplexity : O(n^2).
	 * this is the simple solution
	 * @author partha
	 *
	 */
	private static class Solution1{
		// Method for maximum amount of water 
		public int trap(int[] arr) 
		{ 
			int n=arr.length;


			// left[i] contains height of tallest bar to the 
			// left of i'th bar including itself 
			int left[] = new int[n]; 

			// Right [i] contains height of tallest bar to 
			// the right of ith bar including itself 
			int right[] = new int[n]; 

			// Initialize result 
			int water = 0; 

			// Fill left array 
			left[0] = arr[0]; 
			for (int i = 1; i < n; i++) 
				left[i] = Math.max(left[i-1], arr[i]); 

			// Fill right array 
			right[n-1] = arr[n-1]; 
			for (int i = n-2; i >= 0; i--) 
				right[i] = Math.max(right[i+1], arr[i]); 

			// Calculate the accumulated water element by element 
			// consider the amount of water on i'th bar, the 
			// amount of water accumulated on this particular 
			// bar will be equal to min(left[i], right[i]) - arr[i] . 
			for (int i = 0; i < n; i++) 
				water += Math.min(left[i],right[i]) - arr[i]; 

			return water; 
		} 

	}

	/**
	 * timeComplexity : O(n) spaceComplexity: O(1);
	 * @author biswaspa
	 *
	 */
	private static class Solution {

		public int trap(int[] height) {
			int length = height.length;
			int left = 0;
			int right = length - 1;
			int leftMax = 0;
			int rightMax = 0;
			int answer = 0;
			while (left <= right) {
				if (height[left] <= height[right]) {
					if (height[left] >= leftMax)
						leftMax = height[left];
					else 
						answer += leftMax - height[left];
					left += 1;
				}
				else {
					if (height[right] >= rightMax)
						rightMax = height[right];
					else 
						answer += rightMax - height[right];
					right -= 1;
				}
			}
			return answer;
		}
	}

}
