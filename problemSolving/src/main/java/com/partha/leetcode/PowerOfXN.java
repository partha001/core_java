package com.partha.leetcode;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class PowerOfXN {

    public static void main(String[] args){

    }

    /**
     * this method calculates the value recursively
     * doing some calculation at each step. and then we
     * have the the values defined for base cases
     */
    private static class Solution {
        public double myPow(double x, int n) {
            if (n==0) return 1; //case1: value to be returned when n=0
            else if (n%2==0) return myPow(x*x, n/2); //value to be returned when n is an even number
            else if (n%2==1) return x*myPow(x, n-1); //value to be returned when n is  odd.
            return 1/myPow(x, -n); //value to be returned when n is negative;
        }
    }
}
