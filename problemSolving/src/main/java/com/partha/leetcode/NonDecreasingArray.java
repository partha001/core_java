package com.partha.leetcode;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 *
 * @author partha
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * TC O(n)
     * SC O(1)
     *
     * @author partha
     */
    private static class Solution {

        public boolean checkPossibility(int[] nums) {
            boolean modify = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] <= nums[i + 1])
                    continue;
                if (modify)
                    return false;
                modify = true;
                if (i == 0)
                    nums[i] = nums[i + 1];
                else {
                    if (nums[i - 1] <= nums[i + 1])
                        nums[i] = nums[i - 1];
                    else
                        nums[i + 1] = nums[i];
                }
            }
            return true;
        }
    }


    /**
     * TC O(n)
     * SC O(1)
     *
     * @author partha
     */
    private static class Solution2 {
        public boolean checkPossibility(int[] nums) {
            for (int i = 1, modified = 0; i < nums.length; i++) {
                if (nums[i - 1] > nums[i]) { //if violates increasing order
                    modified++;
                    if (modified == 2)    //if number of modification reaches threshold
                        return false;
                    if (i < 2 || nums[i - 2] <= nums[i]) //if its for first 2 element or i-2th element<=ith element
                        nums[i - 1] = nums[i];   //making the modification at i-1th index
                    else
                        nums[i] = nums[i - 1];   //making the modification at i-th index
                }
            }
            return true;
        }
    }

}
