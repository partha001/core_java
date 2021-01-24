package com.partha.problemSolving.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "partha";
		//System.out.println(s.substring(0, s.length()-1));
		
		System.out.println(new Solution2().lengthOfLongestSubstring("pwwkew"));
	}
	
	/**
	 * timecomplexity = O(n^3)
	 * @author biswaspa
	 *
	 */
	static class Solution1{
		
		public int lengthOfLongestSubstring(String s) {
			if(s==null || s.length()==0)
				return 0;
			
			Set<Character> set = new HashSet<>();
	        int maxLength =0;
	        
	        for(int i=0;i<s.length();i++){
	            String current = "";
	            for(int j=i;j<s.length();j++){
	            	System.out.println(current);
	            	char currentChar = s.charAt(j);
	            	if(set.contains(currentChar)) {
	            		break;
	            	}
	            	
	            	set.add(currentChar);
	                current = current + currentChar; 
	                
	                if(maxLength<current.length())
	                	maxLength = current.length();
	                
	            }
	            set.clear();
	        }
	        
	        return maxLength;
	    }
	}
	
	
	/**
	 * timecomplexity = O(n^2)
	 * @author biswaspa
	 *
	 */
	static class Solution2{
		
		int maxLength =0;
		boolean found = false;
		
		public int lengthOfLongestSubstring(String s) {
			lengthOfLongestSubstring(s,"",0,new HashSet<Character>());
			return maxLength;
	    }
		
		
		public void lengthOfLongestSubstring(String s,String currentString,int start,HashSet<Character> set) {
			System.out.println(currentString);
			if(s==null || s.length()==0)
				return;
			
			if(currentString.length()>maxLength)
				maxLength = currentString.length();
			
			if(start<s.length()) {
				for(int i=start;i<s.length();i++) {
					if(found) {
						break;
					}
					
					char currentChar = s.charAt(i);
					if(set.contains(currentChar)) {
						found = true;
						return;
						//lengthOfLongestSubstring(s,currentString,i+1,visited);
					}else {
						found = false;
						set.add(currentChar);
						currentString = currentString + currentChar;
						lengthOfLongestSubstring(s,currentString,i+1,set);
						currentString = currentString.substring(0, currentString.length()-1);
						set.clear();
					}
				}
			}
		}
	}
	
	
	

}
