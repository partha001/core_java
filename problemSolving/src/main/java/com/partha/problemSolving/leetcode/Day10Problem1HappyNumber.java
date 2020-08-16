package com.partha.problemSolving.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * link : https://leetcode.com/problems/happy-number
 * @author biswaspa
 *
 */
public class Day10Problem1HappyNumber {

	public static void main(String[] args) {
		System.out.println(new Solution1().isHappy(2));

	}

	/**
	 * brute force : timecomplexity  O(nxn)
	 * spacecomplexity : O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
	    public boolean isHappy(int n) {
				boolean result = false;

				Set<Integer> results = new HashSet<>();
				while(n>0) { 

					int x=n;
					int sum=0;
					while(x>0) {
						sum = sum + (x%10)*(x%10) ;
						x = x/10;
					}
					
					if(sum==1) {
						return true;
					}else {
	                    if(!results.add(sum)){
	                        return false;
	                    }else{
	                        n=sum;
	                    }
					}
				}

				return result ;		
	    }
	}

}
