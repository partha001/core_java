package com.partha.leetcode;

/**
 * https://leetcode.com/problems/beautiful-arrangement/
 * @author partha
 *
 */
public class BeautifulArragement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * backtracking solution
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    int res = 0;
	    public int countArrangement(int n) {
	        helper(new boolean[n+1],0,n);
	        return res;
	    }
	    
	    public void helper(boolean[] taken,int currIntegerCount,int maxIntegers){
	        
	        if(currIntegerCount == maxIntegers){
	            res++;
	            return;
	        }
	        
	        //we have total 1 to n values
	        for(int i = 1; i <= maxIntegers; i++){
	            if(!taken[i] && checkEitherCondition(i,currIntegerCount+1)){
	                taken[i] = true;
	                helper(taken,currIntegerCount+1,maxIntegers);
	                taken[i] = false;
	            }
	        }
	    }
	    
	    public boolean checkEitherCondition(int num,int curr){
	        if(curr%num == 0)
	            return true;
	        if(num%curr == 0)
	            return true;        
	        return false;
	    }    
	}
	
	
	/**
	 * backtrackig solution
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    public int countArrangement(int n) {
	        int[] nums = new int[n + 1];

	        for (int i = 1; i <= n; i++) {
	            nums[i] = i;
	        }
	        return recur(nums, 1);
	    }

	    private int recur(int[] nums, int index) {

	        if (index == nums.length) {
	            return 1;
	        }
	        int ans = 0;

	        for (int i = index; i < nums.length; i++) {
	            swap(nums, index, i);
	            
	            if (nums[index] % index == 0 || index % nums[index] == 0) {
	                ans += recur(nums, index + 1);
	            }
	            swap(nums, index, i);
	        }
	        return ans;
	    }

	    private void swap(int[] nums, int x, int y) {
	        int temp = nums[x];
	        nums[x] = nums[y];
	        nums[y] = temp;
	    }
	}

}
