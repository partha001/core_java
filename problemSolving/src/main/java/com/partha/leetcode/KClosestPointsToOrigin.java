package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] points = new int[][] {{5,-1},{3,3},{-2,4}};
		new KClosestPointsToOrigin.Solution().kClosest(points, 2);
	}
	
	
	private static class Solution {
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
