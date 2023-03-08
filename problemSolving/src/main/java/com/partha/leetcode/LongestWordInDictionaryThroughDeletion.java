package com.partha.leetcode;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting
 * @author partha
 *
 */
public class LongestWordInDictionaryThroughDeletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * two pointer approach
	 * TC O(M*N)
	 * O(1)
	 * @author partha
	 *
	 */
	private static class Solution {
	    public String findLongestWord(String s, List<String> dictionary) {
	        int maxLen = 0;
	        String maxWord = "";
	        for (String word : dictionary) {
	            int len = explore(s, word);
	            if (len > maxLen || (len == maxLen && maxWord.compareTo(word) > 0)) {
	                maxLen = len;
	                maxWord = word;
	            }
	        }
	        return maxWord;
	    }

	    private int explore(String s, String word) {
	        for (int i = 0, j = 0; i < s.length(); i++) {
	            if (s.charAt(i) == word.charAt(j)) {
	                j++;
	                if (j == word.length()) return j;
	            }
	        }
	        return 0;
	    }
	}

}
