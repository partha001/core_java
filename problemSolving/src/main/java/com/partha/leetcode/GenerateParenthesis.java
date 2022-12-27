package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/solution/
 * @author biswaspa
 *
 */
public class GenerateParenthesis {

	public static void main(String[] args) {
		List<String> generateParenthesis = new Solution2().generateParenthesis(3);
		System.out.println();
	}
	
	//brute force approach
	static class Solution1 {
	    public List<String> generateParenthesis(int n) {
	        List<String> combinations = new ArrayList();
	        generateAll(new char[2 * n], 0, combinations);
	        return combinations;
	    }

	    public void generateAll(char[] current, int pos, List<String> result) {
	    	System.out.println(current);
	    	System.out.println(pos);
	    	System.out.println( " ");
	        if (pos == current.length) {
	            if (valid(current))
	                result.add(new String(current));
	        } else {
	            current[pos] = '(';
	            generateAll(current, pos+1, result);
	            System.out.println("backtracking");
	            current[pos] = ')';
	            generateAll(current, pos+1, result);
	            System.out.println("backtracking");
	        }
	    }

	    public boolean valid(char[] current) {
	        int balance = 0;
	        for (char c: current) {
	            if (c == '(') balance++;
	            else balance--;
	            if (balance < 0) return false;
	        }
	        return (balance == 0);
	    }
	}
	
	//backtracking approach n^n	
	static class Solution2 {
	    public void generate(int low, int high, String str, List<String>list){
	       System.out.println(str);
	    	if(low == 0 && high == 0){
	            list.add(str);
	            return;
	        }
	        if(low>0){
	            generate(low-1, high,str+'(', list);
	        }
	        if(high>low){ // here is the catch i.e its not high>0 , rather its high > low 
	            generate(low, high-1, str+')', list);
	        }
	    }
	    
	    public List<String> generateParenthesis(int n) {
	    	List<String> list = new ArrayList<>();
	    	String temp  = "";
	    	generate(n, n, temp, list);
	    	return list;
	    }
	    
	}
	
	

//	static class Solution2 {
//	    public List<String> generateParenthesis(int n) {
//	        List<String> ans = new ArrayList();
//	        backtrack(ans, "", 0, 0, n);
//	        return ans;
//	    }
//
//	    public void backtrack(List<String> ans, String cur, int open, int close, int max){
//	        if (cur.length() == max * 2) {
//	            ans.add(cur);
//	            return;
//	        }
//
//	        if (open < max)
//	            backtrack(ans, cur+"(", open+1, close, max);
//	        if (close < open)
//	            backtrack(ans, cur+")", open, close+1, max);
//	    }
//	}
	
	

	
	
//	static class Solution3 {
//	    public List<String> generateParenthesis(int n) {
//	        List<String> ans = new ArrayList();
//	        if (n == 0) {
//	            ans.add("");
//	        } else {
//	            for (int c = 0; c < n; ++c)
//	                for (String left: generateParenthesis(c))
//	                    for (String right: generateParenthesis(n-1-c))
//	                        ans.add("(" + left + ")" + right);
//	        }
//	        return ans;
//	    }
//	}

}
