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
		List<List<Integer>> result = new ArrayList();

		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			backtrack(candidates, 0, 0, target, new ArrayList<Integer>());
			return result;
		}

		private void backtrack(int[] candidates, int index, int currentSum,int target, List<Integer> list){
			if(currentSum == target){
				result.add(new ArrayList(list));
				return;
			}
			for(int i=index; i< candidates.length;i++){
				if(currentSum + candidates[i] <= target){
					list.add(candidates[i]);
					backtrack(candidates, i , currentSum + candidates[i], target, list);
					list.remove(list.size()-1);
				}
			}
		}
	}

}
