package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets
 * @author biswaspa
 *
 */
public class Subset {

	public static void main(String[] args) {

	}

	static class Solution1 {

		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> sublist = new ArrayList<Integer>();
			if(nums.length==0)
				return result ;
			backtrack(nums,result,sublist,0);
			return result;
		}

		public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> sublist, int start){
			result.add(new ArrayList<Integer>(sublist)); //here is the catch in this prob

			for(int i = start; i < nums.length; i++){
				sublist.add(nums[i]);
				backtrack(nums, result , sublist, i + 1);
				sublist.remove(sublist.size() - 1);
			}
		}
	}

}
