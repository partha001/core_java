package com.partha.leetcode;

/**
 * https://leetcode.com/problems/license-key-formatting
 * @author partha
 *
 */
public class LicenseKeyFormatting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * TC: O(N)
	 * SC: O(1)
	 * @author partha
	 *
	 */
	private static class Solution {
	    public String licenseKeyFormatting(String s, int k) {
	        StringBuilder str = new StringBuilder("");

	        // traverse the string from right side to left side
	        for (int i = s.length() - 1; i >= 0; i--) {
	            // initially count is 0, count is to maintain the k character
	            int j = i, count = 0;

	            while (j >= 0 && count < k) {
	                char ch = s.charAt(j);
	                // if character -, we dont need to consider
	                if(ch == '-') {
	                    j--;
	                    continue;
	                }
	                
	                // if lowercase convert to uppercase
	                if(ch >= 'a' && ch <= 'z') ch = (char) (ch - 32);

	                str.append(ch);
	                // increase the counter
	                count++;
	                j--;
	            }

	            // decrease the j pointer untill you find a character except '-'
	            while(j >= 0 && s.charAt(j) == '-') j--;

	            // if j pointer still within the range of the s, then append '-'
	            if(j >= 0) str.append("-");
	            i = j + 1;
	        }

	        // reverse the string and return it
	        return str.reverse().toString();
	    }
	}

}
