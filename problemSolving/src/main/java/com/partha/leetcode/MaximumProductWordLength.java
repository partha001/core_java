package com.partha.leetcode;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths
 * @author biswaspa
 *
 */
public class MaximumProductWordLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	/**
	 * https://leetcode.com/problems/maximum-product-of-word-lengths/solutions/2085540/java-clean-and-concise-brute-better-best/
	 * TC O(n^2 + m)
	 * SC O(n)
	 * @author biswaspa
	 * bitmask method
	 */
	private static class Solution {
	    public int maxProduct(String[] words) {
	        int n = words.length;
	        int[] bitmask = new int[n]; 
	        int max = 0;

	        for(int i=0; i<n; i++) {
	            // Calculate bitmask for current word
	            for(int j=0; j<words[i].length(); j++) {
	                // index will be - for a -> 0, b -> 1, c -> 2 and so on
	                int index = words[i].charAt(j) - 'a';
	                
	                // left shift 1 by index and OR it with the current bitmask
	                bitmask[i] |= (1 << index);
	            }
	            
	            // Compare bitmask of current string with previous strings bitmask
	            for(int j=0; j<i; j++) {
	                /* If there is a 1 at the same index of current string {i} and {j},
	                then bitmask of i and j string will result in a number greater than 0,
	                else it will result in 0 */
	                if( (bitmask[i] & bitmask[j]) == 0 ) 
	                    max = Math.max(max, words[i].length()*words[j].length());	
	            }
	        }

	        return max;
	    }
	}

}
