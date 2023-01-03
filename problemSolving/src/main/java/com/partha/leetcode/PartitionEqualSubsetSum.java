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
	
	
	//my solution . 
	private static class Solution {
		
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
	
	
	///below solutions are taken from leetcode
    //Brute Force : naive solution
	private static class Solution1 {
	    public boolean canPartition(int[] nums) {
	        int totalSum = 0;
	        // find sum of all array elements
	        for (int num : nums) {
	            totalSum += num;
	        }
	        // if totalSum is odd,it cannot be partitioned into equal sum subset
	        if (totalSum % 2 != 0) return false;
	        int subSetSum = totalSum / 2;
	        int n = nums.length;
	        return dfs(nums, n - 1, subSetSum);
	    }

	    public boolean dfs(int[] nums, int n, int subSetSum) {
	        // Base Cases
	        if (subSetSum == 0)
	            return true;
	        if (n == 0 || subSetSum < 0)
	            return false;
	        return dfs(nums, n - 1, subSetSum - nums[n - 1]) || dfs(nums, n - 1, subSetSum);
	    }
	}
	
	/**
	 * Top down dynamic programming approach 
	 * @author partha
	 * @source leetcode official solution
	 * @TC O(m*n)
	 * @SC O(m*n)
	 */
	private static class Solution2 {
	    public boolean canPartition(int[] nums) {
	        int totalSum = 0;
	        // find sum of all array elements
	        for (int num : nums) {
	            totalSum += num;
	        }
	        // if totalSum is odd, it cannot be partitioned into equal sum subset
	        if (totalSum % 2 != 0) return false;
	        int subSetSum = totalSum / 2;
	        int n = nums.length;
	        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
	        return dfs(nums, n - 1, subSetSum, memo);
	    }

	    public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
	        // Base Cases
	        if (subSetSum == 0)
	            return true;
	        if (n == 0 || subSetSum < 0)
	            return false;
	        // check if subSetSum for given n is already computed and stored in memo
	        if (memo[n][subSetSum] != null)
	            return memo[n][subSetSum];
	        boolean result = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
	                dfs(nums, n - 1, subSetSum, memo);
	        // store the result in memo
	        memo[n][subSetSum] = result;
	        return result;
	    }
	}
	
	
	/**
	 * Bottom up dynamic programming approach 
	 * @author partha
	 * @source leetcode official solution
	 * @TC O(m*n)
	 * @SC O(m*n)
	 */
	private static class Solution3 {
	    public boolean canPartition(int[] nums) {
	        int totalSum = 0;
	        // find sum of all array elements
	        for (int num : nums) {
	            totalSum += num;
	        }
	        // if totalSum is odd, it cannot be partitioned into equal sum subset
	        if (totalSum % 2 != 0) return false;
	        int subSetSum = totalSum / 2;
	        int n = nums.length;
	        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
	        dp[0][0] = true;
	        for (int i = 1; i <= n; i++) {
	            int curr = nums[i - 1];
	            for (int j = 0; j <= subSetSum; j++) {
	                if (j < curr)
	                    dp[i][j] = dp[i - 1][j];
	                else
	                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);
	            }
	        }
	        return dp[n][subSetSum];
	    }
	}
	
	
	/**
	 * Optimized dynamic programming using 1D array
	 * @author partha
	 * @source leetcode official solution
	 * @TC O(m*n)
	 * @SC O(m)
	 */
	private static class Solution4 {
	    public boolean canPartition(int[] nums) {
	        if (nums.length == 0)
	            return false;
	        int totalSum = 0;
	        // find sum of all array elements
	        for (int num : nums) {
	            totalSum += num;
	        }
	        // if totalSum is odd, it cannot be partitioned into equal sum subset
	        if (totalSum % 2 != 0) return false;
	        int subSetSum = totalSum / 2;
	        boolean dp[] = new boolean[subSetSum + 1];
	        dp[0] = true;
	        for (int curr : nums) {
	            for (int j = subSetSum; j >= curr; j--) {
	                dp[j] |= dp[j - curr];
	            }
	        }
	        return dp[subSetSum];
	    }
	}

}
