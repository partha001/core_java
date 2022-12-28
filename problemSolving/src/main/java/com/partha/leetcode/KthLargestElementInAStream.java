package com.partha.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * @author partha
 *
 */
public class KthLargestElementInAStream {

	public static void main(String[] args) {
		
	}
	
	/**
	 * https://www.youtube.com/watch?v=hOjcdrqMoQ8
	 * @author partha
	 *
	 */
	class KthLargest {
		
	    private int k;
	    private PriorityQueue<Integer> heap;
	    
	    public KthLargest(int k, int[] nums) {
	        this.k = k;
	        heap = new PriorityQueue<>();
	        
	        for (int num: nums) {
	            heap.offer(num);
	        }
	        
	        while (heap.size() > k) {
	            heap.poll();
	        }
	    }
	    
	    public int add(int val) {
	        heap.offer(val);
	        if (heap.size() > k) {
	            heap.poll();
	        }

	        return heap.peek();
	    }
	}

}
