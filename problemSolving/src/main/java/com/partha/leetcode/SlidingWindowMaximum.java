package com.partha.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * @author biswaspa
 *
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] arr = new int[] {1,3,-1,-3,5,3,6,7};
		new SlidingWindowMaximum.Solution2().maxSlidingWindow(arr, 3);
	}

	/**
	 * brute-force 
	 * time complexity O(nxn)
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
		public int[] maxSlidingWindow(int[] nums, int k) {
			int length = nums.length - k + 1 ;
			int[] arr = new int[length];
			for(int i=0;i<length;i++){
				int max = nums[i];
				for(int j=0;j<k;j++){
					if(nums[i+j]>max)
						max=nums[i+j];
				}
				arr[i]=max;
			}       
			return arr;
		}
	}


	/**
	 * https://www.youtube.com/watch?v=CZQGRp93K4k
	 * @author partha
	 *
	 */
	static class Solution2 {
		public int[] maxSlidingWindow(int[] nums, int k) {
			if(nums.length == 0 || nums.length < k){
				return new int[0];
			}


			int res[] = new int[nums.length - k+1];
			Deque<Integer> dq = new ArrayDeque<Integer>();

			for(int i = 0;i<k;i++){
				while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
					dq.pollLast();
				}
				dq.offerLast(i);
			}

			int index = 0;
			res[index++] = nums[dq.peek()];

			for(int i = k;i<nums.length;i++){
				if(i - k == dq.peek()){
					dq.pollFirst();
				}
				while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
					dq.pollLast();
				}
				dq.offerLast(i);
				res[index++] = nums[dq.peek()];
			}

			return res;  
		}
	}



	/**
	 * https://www.youtube.com/watch?v=DfljaUwZsOk
	 * same algo as above written in much crisp style.
	 * note1:using queue to store index and not actual values
	 * note2: the algo is used to stored the values in descending order in queue. 
	 * [not actually descending of indexes. but descending order of values in nums]
	 * that is why we always poll from left to populate our result array 
	 * is always present at the first of the queue.
	 */
	private static class Solution3{
		public int[] maxSlidingWindow(int[] nums, int k) {		

			if (nums == null || k <= 0) {
				return new int[0];
			}

			int n = nums.length;
			int[] result = new int[n-k+1]; //thus result will contain n-k+1 elements
			int right = 0;
			Deque<Integer> queue = new ArrayDeque<>(); //used to store index
			for (int i = 0; i < nums.length; i++) {
				// removing out of range indices from queue from left side
				while (!queue.isEmpty() && queue.peek() < i - k + 1) {
					queue.poll();
				}
				// removing indexes from right which contains small values than currrent
				while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
					queue.pollLast();
				}
				//thus at this point queue will only contain indexes that contains larger value than current.

				queue.offer(i); //adding the current index

				//populating result from k-1 index by readig from the head of the queue.
				if (i >= k - 1) {
					result[right++] = nums[queue.peek()];
				}
			}
			return result;
		}

	}	





}
