package com.partha.problemSolving.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * @author biswaspa
 *
 */
public class LongestValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	// Stack Solution
	// Use stack to store the left and right parentheses's index. 
	// The current valid length is i - stack.peek().
	// Time complexity: O(N)
	// Space complexity: O(N)
	private static class Solution1 {
	    public int longestValidParentheses(String s) {
	        if (s == null || s.length() <= 1) return 0;
	        final int N = s.length();
	        int res = 0;
	        Deque<Integer> stack = new ArrayDeque<>();
	        stack.push(-1);  // to start valid index is -1
	        for (int i = 0; i < N; i++) {
	            if (s.charAt(i) == '(') {
	                stack.push(i);
	            } else {  // s.charAt(i) == ')'
	                stack.pop();
	                if (stack.isEmpty()) stack.push(i);
	                int len = i - stack.peek();
	                res = Math.max(res, len);
	            }
	        }
	        return res;
	    }
	}
	
	
	// DP Solution
	// If s[i] is right parenthesis, check whether the s[i-1] is left parenthesis.
	// If it is, dp[i] = dp[i-2]+2. 
	// Otherwise, check the j = i - dp[i-1]. If s[j] is left parenthesis, dp[i] = dp[i-1] + dp[j-2] + 2.
	// Time complexity: O(N)
	// Space complexity: O(N)
	private static class Solution2 {
	    public int longestValidParentheses(String s) {
	        if (s == null || s.length() <= 1) return 0;
	        final int N = s.length();
	        int res = 0;
	        int dp[] = new int[N];
	        for (int i = 1; i < N; i++) {
	            if (s.charAt(i) == ')') {
	                if (s.charAt(i-1) == '(') {
	                    dp[i] = i >= 2 ? dp[i-2] + 2 : 2;
	                } else {  // s.charAt(i-1) == ')'
	                    int j = i - dp[i-1];
	                    if (j >= 1 && s.charAt(j-1) == '(') {
	                        dp[i] = dp[i-1] + (j >= 2 ? dp[j-2] + 2 : 2);
	                    }
	                }
	                res = Math.max(res, dp[i]);
	            }
	        }
	        return res;
	    }
	}

}
