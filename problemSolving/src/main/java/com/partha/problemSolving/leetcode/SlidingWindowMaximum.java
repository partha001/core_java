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

	}
	
	/**
	 * brute-force 
	 * time complexity O(nxn)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
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
	
	
	static class Solution2 {
		public int[] maxSlidingWindow(int[] nums, int k) {
			if(k==1) //case : when k =1 
				return nums;
			
			int length = nums.length - k +1 ;
			if(length==1) //case when nums has only one element
				return nums;
			
			int[] result = new int[length];
			
			
			return result;
		}
	}
	
	
	
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
