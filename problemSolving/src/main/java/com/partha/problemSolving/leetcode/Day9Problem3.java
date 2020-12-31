package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * @author biswaspa
 *
 */
public class Day9Problem3 {

	public static void main(String[] args) {
		new Solution1().maxSubArray(new int[] {1,2,3,0,0,0});
	}

	/**
	 * using dp
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
		public int maxSubArray(int[] nums) {
			int n = nums.length ;        
			if(n==0){
				return 0;
			}else {
				int[] result = new int[n];
				result[0] = nums[0];
				for(int i=1;i<n;i++){
					result[i] = Math.max(nums[i], result[i-1]+nums[i]);
				}

				int max= result[0];
				for(int i=1;i<result.length;i++){
					if(max<result[i]){
						max = result[i];
					}
				}
				return max;
			}


		}
	}


	/**
	 * in the above solution i have just removed the second loop to achieve the below
	 * @author biswaspa
	 *
	 */
	static class Solution2 {
		public int maxSubArray(int[] nums) {
			int n = nums.length ;        
			if(n==0){
				return 0;
			}else {
				int[] result = new int[n];
				result[0] = nums[0];
				int max = result[0];
				for(int i=1;i<n;i++){
					result[i] = Math.max(nums[i], result[i-1]+nums[i]);
					if(max<result[i]) {
						max=result[i];
					}
				}
				return max;
			}
		}
	}
	
	
	/**
	 * using dp
	 * timecomplexity O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution3 {
	    public int maxSubArray(int[] nums) {
	        System.out.println(nums[0]);
	        if(nums.length==0)
	            return nums[0];
	        int maxSum = nums[0];
	        int lastSum = nums[0];
	        for(int i=1;i<nums.length;i++){
	            lastSum = Math.max(lastSum + nums[i], nums[i]);
	            maxSum = Math.max(lastSum,maxSum);
	        }
	        return maxSum;
		}
	}

}
