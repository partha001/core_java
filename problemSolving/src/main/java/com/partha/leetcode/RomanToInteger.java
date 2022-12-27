package com.partha.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author biswaspa
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(new Solution().romanToInt("MCMXCIV"));
	}
	
	static class Solution {

		HashMap<String, Integer> map;

		Solution(){
			super();
			map = new HashMap<>();
			map.put("I", 1);
			map.put("V",5);
			map.put("X",10);
			map.put("L",50);

			map.put("C",100);
			map.put("D",500);
			map.put("M",1000);

		}


		public int romanToInt(String s) {


			int result = 0;
			if(s==null || s.length()==0) {
				result = 0;
			}else {
				char[] arr = s.toCharArray();
				int previousValue = 0;
				for(int i=arr.length-1;i>=0;i--) {
					int currentValue = map.get(""+arr[i]).intValue();
					if(i==arr.length-1)
					{
						result = currentValue ;
						previousValue = currentValue;
					}else {
						if(currentValue>=previousValue) {
							result = result + currentValue;
							previousValue = currentValue;
						}else {
							result = result - currentValue;
							previousValue = currentValue;
						}
					}
				}
			}
			return result;
		}


	}



}


