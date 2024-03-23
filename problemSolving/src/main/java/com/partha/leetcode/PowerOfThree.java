package com.partha.leetcode;

/**
 * https://leetcode.com/problems/power-of-three/
 *
 * @author partha
 */
public class PowerOfThree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    /**
     * iterative division solution
     */
    private static class Solution1 {
        public boolean isPowerOfThree(int n) {
            if (n <= 0)
				return false;
            while (n != 1) {
                if (n % 3 != 0) {
                    return false;
                }
                n = n / 3;
            }
            return true;
        }
    }


	/**
	 * recursive solution
	 */
	private static class Solution2 {

		public boolean isPowerOfThree(int n) {
			if (n<=0)
				return false;
			if(n==1)
				return true;
			if(n%3!=0)
				return false;
			return isPowerOfThree(n/3);
		}

	}

}
