package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/hand-of-straights/
 * @author biswaspa
 *
 */
public class HandsOfStraight {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList();
		list.add(2);
		list.add(1);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		minHeap.addAll(list);
		System.out.println("");
//		minHeap.re

	}
	
	//https://www.youtube.com/watch?v=amnrMCVd2YI
	private static class Solution1 {
	    public boolean isNStraightHand(int[] hand, int groupSize) {
	        if (hand.length % groupSize != 0)
	            return false;

	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int card : hand)
	            map.put(card, map.getOrDefault(card, 0) + 1);

	        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	        queue.addAll(map.keySet());

	        while (!queue.isEmpty()) {
	            int firstKey = queue.peek();
	            for (int i = firstKey; i < firstKey + groupSize; i++) {
	                if (!map.containsKey(i)) // checking if the element is avaialable or not
	                    return false;

	                int count = map.get(i); // getting count if available
	                map.put(i, --count); // decrementing the availability

	                if (count == 0) { //after decrementing if count is zero
	                    if (i != queue.peek()) { //if not top-element-count!=0 and subsequent-element-count==0 not possible
	                        return false;
	                    }
	                    queue.poll();
	                }
	            }
	        }
	        return true;
	    }
	}
	
	
	//same algo but using treemap as to combine the MinHeap and Map
	//however this takes more time and execution memory.
	private static class Solution2 {
	    public boolean isNStraightHand(int[] hand, int groupSize) {
	        if(hand.length%groupSize!=0)
	             return false;

	        TreeMap<Integer, Integer> map= new TreeMap<Integer,Integer>();
	        for(int card: hand)
	            map.put(card, map.getOrDefault(card, 0)+1);

	        while(!map.isEmpty()){
	            int firstKey = map.firstKey();
	            for(int i=firstKey;i<firstKey + groupSize;i++){
	                if(!map.containsKey(i)) //if the key is not present
	                     return false;
	                 int count = map.get(i);
	                 if(count-1==0){
	                     map.remove(i);
	                 }else{
	                     map.put(i, count-1);
	                 }
	            }
	        }
	        return true;
	     }
	 }
	

}
