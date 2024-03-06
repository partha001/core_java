package com.partha.leetcode;

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * @link <a href="https://www.youtube.com/watch?v=dJ7sWiOoK7g">link</a>
	 * @author biswaspa
	 *
	 */
	private static class Solution {
		public int jump(int[] nums) {
			int result =0;
			int left =0;
			int right =0;
			while(right < nums.length -1){ //note here we are doing n-1 since thats mentioned in question
				int farthest = 0;
				for(int i=left;i<=right;i++){
					farthest = Math.max(farthest, i + nums[i] );
				}
				left = right+1;
				right = farthest;
				result++;
			} 
			return result; 
		}
	}

}
