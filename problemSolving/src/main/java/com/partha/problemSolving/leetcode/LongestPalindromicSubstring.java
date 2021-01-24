package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author biswaspa
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(new Solution2().longestPalindrome("abbc"));
	}


	//brute force approach .
	//timecomplexity : O(n^3)
	//spaceComplexity : O(1)
	static class Solution1 {
		public String longestPalindrome(String s) {
			if(s==null)
				return null;
			if(s.length()==0)
				return "";
			String result="";
			for(int i=0;i<s.length();i++) {
				String currentString="";
				for(int j=i;j<s.length();j++) {
					boolean isPalindrome = true;
					currentString = currentString + s.charAt(j);

					for(int m=0;m<=currentString.length()/2;m++) {
						if(currentString.charAt(m)!=currentString.charAt(currentString.length()-1-m)) {
							isPalindrome = false;
							break;
						}
					}

					if(isPalindrome && result.length()<currentString.length()){
						result = currentString;
					}
				}
			}

			return result;
		}
	}


	//using dp
	//time complexity O(n^2)
	//space complexity O(n^2)
	static class Solution2{

		public String longestPalindrome(String s) {
			if(s==null)
				return null;
			if(s.length()==0)
				return "";
			//String result="";
			int maxLength = 1;
			int start = 0;
			
			int length= s.length();
			boolean[][] lps = new boolean[length][length];
			
			//populating the diagonal in the matrix
			for(int i=0;i<length;i++) {
				lps[i][i] = true;
			}
			
			
			//populating the diagonal where length=2
			for(int i=0;i<length-1;i++) {
				if(s.charAt(i)==s.charAt(i+1)) {
					lps[i][i+1] = true;
					maxLength = 2;
					start = i;
				}
			}
			
			
			//populating for substring where length>=3
			for(int i=2;i<length;i++) {
				for(int j=0;j<length-i;j++) {
					int row = j;
					int column=i+j;
					
					if(s.charAt(row)==s.charAt(column) && lps[row+1][column-1]) {
						lps[row][column] = true;
						
						if(maxLength<column - row +1) {
							maxLength = column - row +1;
							start = row;
						}
						
					}
					
				}
			}		
			return s.substring(start,start + maxLength);
		}
	}

}
