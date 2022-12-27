package com.partha.leetcode;

/**
 * https://leetcode.com/problems/implement-strstr/
 * @author biswaspa
 *
 */
public class ImplementStrStr {

	public static void main(String[] args) {

	}
	
	/**
	 * 
	 * @author biswaspa
	 *
	 */
	static class Solution {
	    
	    public int strStr(String haystack, String needle) {
	       if(haystack.length()==0 && needle.length() == 0 ){
	           return 0;
	       }else if(haystack.length()==needle.length() && haystack.equals(needle)){
	           return 0;
	       }else if(haystack.length()<needle.length()){
	           return -1;
	       } else {
	    
	        int needleLength = needle.length(); 
	        for(int i=0;i<haystack.length();i++){
	            if( i+needleLength <= haystack.length()) {
	                
	                if(haystack.substring(i,i+needleLength).equals(needle) ){
	                    return i;
	                }
	                
	            }
	        }
	        return -1;
	       }
	    }
	}

}
