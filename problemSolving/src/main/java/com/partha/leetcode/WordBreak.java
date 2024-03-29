package com.partha.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
					if(i-j<= maxLength) {
						if(dp[j] && wordDict.contains(s.substring(j,i))){
							dp[i] = true;
							break;
						}
					}
				}
			}
			return dp[length];
		}
	}
	
	/**
	 * backtracking with memoization.
	 * note that instead of checking parts of s here we match against words in dictionary
	 * https://www.youtube.com/watch?v=Sx9NNgInc3A
	 */
	private static class Solution4 {
	    public boolean wordBreak(String s, List<String> wordDict) {
	       return dfs(s,wordDict,new HashSet<String>()); //here the hashSet contains the substrig which is already checked doesnt fit the criteria.
	    }
	    
	    public boolean dfs(String s,List<String> dict,Set<String> checked){
	        if(s.equals(""))
	            return true;
	        if(checked.contains(s))
	            return false;
	        checked.add(s);
	        for(String word:dict){
	            if(s.startsWith(word) && dfs(s.substring(word.length()),dict,checked))
	                return true;
	        }
	        return false;
	    }
	}
	
	

}
