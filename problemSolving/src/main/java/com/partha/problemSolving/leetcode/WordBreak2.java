package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @source: https://leetcode.com/problems/word-break-ii/
 * @author partha
 *
 */
public class WordBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// backtacking  dfs recursive
	private static class Solution1 {
	    public List<String> wordBreak(String s, List<String> wordDict) {
	        List<String> sentences = new ArrayList();
	        makeWordBreaks(s, wordDict, sentences, "", 0);
	        return sentences;
	    }
	    
	    private static void makeWordBreaks(String s, List<String> wordDict, List<String> sentences, String current, int index) {
	        if (index >= s.length()) {
	            sentences.add(current.trim());
	            return;
	        }

	        for (int i = index; i < s.length(); ++i) {
	            if (wordDict.contains(s.substring(index, i+1))) {
	                makeWordBreaks(s, wordDict, sentences, current + s.substring(index, i+1) + " ", i+1);
	            }
	        }
	    }
	}
	
	
	//dfs with memoization
	private static class Solution2 {
	    List<String> res;
	    List<String> dict;
	    Set<String> mem;

	    public List<String> wordBreak(String s, List<String> wordDict) {
	        res = new ArrayList<>();
	        dict = wordDict;
	        mem = new HashSet<>();
	        rec(s, new StringBuilder());
	        return res;
	    }

	    private void rec(String s, StringBuilder current) {
	        if (mem.contains(s)) return;
	        if (s.length() == 0 && current.length() > 0) {
	            current.deleteCharAt(current.length() - 1);
	            res.add(current.toString());
	            return;
	        }

	        for (String w : dict) {
	            if (s.startsWith(w)) {
	                int oldLen = current.length();
	                current.append(w);
	                current.append(" ");
	                String next = s.substring(w.length(), s.length());
	                rec(next, current);
	                if (oldLen == current.length()) {
	                    mem.add(next);
	                    continue;
	                }
	                current.delete(oldLen, current.length());
	            }
	        }
	    }
	}

}
