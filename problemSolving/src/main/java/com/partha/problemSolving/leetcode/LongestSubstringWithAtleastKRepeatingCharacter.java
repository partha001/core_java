package com.partha.problemSolving.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * @author partha
 *
 */
public class LongestSubstringWithAtleastKRepeatingCharacter {

	public static void main(String[] args) {

	}


	private static class Solution1 {
		
		public int longestSubstring(String s, int k) {
			int n = s.length();
			if(n==0 || n<k) return 0; //base case1
			if(k==1) return n; //base case2
			
			Map<Character,Integer> map = new HashMap<>(); //hold the occurance
			for(char c:s.toCharArray()) 
				map.put(c, map.getOrDefault(c, 0)+1);
			
			int i=0;
			while(i<n && map.get(s.charAt(i))>=k) 
				i++;
			
			if(i>=n-1) 
				return i;
			
			int left = longestSubstring(s.substring(0, i), k);
			while(i<n && map.get(s.charAt(i))<k)
				i++;
			
			int right = (i<n) ? longestSubstring(s.substring(i), k):0;
			return Math.max(left, right);
			
		}
	}

}
