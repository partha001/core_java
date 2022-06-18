package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//using backtracking
	private static class Solution {
	    public List<List<String>> partition(String s) {
	        List<List<String>> ans = new ArrayList<>();
			partition(s, 0, ans, new ArrayList<>());
			return ans;
		}

		private void partition(String s, int i, List<List<String>> ans, List<String> list) {
			if (i == s.length()) {
				ans.add(new ArrayList<>(list));
				return;
			}
			for (int j = i; j < s.length(); j++) {
				if (isPalindrome(s, i, j)) {
					list.add(s.substring(i, j + 1));
					partition(s, j + 1, ans, list);
					list.remove(list.size() - 1);
				}
			}
		}

		private boolean isPalindrome(String s, int l, int r) {
			while (l < r) {
				if (s.charAt(l) != s.charAt(r)) {
					return false;
				}
				l++;
				r--;
			}
			return true;
		}
	}
	
	
	//backtracking + dp
	private static class Solution2 {
	    
	    public void backtrack (String s, int start, int length, boolean[][] dp, List<String> list, List<List<String>> answer) {
	        
	        if (start == length) {
	            answer.add (new ArrayList<> (list));
	        }
	        
	        for (int end = start; end < length; end++) {
	            if (dp[start][end]) {
	                list.add (s.substring (start, end + 1));
	                backtrack (s, end + 1, length, dp, list, answer);
	                list.remove (list.size () - 1);
	            }
	        }
	    }
	    
	    public List<List<String>> partition(String s) {
	        
	        int length = s.length ();
	        boolean[][] dp = new boolean[length][length];
	        List<List<String>> answer = new ArrayList<> ();
	        
	        if (s == null || length == 0) {
	            return answer;
	        }
	        
	        for (int end = 0; end < length; end++) {
	            for (int start = 0; start <= end; start++) {
	                if (s.charAt (start) == s.charAt (end)) {
	                    if (start == end) {
	                        dp[start][end] = true;
	                    }
	                    else if (end - start == 1) {
	                        dp[start][end] = true;
	                    }
	                    else if (dp[start + 1][end - 1]) {
	                        dp[start][end] = true;
	                    }
	                }
	            }
	        }
	        
	        backtrack (s, 0, length, dp, new ArrayList<> (), answer);
	        return answer;
	    }
	}
	
	
	//dp
	private static class Solution3 {
		
		public List<List<String>> partition(String s) {
			final int n = s.length();
			List<List<String>>[] dp = new List[n + 1];
			Arrays.setAll(dp, (i)->new ArrayList<List<String>>());
			dp[n].add(new ArrayList<String>());
			
			// Candidate substring is [begin, end), includes begin, excludes end
			for (int begin = n - 1; begin >= 0; begin--) {
				for (int end = begin + 1; end <=n; end++) {
					String candidate = s.substring(begin, end);
					
					// Reverse and equal is palindrome. 
					if(candidate.equals(new StringBuffer(candidate).reverse().toString())) {
						for (List<String> each : dp[end]) {
							ArrayList<String> newEach = new ArrayList<String>();
							newEach.add(candidate);
							newEach.addAll(each);
							dp[begin].add(newEach);
						}
					}
				}
			}
			return dp[0];      
		}
	}

}
