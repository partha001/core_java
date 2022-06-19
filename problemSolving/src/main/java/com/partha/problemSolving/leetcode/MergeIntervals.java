package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.List;

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

}
