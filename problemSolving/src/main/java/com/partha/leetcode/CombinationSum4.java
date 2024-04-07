package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * @author biswaspa
 */
public class CombinationSum4 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum4.Solution4().combinationSum4(new int[]{1, 2, 3}, 3));
    }

    /**
     * my solution. times out but logically correct
     **/
    static class Solution1 {
        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList();
            List<Integer> sublist = new ArrayList();
            combination(nums, target, result, sublist, 0, 0);
            return result.size();
        }


        public void combination(int[] nums,
                                int target,
                                List<List<Integer>> result,
                                List<Integer> sublist,
                                int sum,
                                int start) {
            if (sum == target) {
                result.add(new ArrayList(sublist));
                return;
            }
            if (sum > target) {
                return;
            }
            if (sum < target) {
                for (int i = start; i < nums.length; i++) {
                    sublist.add(nums[i]);
                    combination(nums, target, result, sublist, sum + nums[i], start);
                    sublist.remove(sublist.size() - 1);
                }

            }
        }
    }


    /**
     * abhishek's solution with recursion . logically correct but times out
     **/
    static class Solution2 {
        int count = 0;

        public int combinationSum4(int[] nums, int target) {
            backtrack(nums, target); // recusrive call
            return count;
        }

        private void backtrack(int[] nums, int target) {
            if (target < 0) {  // case 1
                return;
            }

            if (target == 0) { // case 2 when target == 0
                count++;
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                backtrack(nums, target - nums[i]);
            }
        }

    }


    //Memoziation + Dynamic programming
    // Time: O(n)
    // COIN CHANGE
    private static class Solution3 {

        public int combinationSum4(int[] nums, int target) {
            int len = nums.length;
            if (len == 0)  // case 1
                return 0;

            int dp[] = new int[target + 1];
            Arrays.fill(dp, -1);
            return backtrack(nums, target, dp);

        }

        private int backtrack(int[] nums, int target, int[] dp) {
            if (target < 0) //baseCase1: if target is zero then it cant be achieved if there are all positive values
                return 0;

            if (target == 0) //baseCase2: there is one way we can get 0 that i.e. by not picking anything
                return 1;

            if (dp[target] != -1) //baseCase3: if the value for target has already been pre-calculated
                return dp[target];

            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res = res + backtrack(nums, target - nums[i], dp);
            }

            dp[target] = res;
            return dp[target];
        }
    }


    /**
     * same code as above written in a different way.
     * makes use of memoisation. coin-change.
     * TC: O(n) i.e. linear time complexity
     */
    private static class Solution4 {
        public int combinationSum4(int[] nums, int target) {

            int []dp = new int[target+1];  //taking size target+1 since value of target can also be zero
            dp[0]=1; //there is only 1 way 0 target can be achieved i.e. by not picking any element

            for(int comb=1;comb<=target;comb++) {
                for(int num : nums) {
                    if(comb-num>=0) {
                        dp[comb] += dp[comb-num];
                    }
                }
            }
            return dp[target];
        }
    }


}
