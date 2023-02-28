package com.partha.leetcode;

/**
 * https://leetcode.com/problems/power-of-two
 * @author biswaspa
 *
 */
public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	class Solution1 {
	    public boolean isPowerOfTwo(int n) {
	        if(n<=0)
	        {
	            return false;
	        }
	        boolean ans= (n&(n-1))==0;
	        return ans;
	        
	    }
	}
	
	
	class Solution {
	    public boolean isPowerOfTwo(int n) {
	        if (n<1) return false;
	        if (n==1) return true;
	        if (n%2!=0) return false;
	        return isPowerOfTwo(n/2);
	    }
	}
	// if(n<=0) return false;
	        // while(n!=0){
	        //     if(n==1) return true;
	        //     if(n%2==0) n/=2;
	        //     else return false;
	        // }
	        // return true;

}
