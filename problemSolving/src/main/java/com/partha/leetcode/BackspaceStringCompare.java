package com.partha.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 * @author partha
 *
 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution1 {
	    public boolean backspaceCompare(String s, String t) {
	         Stack<Character> stack1= new Stack<>();
	         Stack<Character> stack2= new Stack<>();
	       

	         for(int i=0;i<s.length();i++){
	             if (s.charAt(i) != '#') {
	                stack1.push(s.charAt(i));
	            } else if (!stack1.isEmpty()) {
	                stack1.pop();
	            }
	         }

	         for(int i=0;i<t.length();i++){
	             if (t.charAt(i) != '#') {
	                stack2.push(t.charAt(i));
	            } else if (!stack2.isEmpty()) {
	                stack2.pop();
	            }
	         }
	           
	         
	          while(!stack1.isEmpty()&&!stack2.isEmpty()){
	              if(stack1.pop()!=stack2.pop()){
	                  return false;
	              }
	          }
	          if(stack1.isEmpty()&&stack2.isEmpty()){
	              return true;
	          }
	          return false;
	    }
	}
	
	
	private static class Solution2 {
	    public boolean backspaceCompare(String s, String t) {
	       return getString(s).equals(getString(t)); 
	    }
	    public String getString(String str) {
	        int n = str.length();
	        int count = 0;
	        String result = "";
	        for(int i = n - 1; i >= 0; i --) {
	            char ch = str.charAt(i);
	            if(ch == '#')
	            count ++;
	            else {
	            if(count > 0) 
	            count --;
	            else
	            result += ch;
	            }
	        }
	         return result;
	    }
	}

}
