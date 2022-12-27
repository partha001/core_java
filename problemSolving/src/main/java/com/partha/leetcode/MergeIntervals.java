package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/merge-intervals
 * @author partha
 *
 */
public class MergeIntervals {

	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,4},{0,2},{3,5} };
		new Solution1().merge(arr);
	}
	
	
	private static class Solution1 {
	    public int[][] merge(int[][] intervals) {
	        int rows = intervals.length;
	        List<Element> list = new ArrayList<Element>();
	        if(rows<=1)
	            return intervals;
	        
	      // list.add(new Element(intervals[0][0], intervals[0][1]));
	        for(int i=0;i<intervals.length;i++){
	            list.add(new Element(intervals[i][0],intervals[i][1]));
	        }
	        
	        //the below step is vital to ensure elements are sorter
	        list.sort((a,b) -> a.start - b.start);
	        
           int i=1;
	       while(i<list.size()){ //note while loop is being used since we are processing and removing current element
	            if((list.get(i).start <= list.get(i-1).end)){
	                list.get(i-1).end = Math.max(list.get(i).end, list.get(i-1).end);
	                list.remove(i);
	            }else{
                    i++;
                }
	        }
	        
	        
	        int[][] result = new int[list.size()][2];
	        for(int j=0;j<list.size();j++){
	            result[j][0] = list.get(j).start;
	            result[j][1] = list.get(j).end;
	        }
	        
	        return result;
	    }
	    
	    
	    private static class Element {
	        int start;
	        int end;
	        
	        public Element(){
	            super();
	        }
	        
	        public Element(int start,int end){
	            this.start = start;
	            this.end = end;
	        }
	    }
	}
	
	
	
	
	//same algo but without taking extra class
	class Solution {
	    public int[][] merge(int[][] intervals) {
	        List<int[]> list = new ArrayList<int[]>();
	        IntStream.range(0, intervals.length).forEach(i -> list.add(intervals[i]));
	        list.sort((a,b)->a[0] -b[0]);

	        int i=1;
	        while(i<list.size()){
	            int[] previous = list.get(i-1);
	            int[] current = list.get(i);
	            if(current[0]<= previous[1]){
	                previous[1] = Math.max( previous[1], current[1] );
	                list.remove(i);
	            }else{
	                i++;
	            }
	        }

	        int[][] result = new int[ list.size()][2];
	        IntStream.range(0,list.size()).forEach(index -> result[index]= list.get(index));
	        return result;
	    }
	}

}
