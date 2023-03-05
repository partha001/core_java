package com.partha.leetcode;

/**
 * https://leetcode.com/problems/integer-replacement
 * @author partha
 *
 */
public class IntegerReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * logic: Eg. 23 can become 22 or 24. Check by dividing 22 / 2 results in odd, if yes take the right path(n+1).
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    public int integerReplacement(int n1) {
	        int steps = 0;
	        long n = (long) n1;
	        while (n != 1) {
	            if(n % 2 == 0) {
	                n = n / 2;
	            } else {
	                long left = (n - 1) / 2;
	                if(left == 1 || left % 2 == 0) {
	                    n = n - 1;
	                } else {
	                    n = n + 1;
	                }
	            }
	            steps++;
	        }
	        
	        return steps;
	    }
	}
	
	
	
	/**
	 * 
	 * @author partha
	 *
	 */
	class Solution {
	    public int integerReplacement(int n) {
	        int ans = 0;
	        while (n != 1) {
	            if ((n & 1) == 0) {
	                n >>>= 1;
	            } else if (n != 3 && (n & 3) == 3) {
	                ++n;
	            } else {
	                --n;
	            }
	            ++ans;
	        }
	        return ans;
	    }
	}

}
