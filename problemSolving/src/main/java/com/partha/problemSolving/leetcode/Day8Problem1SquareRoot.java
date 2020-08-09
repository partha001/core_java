package com.partha.problemSolving.leetcode;

/**
 * link : https://leetcode.com/problems/sqrtx/
 * @author biswaspa
 *
 */
public class Day8Problem1SquareRoot {

	public static void main(String[] args) {
		System.out.println(new Solution2().mySqrt(24));
	}
	
	
	/**
	 * O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
		
		public int mySqrt(int x) {
			int i=1;
			while(i*i<=x) {
				if(i*i==x) {
					return i;
				}else {
					i++;
				}
			}
			return i-1;
		}
	}
	
	
	
	/**
	 * O(logN)
	 */
	static class Solution2{
		
		public int mySqrt(int x) {
			int l = 1;
	        int r = x;
	        long mid;
	        
	        while( l <= r){
	            mid = ((long)l+(long)r)/2;
	            
	            if( mid * mid == x) return (int)mid;
	            else if ( mid* mid > x)
	                r = (int)mid-1;
	            else
	                l = (int)mid+1;
	        }
	        return r;
		}
		
	}
}
