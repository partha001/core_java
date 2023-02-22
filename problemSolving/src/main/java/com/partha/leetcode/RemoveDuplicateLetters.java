package com.partha.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-duplicate-letters
 * @author partha
 *
 */
public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * https://www.youtube.com/watch?v=j313ttNJjo0
	 * @author partha
	 *
	 */
	class Solution {
		public String removeDuplicateLetters(String s) {
			Stack<Character> stack = new Stack<>();
			int[] count = new int[26];
			char[] arr = s.toCharArray();
			for(char c : arr) {
				count[c-'a']++;
			}
			boolean[] visited = new boolean[26];
			for(int i=0;i<s.length();i++) {
				char c= s.charAt(i);
				int index = c - 'a';
				count[index]--;
				if(visited[index]) {
					continue;
				}
				while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0) {
					visited[stack.peek()-'a'] = false;
					stack.pop();
				}
				stack.push(c);
				visited[index] = true;
			}
			String sb = "";
			while(!stack.isEmpty()) {
				sb = stack.pop() + sb;
			}
			return sb;
		}
	}

}
