package com.partha.leetcode;

/**
 * https://leetcode.com/problems/power-of-three/
 * @author partha
 *
 */
public class PwerOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	private static  class Solution {
		    public boolean isPowerOfThree(int n) {
		        if (n<=0) return false;
		        while(n!=1){
		            if(n%3 != 0) {
		                return false;
		            }
		            n = n / 3;
		            //System.out.println(n);
		        }
		        return true;
		    }
		}

}
