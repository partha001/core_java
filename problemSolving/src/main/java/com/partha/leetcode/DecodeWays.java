package com.partha.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @source : https://leetcode.com/problems/decode-ways/
 * @author partha
 *
 */
public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/*
    recursive approach(s)
        if s is empty, return 1
        counts  = recurse using 1 char +
                  recurse using 2 chars     << check if it is possible to recurse using 2 chars - also validate that value is < 27
    --
    improve time complexity using dp top/down memoization
    dp cache is a hash map of key string and value integer containing the counts for a given string
	 */
	private static class Solution1 {

		public int numDecodings(String s) {
			return decodeWays(s, new HashMap<>());
		}

		private int decodeWays(String s, Map<String, Integer> dp){
			if(s.isEmpty()){
				return 1;
			}

			if(s.startsWith("0")){
				return 0;
			}

			if(dp.containsKey(s)){
				return dp.get(s);
			}

			int counts = decodeWays(s.substring(1), dp);
			if(s.length() > 1){
				int twoDigits = Integer.parseInt(s.substring(0,2));
				if(twoDigits < 27) {
					counts += decodeWays(s.substring(2), dp);
				}
			}

			dp.put(s, counts);

			return dp.get(s);
		}
	}

}
