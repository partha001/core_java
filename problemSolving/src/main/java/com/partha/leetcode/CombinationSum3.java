package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * @author biswaspa
 *
 */
public class CombinationSum3 {

	public static void main() {

	}


	static class Solution {
		public List<List<Integer>> combinationSum3(int k, int n) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> sublist = new ArrayList();
			combination(k,n,result,sublist,1);
			return result;
		}

		private void combination(int k,
				int target,
				List<List<Integer>> result , 
				List<Integer> sublist, 
				int start
				){
			if(k==0 && target==0){
				result.add(new ArrayList<Integer>(sublist));
				return;
			}
			
			if(k==0 || target==0){
				return;
			}

			for(int i=start;i<=9;i++){
				sublist.add(i);
				combination(k-1,target-i,result,sublist,i+1);
				sublist.remove(sublist.size()-1);
			}
		}
	}

}
