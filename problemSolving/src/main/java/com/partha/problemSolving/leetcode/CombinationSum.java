package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * @author biswaspa
 */
public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> combinationSum = new Solution1().combinationSum(new int[] {7,2,3,6}, 7);
		System.out.println("");
	}
	
	static class Solution1 {
	    List<List<Integer>> listOfCombinations = new ArrayList<>();
	    
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<Integer> combination = new ArrayList<Integer>();
	        int sum = 0;
	        generateCombinations(candidates, target, combination, sum, 0);
	        return listOfCombinations;
	    }
	    
	    private void generateCombinations(int[] candidates, int target, List<Integer> combination, int sum, int startIndex){
	        if(sum == target){
	            List<Integer> validCombination = new ArrayList<Integer>(combination);
	            listOfCombinations.add(validCombination);
	            return;
	        }
	        
	        if(sum > target){
	            return;
	        }
	        
	        if(sum < target){
	            for(int i = startIndex; i < candidates.length; i++){
	                sum = sum + candidates[i];
	                combination.add(candidates[i]);
	                generateCombinations(candidates, target, combination, sum, i);
	                sum = sum - candidates[i];
	                combination.remove(combination.size() - 1);
	            }
	        }
	    }
	}

}
