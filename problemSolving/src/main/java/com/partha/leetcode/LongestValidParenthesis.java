package com.partha.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
	
	
	
	/**************************************** leetcode official solutions start here **************************************/
	
	/**
	 * @approach :brute force
	 * @source leetcode official solutions
	 * @TC O(N^3)
	 * @SC O(n)
	 * @author biswaspa
	 *
	 */
	private static  class LeetCodeOfficialSolution1 {
	    public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<Character>();
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                stack.push('(');
	            } else if (!stack.empty() && stack.peek() == '(') {
	                stack.pop();
	            } else {
	                return false;
	            }
	        }
	        return stack.empty();
	    }
	    public int longestValidParentheses(String s) {
	        int maxlen = 0;
	        for (int i = 0; i < s.length(); i++) {
	            for (int j = i + 2; j <= s.length(); j+=2) {
	                if (isValid(s.substring(i, j))) {
	                    maxlen = Math.max(maxlen, j - i);
	                }
	            }
	        }
	        return maxlen;
	    }
	}
	
	
	/**
	 * @approach : dynamic programming approach
	 * @source leetcode official solutions
	 * @TC O(n)
	 * @SC O(n)
	 * @author biswaspa
	 *
	 */
	private static  class LeetCodeOfficialSolution2 {
	    public int longestValidParentheses(String s) {
	        int maxans = 0;
	        int dp[] = new int[s.length()];
	        for (int i = 1; i < s.length(); i++) {
	            if (s.charAt(i) == ')') {
	                if (s.charAt(i - 1) == '(') {
	                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
	                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
	                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
	                }
	                maxans = Math.max(maxans, dp[i]);
	            }
	        }
	        return maxans;
	    }
	}
	
	/**
	 * @approach : using stack
	 * @source leetcode official solutions
	 * @TC O(n)
	 * @SC O(n)
	 * @author biswaspa
	 *
	 */
	private static class LeetCodeOfficialSolution3 {

	    public int longestValidParentheses(String s) {
	        int maxans = 0;
	        Stack<Integer> stack = new Stack<>();
	        stack.push(-1);
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                stack.push(i);
	            } else {
	                stack.pop();
	                if (stack.empty()) {
	                    stack.push(i);
	                } else {
	                    maxans = Math.max(maxans, i - stack.peek());
	                }
	            }
	        }
	        return maxans;
	    }
	}
	
	/**
	 * @approach :without using any extra space.
	 * @source leetcode official solutions
	 * @TC O(n)
	 * @SC O(1)
	 * @author biswaspa
	 *
	 */	
	private static  class LeetCodeOfficialSolution4 {
	    public int longestValidParentheses(String s) {
	        int left = 0, right = 0, maxlength = 0;
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                left++;
	            } else {
	                right++;
	            }
	            if (left == right) {
	                maxlength = Math.max(maxlength, 2 * right);
	            } else if (right >= left) {
	                left = right = 0;
	            }
	        }
	        left = right = 0;
	        for (int i = s.length() - 1; i >= 0; i--) {
	            if (s.charAt(i) == '(') {
	                left++;
	            } else {
	                right++;
	            }
	            if (left == right) {
	                maxlength = Math.max(maxlength, 2 * left);
	            } else if (left >= right) {
	                left = right = 0;
	            }
	        }
	        return maxlength;
	    }
	}
	
	
	/**************************************** leetcode official solutions start here **************************************/

}
