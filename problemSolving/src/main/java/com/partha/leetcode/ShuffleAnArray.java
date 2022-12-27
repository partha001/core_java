package com.partha.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleAnArray {

	public static void main(String[] args) {

	}
	
	
	
	private static class Solution1 {
		
		int[] original ;
		int[] shuffled ;

	    public Solution1(int[] nums) {
	    	original = Arrays.copyOf(nums,nums.length);  
	    	shuffled = Arrays.copyOf(nums,nums.length);  
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return original;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        Random random = new Random();
	        for(int i=0;i<original.length;i++) {
	        	int generatedIndex  = random.nextInt(original.length-1);
	        	if(generatedIndex!=i) {
	        		int temp = shuffled[generatedIndex];
	        		shuffled[generatedIndex] = shuffled[i];
	        		shuffled[i] = temp;
	        	}
	        }
	        return shuffled;
	        
	    }
	}


}
