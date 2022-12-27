package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/insert-interval/
 * @author partha
 *
 */
public class InsertInterval {

	public static void main(String[] args) {

	}
	
	
	private static class Solution1 {
	    public int[][] insert(int[][] intervals, int[] newInterval) {
	        List<int[]> list = new ArrayList<int[]>();

	        //adding all interval before the new interval starts
	        int i=0;
	        while(i<intervals.length && intervals[i][1] < newInterval[0] )
	                list.add(intervals[i++]);
	        
	        //now adding ones where there is overlap
	        while(i<intervals.length && 
	                intervals[i][0] <= newInterval[1]){ //checking start of new elements since end is already taken care above
	            newInterval[0] = Math.min( newInterval[0] , intervals[i][0]);
	            newInterval[1] = Math.max( newInterval[1], intervals[i][1]);
	            i++;
	        }
	        list.add(newInterval);

	        //now adding rest of the intervals
	        while(i<intervals.length)
	            list.add(intervals[i++]);

	        int[][] result = new int[list.size()][2];
	        IntStream.range(0, list.size()).forEach(index -> result[index] = list.get(index));
	        return result;
	    }
	}

}
