package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms-ii
 * @author partha
 *
 */
public class MeetingRooms2 {

	public static void main(String[] args) {

	}
	
	private static class Solution1 {
	    public int minMeetingRooms(int[][] intervals) {
	        int[] starts = new int[intervals.length];
	        int[] ends = new int[intervals.length];
	        for(int i=0;i<intervals.length;i++){
	            starts[i] = intervals[i][0];
	            ends[i] = intervals[i][1];
	        }

	        Arrays.sort(starts);
	        Arrays.sort(ends);
	        int result = 1;
	        int rooms = 1;
	        int sIndex =1;
	        int eIndex =0;
	        while(sIndex<intervals.length){ // coz once all meetings have started/accomodated we dont care when they end
	        if(starts[sIndex]<ends[eIndex]){
	            rooms++;
	            sIndex++;
	        }else{
	            rooms--;
	            eIndex++;
	        }
	        result = Math.max(result, rooms);
	        }
	        return result;
	    }
	}

}
