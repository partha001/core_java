package com.partha.leetcode;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * @author biswaspa
 *
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//iterative compare start-end solution
	private static class Solution1 {
		public boolean isMatch(String s, String p) {
		    // optional step, remove repeated .*
	        StringBuilder sb = new StringBuilder();
	        sb.append(p.charAt(0));
	        int i = 1;
	        while (i < p.length()) {
	            sb.append(p.charAt(i));
	            if (p.charAt(i++) == '*' && p.charAt(i-2) == '.') {
	                while (i < p.length() - 1 && p.charAt(i) == '.' && p.charAt(i+1) == '*') {
	                    i += 2;
	                }
	            }
	        }
//	        System.out.println(sb);
	        return isMatch(s.toCharArray(), 0, sb.toString().toCharArray(), 0);
	    }

	    private boolean isMatch(char[] s, int si, char[] p, int pi) {
	        if (si == s.length && pi == p.length) {
	            return true;
	        } else if (pi == p.length) {
	            return false;
	        } else if (si == s.length) {
	            while (++pi < p.length && p[pi] == '*') {
	                ++pi;
	            }
	            return pi > p.length;
	        } else {
	            if (pi + 1 < p.length && p[pi+1] == '*') {
	                if (isMatch(s, si, p, pi + 2)) {
	                    return true;
	                } else {
	                    while (si < s.length && (p[pi] == '.' || p[pi] == s[si])) {
	                        if (isMatch(s, ++si, p, pi + 2)) {
	                            return true;
	                        }
	                    }
	                    return false;
	                }
	            } else {
	                if (p[pi] == '.' || p[pi] == s[si]) {
	                    return isMatch(s, ++si, p, ++pi);
	                } else {
	                    return false;
	                }
	            }
	        }
	    }
	}
	
	
	//using dp and memoization
	private static class Solution2 {
	    public boolean isMatch(String s, String p) {
	        Boolean[][] dp = new Boolean[s.length()+1][p.length()];
	        return dfs(s, p, dp, 0, 0);
	    }
	    
	    boolean dfs(String s, String p, Boolean[][] dp, int i, int j){
	        // Both i and j have reached the end of the respective strings, then definitely we have found a match
	        if(i >= s.length() && j >= p.length())
	            return true;
	        
	        // If we have reached the end of p, but we haven't reached end of s, then we have a mismatch
	        // The vice-versa is however not always true.
	        if(j >= p.length())
	            return false;
	        
	        if(dp[i][j] == null){
	            boolean isMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
	            
	            // If the next char (j+1)th in p is a *, then we have 2 options -
	            //  1. Ignore the jth char and compare ith char with (j+2)th char as j+1 is '*'
	            //  2. Match the 2 chars in i & j of s an p respectively and then
	            //     consider the same jth char for comparison with the next char of i
	            if(j+1 < p.length() && p.charAt(j+1) == '*')
	                dp[i][j] = dfs(s, p, dp, i, j+2) || // When jth char in p is ignored
	                           (isMatch && dfs(s, p, dp, i+1, j)); // When jth char is used for comparison with next char of s
	            
	            // If the 2 chars in s and p match, then we explore the next 2 chars in both
	            else if(isMatch)
	                dp[i][j] = dfs(s, p, dp, i+1, j+1);
	            
	            // We couldn't find a match
	            else
	                dp[i][j] = false;
	        }
	        return dp[i][j];
	    }
	}
	
	
	
	
	
	
	/************************************ leetcode official solutions start   ***********************************/
	
	
	/**
	 * @approach recursive solution
	 * @author biswaspa
	 *
	 */
	private static class LeetcodeOfficialSolution1 {
	    public boolean isMatch(String text, String pattern) {
	        if (pattern.isEmpty()) return text.isEmpty();
	        boolean first_match = (!text.isEmpty() &&
	                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

	        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
	            return (isMatch(text, pattern.substring(2)) ||
	                    (first_match && isMatch(text.substring(1), pattern)));
	        } else {
	            return first_match && isMatch(text.substring(1), pattern.substring(1));
	        }
	    }
	}
	
	
	
	
	/**
	 * @approach  Dynamic Programming Top down approach
	 * TC O(TP)
	 * SC O(TP)
	 * @author biswaspa
	 *
	 */
	private enum Result {
	    TRUE, FALSE
	}

	private static class LeetcodeOfficialSolution2 {
	    Result[][] memo;

	    public boolean isMatch(String text, String pattern) {
	        memo = new Result[text.length() + 1][pattern.length() + 1];
	        return dp(0, 0, text, pattern);
	    }

	    public boolean dp(int i, int j, String text, String pattern) {
	        if (memo[i][j] != null) {
	            return memo[i][j] == Result.TRUE;
	        }
	        boolean ans;
	        if (j == pattern.length()){
	            ans = i == text.length();
	        } else{
	            boolean first_match = (i < text.length() &&
	                                   (pattern.charAt(j) == text.charAt(i) ||
	                                    pattern.charAt(j) == '.'));

	            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
	                ans = (dp(i, j+2, text, pattern) ||
	                       first_match && dp(i+1, j, text, pattern));
	            } else {
	                ans = first_match && dp(i+1, j+1, text, pattern);
	            }
	        }
	        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
	        return ans;
	    }
	}
	
	
	
	
	/**
	 * @approach  Dynamic Programming BottomUp approach
	 * TC O(TP)
	 * SC O(TP)
	 * @author biswaspa
	 *
	 */
	class LeetcodeOfficialSolution3 {
	    public boolean isMatch(String text, String pattern) {
	        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
	        dp[text.length()][pattern.length()] = true;

	        for (int i = text.length(); i >= 0; i--){
	            for (int j = pattern.length() - 1; j >= 0; j--){
	                boolean first_match = (i < text.length() &&
	                                       (pattern.charAt(j) == text.charAt(i) ||
	                                        pattern.charAt(j) == '.'));
	                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
	                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
	                } else {
	                    dp[i][j] = first_match && dp[i+1][j+1];
	                }
	            }
	        }
	        return dp[0][0];
	    }
	}
	
	
	/************************************ leetcode official solutions end   ***********************************/
	

}
