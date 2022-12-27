package com.partha.leetcode;

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
			backtrack(candidates, target, combination, 0, 0);
			return listOfCombinations;
		}

		private void backtrack(int[] candidates,int target,List<Integer> combination,int sum,int start){
			if(sum == target){
				List<Integer> validCombination = new ArrayList<Integer>(combination);
				listOfCombinations.add(validCombination);
				return;
			}

			for(int i = start; i < candidates.length; i++){
				if(sum + candidates[i]<=target){
					combination.add(candidates[i]);
					backtrack(candidates, target, combination, sum + candidates[i], i);
					combination.remove(combination.size() - 1);
				}

			}
		}
	}

}
