package com.partha.leetcode;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * @author biswaspa
 *
 */
public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution1 {
		
		public boolean canPartition(int[] nums) {
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	        }
	        if(sum%2==1)
	            return false;
	        Boolean dp[][]=new Boolean[nums.length+1][(sum/2)+1];
	        return partition(nums,sum/2,0,dp);
	    }
		
	    public boolean partition(int a[],int sum,int i,Boolean dp[][]){
	        if(sum==0)
	            return true;
			if(i>=a.length || sum<0)
	            return false;
	        if(dp[i][sum]!=null)
	            return dp[i][sum];
	        return dp[i][sum]=(partition(a,sum-a[i],i+1,dp) || partition(a,sum,i+1,dp));
	    }
	    
	}

}
