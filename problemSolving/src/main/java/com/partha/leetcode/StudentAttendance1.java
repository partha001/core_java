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
				if(current=='A'){ //absent case
					absent++;
					if(absent>=2)
						return false;
					i++;
					continue;
				}
				else if(current=='P'){ //case present
					i++;
					continue;
				}
				else {	//case late
					int lateCount=0;
					while(i<s.length() && s.charAt(i)=='L'){
						lateCount++;
						i++;
						if(lateCount>=3)
							return false;
					}
				}
			}
			return true;
		}
	}
	
	
	
	
	private static class Solution2 {
	    public boolean checkRecord(String s) {
	        int absent=0;
	        String temp ="";
	       for(char c:s.toCharArray()){
	           if(c=='A')
	                absent++;
	            
	            if(c=='L'){
	                temp += 'L';
	            }else{
	                temp="";
	            }

	            if(absent>=2 || temp.length()>=3)
	                return false;
	       } 
	       return true;
	    }
	}


}
