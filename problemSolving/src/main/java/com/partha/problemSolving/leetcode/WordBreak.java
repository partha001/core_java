package com.partha.problemSolving.leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * referrence video : https://www.youtube.com/watch?v=iWenZCZEBIA
 * @author partha
 *
 */
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution1 {
	    public boolean wordBreak(String s, List<String> wordDict) {
	        int length = s.length();
	        boolean[] dp=new boolean[s.length()+1];
	        dp[0] = true;
	        for(int i=0;i<=length;i++){
	            for(int j=0;j<i;j++){
	                if(dp[j] && wordDict.contains(s.substring(j,i))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[length];
	    }
	}
	
	
	/**
	 * optimising above solution by introducing max length. 
	 * overall algo remains same.
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    public boolean wordBreak(String s, List<String> wordDict) {
	        int length = s.length();
	        boolean[] dp=new boolean[s.length()+1];
	        dp[0] = true;
	        
	        int maxLength = 0;
	        for(String word: wordDict)
	        	maxLength = Math.max(maxLength,word.length());
	        
	        for(int i=0;i<=length;i++){
	            for(int j=0;j<i;j++){
	            	if(i-j> maxLength)
	            		continue;
	                if(dp[j] && wordDict.contains(s.substring(j,i))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[length];
	    }
	}
	
	
	/**
	 * optimising furthur
	 * overall algo remains same.
	 * @author partha
	 *
	 */
	private static class Solution3 {
	    public boolean wordBreak(String s, List<String> wordDict) {
	        int length = s.length();
	        boolean[] dp=new boolean[s.length()+1];
	        dp[0] = true;
	        
	        int maxLength = 0;
	        for(String word: wordDict)
	        	maxLength = Math.max(maxLength,word.length());
	        
	        for(int i=0;i<=length;i++){
	            for(int j=i-1;j>=0;j--){
	            	if(i-j> maxLength)
	            		continue;
	                if(dp[j] && wordDict.contains(s.substring(j,i))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[length];
	    }
	}

}
