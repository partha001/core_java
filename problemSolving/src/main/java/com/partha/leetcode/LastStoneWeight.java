package com.partha.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int lastStoneWeight(int[] stones) {
	        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
	        //PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)-> b-a); //this is also the same.
	        
	        
	        for(int i:stones)
	            queue.add(i);

	        while(queue.size()>=2){
	            int first = queue.remove();
	            int second = queue.remove();
	            if(first!=second){
	                queue.add(first-second);
	            }
	        }

	        return queue.isEmpty()? 0 : queue.peek();
	    }
	}	

}
