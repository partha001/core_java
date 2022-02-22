package com.partha.problemSolving.leetcode;

/**
 * 
 * @author biswaspa
 *
 */
public class PalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * naive approach
	 * @author biswaspa
	 *
	 */
	class Solution {
		public int countSubstrings(String s) {
			int count=0;
			for(int i=0;i<=s.length()-1;i++) {
				count+=odd(s,i)+even(s,i);
			}
			return count;
		}
		int even(String s,int idx) {
			int ret=0;
			int i=idx;
			int j=idx+1;
			while(i>=0 && j<s.length()) {
				if(s.charAt(i)==s.charAt(j))
					ret++;
				else
					break;
				i--;
				j++;
			}
			return ret;
		}

		int odd(String s,int idx) {
			int ret=1;
			int i=idx-1;
			int j=idx+1;
			while(i>=0 && j<s.length()) {
				if(s.charAt(i)==s.charAt(j))
					ret++;
				else
					break;
				i--;
				j++;
			}
			return ret;
		}
	}




	//using dp
	private static class Solution2 {
		public int countSubstrings(String s) {
			int count=0;

			//First of all we create a 2-D boolean DP array and fill true on all the pallindromic substrings.

			//This array is filled using "Gap Strategy" or diagonal traversal.
			boolean[][] dp1 = new boolean[s.length()][s.length()];
			for (int g = 0; g < dp1.length; g++) {
				for (int i = 0, j = g; j < dp1.length; i++, j++) {

					if (g==0) {
						dp1[i][j] = true;
						count++;
					}

					else if (g == 1) {
						if (s.charAt(i) == s.charAt(j)) {
							dp1[i][j] = true;
							count++;
						}
					}

					else {
						if (s.charAt(i) == s.charAt(j)) {
							if (dp1[i + 1][j - 1] == true) {
								dp1[i][j] = true;
								count++;
							}
						}
						else {
							dp1[i][j] = false;

						}
					}

				}
			}
			return count;

		}


	}
}
