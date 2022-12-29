package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * @author biswaspa
 *
 */
public class Permutations {

	public static void main(String[] args) {
		List<List<Integer>> permute = new Solution1().permute(new int[] {1,2,3});
		System.out.println("");
	}

	static class Solution1 {

		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> current = new ArrayList<>();
			findPermutations(result, current, nums, 0);
			return result;
		}

		public void findPermutations(List<List<Integer>> result, List<Integer> current, int [] nums, int start) {
			if (current.size() == nums.length) {
				result.add(new ArrayList<>(current));
				return;
			}
			for (int i=start; i<nums.length; i++) {
				if (!current.contains(nums[i])) {
					current.add(nums[i]);
					findPermutations(result, current, nums, 0); 
					//note here since we want to find every permumation so we are sending the start as 0 always 
					//and to avoid duplicate elements we have the condition !current.contains(nums[i])
					current.remove(current.size()-1);
				}
			}
		}
	}

}
