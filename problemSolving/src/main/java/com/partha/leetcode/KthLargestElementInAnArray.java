package com.partha.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * @author biswaspa
 *
 */
public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[]{3,2,1,5,6,4};

		new KthLargestElementInAnArray.Solution3().findKthLargest(arr, 2);
	}

	/**
	 * using bubble sort approach
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
		public int findKthLargest(int[] nums, int k) {

			for(int i=0;i<k;i++){
				for(int j=0;j<nums.length-i-1;j++){
					if(nums[j]>nums[j+1]){
						int temp = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = temp;
					}
				}
			}
			return nums[nums.length-k];
		}
	}


	/**
	 * using selection sort
	 */
	static class Solution {
		public int findKthLargest(int[] nums, int k) {

			for(int i=0;i<k;i++){
				int largestIndex = 0;
				for(int j=0;j<nums.length-i;j++){
					if(nums[largestIndex]<nums[j])
						largestIndex = j;
				}
				int temp = nums[largestIndex];
				nums[largestIndex] = nums[nums.length-i-1];
				nums[nums.length-i-1] = temp;
			}
			return nums[nums.length-k];
		}
	}

	/**
	 * using priority queue
	 * it is to be noted that here am polling rest of item while inserting only . since so point in keeping items less than k
	 * time complexity : NlogN
	 */
	static class Solution3 {
		public int findKthLargest(int[] nums, int k) {        
			PriorityQueue<Integer> pq = new PriorityQueue<>();        
			for(int num : nums){
				pq.add(num);
				if(pq.size() > k) pq.poll(); //only keeping k elements in the queue 
			}
			return pq.peek();
		}
	}

}
