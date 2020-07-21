package com.partha.problemSolving.peerProgramming;

/**
 * link : https://leetcode.com/problems/longest-common-prefix/
 * @author biswaspa
 *
 */
public class Day3Problem3LongestCommonPrefix {
	
	public static void main(String[] args) {
		System.out.println(new Solution().longestCommonPrefix(new String[] {"a","ac"}));
	}
	
	static class Solution {
		
	    public String longestCommonPrefix(String[] strs) {
	    	String result = "";
	        if(strs.length==0) {
	        	//do nothing
	        }else if(strs.length==1 ) {
	        	result = strs[0];
	        }else if(strs[0]==null  || strs[0].length()==0){
	        	//do nothing
	        }else {
	        	boolean mismatchFound = false;
	        	for(int i=0;i<strs[0].length();i++) {
	        		char c = strs[0].charAt(i);
	        		for(int j=1;j<strs.length;j++)
	        		{
	        			if(strs[j]!=null && strs[j].length()>i && strs[j].charAt(i)==c) {
	        				//do nothing
	        			}else {
	        				mismatchFound = true;
	        				break ;
	        			}
	        		}
	        		
	        		if(mismatchFound) {
	        			break;
	        		}else {
	        			result = result + c;
	        		}
	        		
	        	}
	        }	        
	        return result ;
	    }
	}
	
}



