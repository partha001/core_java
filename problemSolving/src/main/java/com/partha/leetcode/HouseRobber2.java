package com.partha.leetcode;

/**
 * https://leetcode.com/problems/house-robber-ii/
 * @author biswaspa
 *
 */
public class HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * reff: https://www.youtube.com/watch?v=rWAJCfYYOvM
	 * resusing the helper function from last solution of house-robber1
	 * @author partha
	 *
	 */
	private static class Solution1 {

		public int rob(int[] nums) {

			if(nums.length==1) // when only one house
				return nums[0];
			if(nums.length==2) // when there are 2 houses
				return Math.max(nums[0],nums[1]);

			int x = rob(nums,0,nums.length-2);
			int y = rob(nums,1,nums.length-1);
			return Math.max(x,y);

		}


		private int rob(int[] nums,int start,int end){
			int odd=0;
			int even=0;
			for(int i=start;i<=end;i++){
				if(i%2==0){
					even = Math.max(even + nums[i] , odd);
				}else{
					odd = Math.max(odd + nums[i] , even);
				}
			}
			return Math.max(odd,even);
		}
	}



	/**
	 * @source leetcode official solution
	 * @author partha
	 *
	 */
	private static class Solution2 {
		public int rob(int[] nums) {
			if (nums.length == 0)
				return 0;

			if (nums.length == 1)
				return nums[0];

			int max1 = rob_simple(nums, 0, nums.length - 2);
			int max2 = rob_simple(nums, 1, nums.length - 1);

			return Math.max(max1, max2);
		}

		public int rob_simple(int[] nums, int start, int end) {
			int t1 = 0;
			int t2 = 0;

			for (int i = start; i <= end; i++) {
				int temp = t1;
				int current = nums[i];
				t1 = Math.max(current + t2, t1);
				t2 = temp;
			}

			return t1;
		}
	}

	
}
