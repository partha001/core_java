package com.partha.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 * @author partha
 *
 */
public class LongestAbsoluteFilePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Solution1 {
		public int lengthLongestPath(String input) {
			Stack<Integer> stack = new Stack<>();
			stack.push(0); // "dummy" length
			int maxLen = 0;
			for(String s:input.split("\n")){
				int lev = s.lastIndexOf("\t")+1; // number of "\t"
				while(lev+1<stack.size()) stack.pop(); // find parent
				int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
				stack.push(len);
				// check if it is file
				if(s.contains(".")) maxLen = Math.max(maxLen, len-1); 
			}
			return maxLen;
		}
	}


	private static class Solution2{
		public int lengthLongestPath(String input) {
			String[] paths = input.split("\n");
			int[] stack = new int[paths.length+1];
			int maxLen = 0;
			for(String s:paths){
				int lev = s.lastIndexOf("\t")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;
				if(s.contains(".")) maxLen = Math.max(maxLen, curLen-1);
			}
			return maxLen;
		}
	}

}
