package com.partha.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/relative-ranks
 * @author partha
 *
 */
public class RelativeRanks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * TC O(N log N)
	 * SC O(N) 
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    public String[] findRelativeRanks(int[] score) {
	        String arr[] = new String[score.length];
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        for(int i=0;i<score.length;i++){
	            pq.add(score[i]);
	        }
	        HashMap<Integer,String> map = new HashMap<>();
	        int idx = 1;
	        while(!pq.isEmpty()){
	            if(idx==1){
	                map.put(pq.remove(),"Gold Medal");
	            }
	            else if(idx ==2){
	                map.put(pq.remove(),"Silver Medal");
	            }
	            else if(idx ==3){
	                map.put(pq.remove(),"Bronze Medal");
	            }
	            else{
	                map.put(pq.remove(),Integer.toString(idx));
	            }
	            idx++;
	        }
	        for(int i=0;i<score.length;i++){
	            arr[i] = map.get(score[i]);
	        }
	        return arr;
	    }
	}
	
	
	/**
	 * TC O(N log N)
	 * SC O(N) 
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    public String[] findRelativeRanks(int[] score) {
	        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)-> b[0] - a[0]);
	        for(int i=0;i<score.length;i++){
	            int[] arr = new int[]{score[i],i};
	            queue.add(arr);
	        }
	        String[] result = new String[score.length];

	        int i=1;
	        while(!queue.isEmpty()){
	            int[] arr= queue.remove();
	            int position = arr[1];
	            result[position] = getAward(i);
	            i++;
	        }
	        return result;
	    }

	    private String getAward(int i){
	        if(i==1)
	            return "Gold Medal";
	        if(i==2)
	            return "Silver Medal";
	        if(i==3)
	            return "Bronze Medal";
	        return String.valueOf(i);
	    }
	}


}
