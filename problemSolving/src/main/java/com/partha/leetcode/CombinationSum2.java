package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * @author biswaspa
 *
 */
public class CombinationSum2 {

	public static void main(String[] args) {
		List<List<Integer>> combinationSum2 = new Solution1().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8);
		System.out.println(combinationSum2);
	}

	static class Solution1 {
		public List<List<Integer>> combinationSum2(int[] candidates, int target) {
			List<List<Integer>> result = new ArrayList();
			List<Integer> current = new ArrayList();
			Arrays.sort(candidates);
			combination(candidates,target,result,current,0,0);
			return result;
		}


		public void combination(int[] candidates,
				int target, 
				List<List<Integer>> result,
				List<Integer> current,
				int currentSum,
				int start
				){
			if(currentSum==target){
				result.add(new ArrayList<Integer>(current));
				return;
			}
			if(currentSum>target)
				return;
			if(currentSum < target){
				for(int i=start;i<candidates.length;i++){
					if(i>start && candidates[i] == candidates[i-1]) continue; //avoid duplicates
					current.add(candidates[i]);
					combination(candidates,target,result,current,currentSum + candidates[i],i+1);
					current.remove(current.size()-1);
				}
			}

		}
	}

}
