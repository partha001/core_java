package com.partha.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/shortest-completing-word/
 * @author partha
 *
 */
public class ShortestCompletingWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public String shortestCompletingWord(String licensePlate, String[] words) {
	        HashMap<Character, Integer> map = new HashMap<>();
	        int count = 0;
	        for (char c : licensePlate.toCharArray()) {
	            if (Character.isLetter(c)) {
	                c = Character.toLowerCase(c);
	                map.put(c, map.getOrDefault(c, 0) + 1);
	                count++;
	            }
	        }
	        
	        String shortestWord = null;
	        for (String word : words) {
	            if (shortestWord != null && word.length() >= shortestWord.length()) {
	                continue; // skip words that are longer than the current shortest word
	            }
	            HashMap<Character, Integer> tempMap = new HashMap<>(map);
	            int tempCount = count;
	            for (char c : word.toCharArray()) {
	                c = Character.toLowerCase(c);
	                if (tempMap.containsKey(c)) {
	                    tempCount--;
	                    tempMap.put(c, tempMap.get(c) - 1);
	                    if (tempMap.get(c) == 0) {
	                        tempMap.remove(c);
	                    }
	                }
	            }
	            if (tempCount == 0 && (shortestWord == null || word.length() < shortestWord.length())) {
	                shortestWord = word;
	            }
	        }
	        return shortestWord;
	    }
	}

}
