package com.partha.leetcode;

/**
 * @problem : https://leetcode.com/problems/gas-station/
 * @author biswaspa
 *
 */
public class GasStation {

	public static void main(String[] args) {
		
	}
	

	/**
	 * https://www.youtube.com/watch?v=lJwbPZGo05A
	 * @author biswaspa
	 *
	 */
	private static class Solution {
	    public int canCompleteCircuit(int[] gas, int[] cost) {
	        int totalGas = 0;
	        int totalCost = 0;
	        for(int i=0;i<gas.length;i++){
	            totalGas += gas[i];
	            totalCost += cost[i];
	        }

	        if(totalCost> totalGas)
	            return -1; //means there are no solution

	        totalGas =0;
	        int start=0;
	        for(int i=0;i<gas.length;i++){
	            totalGas += gas[i] - cost[i];

	            if(totalGas<0){
	                totalGas=0;
	                start = i+1;
	            }
	        }
	        return start;	        
	    }
	}
	
	
	/**
	 * same algo written in diferent way. but this has better execution time
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {
	    public int canCompleteCircuit(int[] gas, int[] cost) {
	        int currentGaining = 0;
			int totalGaining = 0;
			int candidate = 0;
			for (int i = 0; i < gas.length; i++) {
				currentGaining += gas[i] - cost[i];
				totalGaining += gas[i] - cost[i];
				if (currentGaining < 0) {
					candidate = i + 1;
					currentGaining = 0;
				}
			}
			return totalGaining >= 0 ? candidate : -1;
	    }
	}

}
