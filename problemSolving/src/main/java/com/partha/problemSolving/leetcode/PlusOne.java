package com.partha.problemSolving.leetcode;

/**
 * link : https://leetcode.com/problems/plus-one/submissions/
 * @author biswaspa
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		new Solution1().plusOne(new int[] {9,8,7,6,5,4,3,2,1,0});

	}
	


	/**
	 * works fine logically but has problems whic
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
		public int[] plusOne(int[] digits) {
			int l = digits.length - 1;

			for (int i = l; i >= 0; i--) {
			
				if (digits[i] != 9){
					digits[i]++;
					return digits;
				} else {
					digits[i] = 0;
					
					if (i == 0) {
						digits = new int[l + 2];
						digits[i] = 1;
					}
				}                
			}
			return digits;
		}
	}
		
	
}
