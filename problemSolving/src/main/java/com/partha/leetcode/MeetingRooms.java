package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms/
 * @author partha
 *
 */
public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution1 {
	    public boolean canAttendMeetings(int[][] intervals) {
	        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
	        for(int i=1;i<intervals.length;i++){
	            if(intervals[i][0]< intervals[i-1][1])
	                return false;
	        }
	        return true;
	    }
	}

}
