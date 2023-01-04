package com.partha.leetcode;

/**
 *	https://leetcode.com/problems/palindromic-substrings 
 * @author biswaspa
 *
 */
public class PalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	/**
	 * https://youtu.be/4RACzI5-du8
	 * this is same as LeetcodeSolution3 just that the code is much more condensed.
	 * @author partha
	 * TC N^2
	 * SC O(1)
	 */
	class Solution1 {

		public int countSubstrings(String s) {
			int count=0;
			for(int i=0;i<s.length();i++) {
				count+= countPalindrome(s,i,i); //odd length palindromes around current index
				count+= countPalindrome(s,i,i+1); //even even length palindromes around current index
			}
			return count;
		}

		private int countPalindrome(String s, int start, int end){
			int result =0;
			while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
				result++;
				start--;
				end++;
			}
			return result;
		}

	}
	
	/**
	 * dp my code
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    public int countSubstrings(String s) {
	        
	        int n=s.length();
	        
	        boolean [][]dp=new boolean[n][n];
	        int count=0;
	        
	        for(int g=0;g<n;g++){
	            for(int i=0,j=g;j<n;i++,j++){
	                if(g==0){
	                    dp[i][j]=true;
	                }else if(g==1){
	                    dp[i][j]=s.charAt(i)==s.charAt(j);
	                }else{
	                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
	                        dp[i][j]=true;
	                    }else{
	                        dp[i][j]=false;
	                    }
	                }
	                
	                if(dp[i][j]){
	                    count++;
	                }
	            }
	        }
	        
	        return count;
	    }
	}


	/***************************** leedcode official solutions ***********************/

	/**
	 * approach: naive approach
	 * source : leetcode premium
	 * tc :O(n^3)
	 * SC O(1)
	 * @author partha
	 *
	 */
	private static class LeetcodeOfficialSolution1 {
		private boolean isPalindrome(String s, int start, int end) {
			while (start < end) {
				if (s.charAt(start) != s.charAt(end)) 
					return false;

				++start;
				--end;
			}

			return true;
		}

		public int countSubstrings(String s) {
			int ans = 0;

			for (int start = 0; start < s.length(); ++start)
				for (int end = start; end < s.length(); ++end) 
					ans += isPalindrome(s, start, end) ? 1 : 0;

			return ans;
		}
	}




	/**
	 * @approach dynamic programming approach
	 * @source leetcode premium
	 * TC N^2
	 * SC N^2
	 * @author partha
	 * @usefulLink https://www.youtube.com/watch?v=XmSOWnL6T_I
	 */
	private static class LeetcodeOfficialSolution2 {
		public int countSubstrings(String s) {
			int n = s.length(), ans = 0;

			if (n <= 0) 
				return 0;

			boolean[][] dp = new boolean[n][n];

			// Base case: single letter substrings //populating diagonal cells where start=end represnting single character
			for (int i = 0; i < n; ++i, ++ans) 
				dp[i][i] = true;

			// Base case: double letter substrings //populating diagonal to the right of center-diagonal representing 2 char strings
			for (int i = 0; i < n - 1; ++i) {
				dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
				ans += (dp[i][i + 1] ? 1 : 0);
			}

			// All other cases: substrings of length 3 to n
			for (int len = 3; len <= n; ++len)
				for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
					dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
					ans += (dp[i][j] ? 1 : 0);
				}

			return ans;
		}
	}


	/**
	 * @approach odd even approach around center
	 * @source leetcode premium
	 * TC N^2
	 * SC O(1)
	 */
	private static class LeetcodeSolution3 {
		public int countSubstrings(String s) {
			int ans = 0;

			for (int i = 0; i < s.length(); ++i) {
				// odd-length palindromes, single character center
				ans += countPalindromesAroundCenter(s, i, i);

				// even-length palindromes, consecutive characters center
				ans += countPalindromesAroundCenter(s, i, i + 1);
			}

			return ans;
		}

		private int countPalindromesAroundCenter(String ss, int lo, int hi) {
			int ans = 0;

			while (lo >= 0 && hi < ss.length()) {
				if (ss.charAt(lo) != ss.charAt(hi))
					break;      // the first and last characters don't match!

				// expand around the center
				lo--;
				hi++;

				ans++;
			}

			return ans;
		}
	}

}
