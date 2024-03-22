package com.partha.leetcode;

/**
 * https://leetcode.com/problems/power-of-two
 *
 * @author biswaspa
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


	private static class Solution1 {
		public boolean isPowerOfTwo(int n) {
			if (n <= 0)
				return false;
			return (n & (n - 1)) == 0;
		}
	}


    private static class Solution2 {
        public boolean isPowerOfTwo(int n) {
            if (n < 1) return false;
            if (n == 1) return true;
            if (n % 2 != 0) return false;
			return isPowerOfTwo(n / 2);
        }
    }

}
