package com.partha.leetcode;

/**
 * https://leetcode.com/problems/student-attendance-record-i
 * @author biswaspa
 *
 */
public class StudentAttendance1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution {
	    public boolean checkRecord(String s) {
	        int absent=0;
	        int i=0;
	        while(i<s.length()){
	            char current = s.charAt(i);
	            if(current=='A'){
	                absent++;
	                if(absent>=2)
	                    return false;
	                i++;
	                continue;
	            }

	            int lateCount=0;
	            while(i<s.length() && s.charAt(i)=='L'){
	                lateCount++;
	                i++;
	                if(lateCount>=3)
	                    return false;
	            }

	            if(current=='P')
	                i++;
	                     
	        }
	        return true;
	    }
	}

}
