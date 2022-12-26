package com.partha.problemSolving.leetcode;

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
	 * https://www.youtube.com/watch?v=DfljaUwZsOk
	 * note1:using queue to store index and not actual values
	 * note2: the algo is used to stored the values in descending order in queue. 
		 * [not actually descending of indexes. but descending order of values in nums]
		 * that is why we always poll from right and the index of the element with the highest value 
		 * is always present at the first of the queue.
	 */
	private static class Solution2{
		public int[] maxSlidingWindow(int[] nums, int k) {		

			if (nums == null || k <= 0) {
				return new int[0];
			}
			
			int n = nums.length;
			int[] result = new int[n-k+1];
			int right = 0;
			Deque<Integer> queue = new ArrayDeque<>(); //used to store index
			for (int i = 0; i < nums.length; i++) {
				// remove numbers out of range k
				while (!queue.isEmpty() && queue.peek() < i - k + 1) {
					queue.poll();
				}
				// remove smaller numbers in k range as they are useless
				while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
					queue.pollLast();
				}
				// q contains index... r contains content
				queue.offer(i);
				if (i >= k - 1) {
					result[right++] = nums[queue.peek()];
				}
			}
			return result;
		}

	}	
	
	
	
	/**
	 * https://www.youtube.com/watch?v=CZQGRp93K4k
	 * @author partha
	 *
	 */
	static class Solution3 {
		public int[] maxSlidingWindow(int[] nums, int k) {

			if(nums.length == 0 || nums.length < k){
				return new int[0];
			}

			int index = 0;
			int res[] = new int[nums.length - k+1];
			Deque<Integer> dq = new ArrayDeque<Integer>();
			dq.offer(0);

			for(int i = 1;i<k;i++){
				while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
					dq.pollLast();
				}
				dq.offerLast(i);
			}

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


}
