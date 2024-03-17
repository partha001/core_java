package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * program tutorial: https://www.youtube.com/watch?v=cjWnW0hdF1Y
 *
 * @author biswaspa
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * /Time: O(n2) space: O(n)
     *
     * @author biswaspa
     */
    private static class Solution1 {

        public int lengthOfLIS(int[] nums) {

            int dp[] = new int[nums.length];
            Arrays.fill(dp, 1);

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < dp.length; i++)
                max = Math.max(max, dp[i]);

            return max;

        }
    }

    /**
     * same code as above written in more crisper way
     */
    private static class Solution2 {
        public int lengthOfLIS(int[] nums) {

            int dp[] = new int[nums.length];
            Arrays.fill(dp, 1);

            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        max = Math.max(max, dp[i]);
                    }
                }
            }
            return max;
        }
    }

}
