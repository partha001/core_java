package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] points = new int[][] {{5,-1},{3,3},{-2,4}};
		new KClosestPointsToOrigin.Solution1().kClosest(points, 2);
	}
	
	
	/**
	 * my solution
	 * @author partha
	 *
	 */
	private static class Solution1 {
	     public int[][] kClosest(int[][] points, int K) {
		        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0]-y[0]); // here storing int[distace, index] in the queue
		        
		        for(int i=0;i<points.length;i++){
	                int[] point = points[i];
	                int distance = point[0]*point[0] + point[1]*point[1];
	                int[] element = new int[]{distance,i};
	                pq.add(element);
		        }
		        
		        int[][] result = new int[K][2];
	            int i=0;
	            while(i<K && !pq.isEmpty()){
	               int[] head = pq.poll();
	               result[i++] = points[head[1]];
	            }
	            return result;
		    }
	}
	
	
	private static class Solution2 {
	    // Priority Queue
	    // TC: O(N Log N)
	    // SC: O(K)
	    public int[][] kClosest(int[][] points, int K) {
	        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0]*x[0] + x[1]*x[1]) - (y[0]*y[0]+y[1]*y[1]));
	        
	        for(int[] point: points){
	            pq.add(point);
	        }
	        
	        List<int[]> list = new ArrayList<>();
	        while( K > 0 ){
	            list.add(pq.poll());
	            K--;
	        }
	        
	        int[][] res = new int[list.size()][2];
	        return list.toArray(res);
	    }
	}

}
