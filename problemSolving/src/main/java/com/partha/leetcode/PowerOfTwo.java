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


    /**
     * solution using bitwise operator
     */
    private static class Solution1 {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0)
                return false;
            return (n & (n - 1)) == 0; //using bitwise and operation to check.
        }
    }


    /**
     * iterative division solution
     */
    private  static class Solution2 {
        public boolean isPowerOfTwo(int n) {
            if(n<=0)
                return false;
            while(n!=1){
                if(n%2!=0)
                    return false;
                n = n/2;
            }
            return true;
        }
    }


    /**
     * recursive division solution
     */
    private static class Solution3 {

        /**
         * recursively dividing by 2 till a value less than 2 is
         * reached while checking the modular division !=0 at any given point of time.
         *
         * @param n
         * @return
         */
        public boolean isPowerOfTwo(int n) {
            if (n < 1) return false; // base
            if (n == 1) return true;
            if (n % 2 != 0) return false;
            return isPowerOfTwo(n / 2);
        }
    }

}
