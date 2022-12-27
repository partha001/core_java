package com.partha.leetcode;

/**
 * leetcode : https://leetcode.com/problems/house-robber/
 * @author biswaspa
 *
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] arr = new int[] {10,3,2,6,7};
		
		System.out.println(new Solution1().rob(arr));
	}

	/**
	 * timecomplexity = O(n)
	 * spacecomplexity = O(n)
	 * @param nums
	 * @return
	 */
	private static class Solution1 {
	    public int rob(int[] nums) {
			if(nums.length==0) {
				return 0;
			}else if(nums.length==1){
				return nums[0]; 
			}else if (nums.length==2) {
				return (nums[0]>=nums[1]) ? nums[0] : nums[1];
			}else {
				int[] result= new int[nums.length];
				result[0]=nums[0];
				result[1]= Math.max(nums[0],nums[1]);
				for(int i=2 ; i<nums.length; i++) {
					result[i] = Math.max(nums[i] + result[i-2] , result[i-1] );    
				}
				return result[result.length-1];
			}
		}
	}
	
	
	/**
	 * same logic but removing the extra array by using two variables
	 *
	 */
	private static class Solution2 {
	    public int rob(int[] nums) {
	        if(nums.length==1)
	            return nums[0];
	        int first = nums[0];
	        int second = Math.max(nums[0],nums[1]);
	        int result = second;
	        for(int i=2;i<nums.length;i++){
	            int currentMax = Math.max(  nums[i] + first, second);    
	            //pushing the values to left by 1 since we are proceeding in the right
	            first = second;
	            second = currentMax;
	            //storing final result;
	             result  = Math.max( result , currentMax); 
	        }
	        return result;
	    }
	}
	
	
	
	/**
	 * another strategy can be using even/odd . but here we need a helper function.  
	 * this helper function is easy to be used for house-robber2
	 */
	private static class Solution {
	    public int rob(int[] nums) {
	        return rob(nums,0,nums.length-1);
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

}
