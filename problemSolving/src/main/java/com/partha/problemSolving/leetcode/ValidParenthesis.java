package com.partha.problemSolving.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author biswaspa
 *
 */
public class ValidParenthesis {

	public static void main(String[] args) {
		System.out.println(new Solution().isValid("()"));
	}

	static class Solution {

		public boolean isValid(String s) {
			if(s==null ||  s.length()==1) {
				return false;
			}else if(s.length()==0){
				return true;
			}else {
				Stack<String> stack = new Stack<>();
				for(int i=0;i<s.length();i++) {
					String currentChar = ""+s.charAt(i);
					if(!stack.isEmpty()) {
						String itemOnTop = stack.peek();

						if((currentChar.equals(")") && itemOnTop.equals("("))
								|| (currentChar.equals("]") && itemOnTop.equals("["))
								|| (currentChar.equals("}") && itemOnTop.equals("{"))
								) {
							stack.pop();
						}else {
							stack.push(currentChar);
						}
					}else {
						stack.push(currentChar);
					}
				}
				if(stack.isEmpty()) {
					return true;
				}else {
					return false;
				}
			}
		}
	}

}
