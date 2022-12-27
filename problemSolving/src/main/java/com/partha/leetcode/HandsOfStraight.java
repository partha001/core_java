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
	        if(hand.length%groupSize!=0)
	            return false;
	        
	        //counting occurances
	        Map<Integer,Integer> map = new HashMap();
	        IntStream.range(0,hand.length).forEach(i -> {
	            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
	        });
	        
	        PriorityQueue<Integer> queue = new PriorityQueue<>();
	        queue.addAll(map.keySet());

	        while(!queue.isEmpty()){
	            int first = queue.peek();
	            for(int i=first;i<first+groupSize;i++){
	                
	                //checking if the element is avaialable or not
	                if(map.get(i)==null) 
	                    return false;

	                //getting count if available
	                int count = map.get(i);
	                map.put(i, --count); //decrementing the availability

	                //if count after decrement is 0 then we have to pop from MinHeap
	                if(count==0){
	                    if(i!=queue.peek()){
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
	private static class Solution {
	    public boolean isNStraightHand(int[] hand, int groupSize) {
	        if(hand.length%groupSize!=0)
	            return false;
	        
	        //counting occurances
	        TreeMap<Integer,Integer> map = new TreeMap();
	        IntStream.range(0,hand.length).forEach(i -> {
	            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
	        });
	        
	        while(map.size()>0){
	            int first = map.firstKey();
	            for(int i=first;i<first+groupSize;i++){
	               
	               if(!map.containsKey(i))
	                    return false;
	             
	                int count = map.get(i); //get availability
	                count-- ; //decrementing availability
	                if(count==0){
	                   map.remove(i);
	                }else{
	                    map.put(i,count);
	                }
	            }
	        }
	        return true;
	    }
	}
	

}
