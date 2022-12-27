package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 * @author partha
 *
 */
public class NonOverlappingIntervals {

	public static void main(String[] args) {
//		int[][] intervals = new int[][]{{1,3},{1,2},{4,5}};
//		 Arrays.sort(intervals, (a,b) -> {
//	           if(a[0]==b[0])
//	                return b[1] - a[1];
//	            return a[0] - b[0];
//	        });
//		 System.out.println("");
		
		int[][] intervals = new int[][]{{1,2},{2,3},{1,3}};
		new NonOverlappingIntervals.Solution1().eraseOverlapIntervals(intervals);
		System.out.println("");
	}
	
	
	
	//https://www.youtube.com/watch?v=nONCGxWoUfM
	private static class Solution1 {
	    public int eraseOverlapIntervals(int[][] intervals) {
	    	
	    	//sorting the array w.r.to first , second element
	    	//i.e if first element is same then sorting based on second element
	        Arrays.sort(intervals, (a,b) -> { 
	           if(a[0]==b[0])
	                return a[1] - b[1];
	            return a[0] - b[0];
	        });
	        
	        int result  = 0;
	        int prevEnd = intervals[0][1];
	        for(int i=1;i<intervals.length;i++){
	            int start = intervals[i][0];
	            int end = intervals[i][1];
	            
	            //below is condition for non-overlapping. note having '=' is important
	            // since [2,3] and [3,4] are non overlapping
	            if( start >= prevEnd){ 
	                prevEnd = end; 
	            }else{ // case: overlapping
	                result++;
	                prevEnd = Math.min(end, prevEnd); 
	                //note1: here we dont need to delete element rather update the prevEnd and move ahead
	               //note2: also note here we are seting prevEnd to min as if we set it max(env,prevEnd) then the overlap
	               //will be larger and hence we have to remove more number of elements to get non-overlapping resultset.
	               //however here the problem is to find min number of elements to be removed.
	            }
	        }
	        return result;
	    }
	}

}
