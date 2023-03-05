package com.partha.leetcode;


/**
 * https://leetcode.com/problems/positions-of-large-groups/
 * @author partha
 *
 */
public class AddStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution { 
	    public String addStrings(String num1, String num2) { 
	        String result=""; 
	        int i=num1.length()-1; 
	        int j=num2.length()-1; 
	        int answer=0; 
	        while(i>=0 || j>=0 || answer!=0){ 
	            int x=i>=0 ? num1.charAt(i)-'0' : 0; 
	            int y=j>=0 ? num2.charAt(j)-'0' : 0; 
	            int sum=x+y+answer; 
	            result=sum%10+result ; 
	            answer=sum/10; 
	            i--; 
	            j--;
	        } 
	        return result; 
	    } 
	}

}
