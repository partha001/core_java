package com.partha.problemSolving.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * @author biswaspa
 *
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution1 {
	    Map<String, Integer> map = new HashMap<>();
	    public int minInsertions(String s) {
	        if(map.containsKey(s)) return map.get(s);
	        if(s.length() <= 1) return 0;
	        int left = 0, right = s.length()-1;
	        while(left <= right && s.charAt(left)== s.charAt(right)){
	            left++;
	            right--;
	        }
	        if(left > right) return 0;
	        String subStr = s.substring(left, right+1);
	        if(subStr.length() == 2) return 1;
	        map.put(s, Math.min(minInsertions(subStr.substring(1)), minInsertions(subStr.substring(0, subStr.length()-1)))+1);
	        return map.get(s);
	    }
	}
	
	
	private static class Solution2 {
		
	    int dp[][]=new int [501][501];
	    
	    public int minInsertions(String s) {
	        for(int d[]:dp){
	            Arrays.fill(d,-1);
	        }
	        
	        return helper(s,0,s.length()-1);
	    }
	    
	    public int helper(String s, int i, int j){
	        if(i==j || i>j) return 0;
	        else if(dp[i][j]!=-1) return dp[i][j];
	        else if(s.charAt(i)==s.charAt(j)) return helper(s,i+1,j-1);
	        else{
	            dp[i][j]=Math.min(helper(s,i+1,j),helper(s,i,j-1))+1;
	        }
	        return dp[i][j];
	    }
	}

}
