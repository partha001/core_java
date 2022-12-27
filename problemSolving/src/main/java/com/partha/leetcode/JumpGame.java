package com.partha.leetcode;

/**
 * https://leetcode.com/problems/jump-game/
 * @author partha
 *
 */
public class JumpGame {

	public static void main(String[] args) {

	}
	
	private static class Solution1 {
	    public boolean canJump(int[] nums) {
	        int reachable = 0;
	        for(int i=0; i<nums.length; i++){
	            if(reachable<i)
	             return false;
	          reachable = Math.max(reachable,i+nums[i]);  
	        }
            return true;
	    }
	}
	
	
	/*
	 * 
	 * https://www.youtube.com/watch?v=Yan0cv2cLy8
	 * traversing in backward direction. practice this
	 */
	private static class Solution2 {
	    public boolean canJump(int[] nums) {
	        int n = nums.length;
	        int lastTrue = n-1;
	        for(int i = n-2;i>=0;i--){
	            int jumpSize = nums[i];
	            if(i+jumpSize >= n-1 || i+jumpSize>=lastTrue){ //can you jump from here and reach the end or atleast reach the point that can help reach the end?
	                lastTrue = i;
	            }
	        }
	        return lastTrue == 0;
	    }
	}
	

}


