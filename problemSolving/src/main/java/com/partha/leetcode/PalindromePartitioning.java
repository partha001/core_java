package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * @author partha
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new PalindromePartitioning.Solution2().partition("aab"));

    }


    //using backtracking
    private static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<List<String>>();
            dfs(0, result, new ArrayList<String>(), s);
            return result;
        }

        void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
            //ie. when the full length of string is covered then adding whatever is there in currentList to result
            if (start >= s.length()) {
                result.add(new ArrayList<String>(currentList));
                return;
            }


            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    // add current substring in the currentList
                    currentList.add(s.substring(start, end + 1));
                    dfs(end + 1, result, currentList, s);
                    // backtrack and remove the current substring from currentList
                    currentList.remove(currentList.size() - 1);
                }
            }
        }

        boolean isPalindrome(String s, int low, int high) {
            while (low < high) {
                if (s.charAt(low++) != s.charAt(high--)) return false;
            }
            return true;
        }
    }

    /**
     * backtracking + dp
     * https://www.youtube.com/watch?v=3jvWodd7ht0
     *
     * @author biswa
     */
    //backtracking + dp
    private static class Solution2 {
        public List<List<String>> partition(String s) {
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            List<List<String>> result = new ArrayList<>();
            dfs(result, s, 0, new ArrayList<>(), dp);
            return result;
        }

        void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
            if (start >= s.length())
                result.add(new ArrayList<>(currentList));
            for (int end = start; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) { //condition for palindrome
                    dp[start][end] = true;
                    currentList.add(s.substring(start, end + 1));
                    dfs(result, s, end + 1, currentList, dp);
                    currentList.remove(currentList.size() - 1);
                }
            }
        }
    }


}
