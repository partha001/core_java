package com.partha.problemSolving.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * @author partha
 *
 */
public class MedianFromDataStream {

	public static void main(String[] args) {

	}
	
	private static class MedianFinder {
		
	    Queue<Double> max;
	    Queue<Double> min;
	    /** initialize your data structure here. */
	    public MedianFinder() {
	        max = new PriorityQueue<>(Collections.reverseOrder());
	        min = new PriorityQueue<>();
	    }
	    
	    public void addNum(int num) {
	        max.offer((double)num);
	        min.offer(max.poll());
	        if (max.size() < min.size()) max.offer(min.poll());
	    }
	    
	    public double findMedian() {
	        if (max.size() == 0) return 0;
	        else if(max.size() == min.size()) return (max.peek() + min.peek()) / 2;
	        return max.peek();
	    }
	}

}
