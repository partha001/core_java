package com.partha.leetcode;

/**
 * https://leetcode.com/problems/rotated-digits
 * @author partha
 *
 */
public class RotatedDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * TC O(N)
	 * SC O(1)
	 * @author partha
	 *
	 */
	private static class Solution1 {
		  public int rotatedDigits(int n) {
		    int res = 0;
		    for (int i = 1; i <= n; i++) {
		      int num = i;
		      boolean invalid = false;
		      boolean hasNotMirrored = false;
		      while (num != 0) {
		        int k = num % 10;
		        if (k == 3 || k == 4 || k == 7) {
		          invalid = true;
		          break;
		        }
		        if (k == 6|| k == 9 || k == 2 || k == 5) {
		          hasNotMirrored = true;
		        }
		        num /= 10;
		      }
		      if (invalid) {
		        continue;
		      }
		      if (hasNotMirrored) {
		        res++;
		      }
		    }
		    return res;
		  } 
		}

}
