package com.partha.problemSolving.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;


public class MinimumIntervalToIncludeEachQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = new int[][]{{1,4},{2,4},{3,6},{4,4}};
		int[] queries = new int[]{2,3,4,5};
//		int[] q = new int[] {queries};
//		queries[0] = 10;
//		
		new MinimumIntervalToIncludeEachQuery.Solution1().minInterval(intervals, queries);
	}
	
	
	/**
	 * brute-force/ naive approach . hence it might exceed timelimit for large dataset
	 * @author partha
	 * algo : for each query we check every intervals and find the size of the minimum interval
	 */
	private static class Solution1 {
	    public int[] minInterval(int[][] intervals, int[] queries) {
	        int[] result = new int[queries.length];
	        for(int i=0;i<queries.length;i++){
	            int min =Integer.MAX_VALUE;
	            for(int j=0;j<intervals.length;j++){
	                if(queries[i]>= intervals[j][0] && queries[i]<=intervals[j][1])
	                    min = Math.min(min, intervals[j][1] - intervals[j][0] + 1);
	            }
	            result[i] = (min==Integer.MAX_VALUE )? -1: min ;
	        }
	        return result;
	    }
	}
	
	
	class Solution {
	    public int[] minInterval(int[][] intervals, int[] queries) {
		    //sort intervals
	        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
	        //add [index,query]
	        int[][] q = new int[queries.length][2];
	        for (int i=0;i<queries.length;i++){
	            q[i][0] = i; //storing index of the query
	            q[i][1] = queries[i]; // storing value of the query
	        }
	        //sort the queries by query val
	        Arrays.sort(q, (a,b) -> a[1]-b[1]);
	        //store the minimum intervals in the priority queue, min heap
	        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-a[0])-(b[1]-b[0]));
	        int[] result = new int[queries.length];
	        int j = 0;
	        for (int i=0;i<q.length;i++){
	            int index = q[i][0];
	            int val = q[i][1];
	            // if start is less than query val, then add to pq
	            while (j < intervals.length && intervals[j][0] <= val) pq.offer(intervals[j++]);
	            //anything which has the end lesser than the val then remove it
	            while (!pq.isEmpty() && pq.peek()[1] < val) pq.poll();
	            //add difference to the result
	            result[index]= pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1;
	        }
	    return result;
	    }
	}
	
	
	
	//same algo written using hashMap to store the corresponding value of queries[]
	private static class Solution2 {
	    public int[] minInterval(int[][] intervals, int[] queries) {
	        //Arrays.sort(queries); cant sort queries since the ordering of the result will get lost
	        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

	         PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) ->{
	            return (a[1]-a[0])  - (b[1]-b[0]);
	        });

	        Map<Integer,Integer> map =new HashMap<Integer,Integer>(); //
	        int[] q = new int[queries.length]; //creating copy of queries 
	        for(int i=0;i<queries.length;i++)
	            q[i] = queries[i];

	        //now since we have a copy of queries its safe to sort.
	        Arrays.sort(q);
	        int current=0;
	        for(int i=0;i<q.length;i++){
	            //pushing all where interval-start is less than q[i]
	            while(current<intervals.length &&  intervals[current][0]<= q[i])
	                queue.add(intervals[current++]);            

	            //popping out interval-end where end is smaller than q[i]
	            while( !queue.isEmpty() && queue.peek()[1]<q[i])
	                queue.remove();
	            

	            map.put(q[i], queue.isEmpty()? -1: queue.peek()[1] - queue.peek()[0] +1);         
	        }

	        //note result should be in the order as the orginial quries were
	        int[] result = new int[queries.length];
	        for(int i=0;i<q.length;i++)
	        	result[i] = map.get(queries[i]);
	        return result;
	    }
	}
	
	
	

}
