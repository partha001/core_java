package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/
 * https://www.youtube.com/watch?v=B1k_sxOSgv8
 * @author partha
 *
 */
public class EncodeDecodeStrings {

	public static void main(String[] args) {
		String[] arr = new String[] {"partha",""};
		String encodedString = new EncodeDecodeStrings.Solution1().encode(arr);
		String[] decodedArr = new EncodeDecodeStrings.Solution1().decode(encodedString);
		System.out.println("");
	}
	
	
	private static class Solution1 {
		
		public String encode(String[] arr) {
			if(arr==null) 	return null; //edge case1
			if(arr.length==0) 	return ""; //edge case2
			StringBuilder sb = new StringBuilder();
			for(String s: arr) {
				sb.append(s.length()).append("#").append(s);
			}
			return sb.toString();
		}
		
		public String[] decode(String s) {
			if(s==null) return null;
			if(s.equals("")) return new String[0];
			
			List<String> list = new ArrayList<String>();
			int i=0;
			while(i<s.length()) {
				String segment = s.substring(i, s.length());
				String segmentPrefix = segment.substring(0, segment.indexOf("#"));
				int length = Integer.parseInt(segmentPrefix);
				
				String word = segment.substring(s.indexOf("#")+1, segment.indexOf("#")+1+length);
				list.add(word);
				
				i = i + segmentPrefix.length() + 1 + length;
				
			}
			
			String[] result = new String[list.size()];
			for(int j=0;j<list.size();j++) {
				result[j] = list.get(j);
			}
			return result;
		}
	}

}
