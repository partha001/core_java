package com.partha.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-i/
 * @author partha
 *
 */
public class MyCalendar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * TC: O(n * logn), SC: O(n)
	 * @author partha
	 *
	 */
	private static class MyCalendar {
	    TreeMap<Integer,Integer> calendar = new TreeMap<>();
	    public MyCalendar() {
	        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
	    }
	    public boolean book(int start, int end) {
	        Map.Entry<Integer,Integer> pair = calendar.higherEntry(start);
	        boolean res = end <= pair.getValue();
	        if (res) calendar.put(end, start);
	        return res;
	    }
	}
	
	
	
	/**
	 * TC: O(n * logn), SC: O(n)
	 * same algo as above. but not using Inter.MAX_VALUE . Rather using floorEntry and ceilingEntry
	 * @author partha
	 *
	 */
	private static class MyCalendar2 {
	    
	    TreeMap<Integer, Integer> map;
	    
	    public MyCalendar2() {
	        map = new TreeMap();
	    }
	    
	    public boolean book(int start, int end) {
	        Integer smallerKey = map.floorKey(start), greaterKey = map.ceilingKey(start);
	        
	        if (smallerKey == null || map.get(smallerKey) <= start) {
	            if (greaterKey == null || greaterKey >= end) {
	                map.put(start, end);
	                return true;
	            }
	        } 
	        return false;
	    }
	}

}
