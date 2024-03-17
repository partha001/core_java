package com.partha.leetcode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


    private static class Solution1 {
        public int findDuplicate(int[] nums) {
            int slow = nums[nums[0]];
            int fast = nums[nums[nums[0]]];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            slow = nums[0];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }

    /**
     * previous algo written in a different way
     **/
    private static class Solution2 {
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[0];

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            while (slow != fast);

            slow = nums[0];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return fast;
        }
    }

}
