package com.partha.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/target-sum/
 * @author partha
 *
 */
public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




	/**
	 * approach: bottomup Tablulation. 
	 * https://www.youtube.com/watch?v=g0npyaQtAQM
	 * @author partha
	 *
	 */
	private static class Solution1 {
		public int findTargetSumWays(int[] nums, int target) {
			HashMap<Map.Entry<Integer,Integer>,Integer> map = new HashMap<Map.Entry<Integer,Integer>,Integer>(); //key= pair(index,total)  value=ways
			return dfs(nums,target,0,0,map);
		}

		public int dfs(int[] nums , int target, int index, int currentTotal,  HashMap<Map.Entry<Integer,Integer>,Integer> map)
		{
			if( index == nums.length) //baseCase1: reached end of nums
				return target==currentTotal? 1: 0;

			if( map.containsKey(Map.entry(index, currentTotal))) //baseCase2: value is already cached
				return map.get(Map.entry(index, currentTotal));

			int add = dfs( nums, target, index+1 , currentTotal + nums[index], map);
			int subtract = dfs( nums, target, index+1 , currentTotal - nums[index], map);
			map.put (Map.entry(index, currentTotal), add+ subtract);
			return add+subtract;

		}
	}


	/**
	 * approach: topDown recursion
	 * same algo as above just index is moving frm high to low. 
	 * also not using currentTotal, rather doing +/-1 target 
	 * checking if target is 0 or not.
	 * @author partha
	 *
	 */
	private static class Solution2 {
		public int findTargetSumWays(int[] nums, int target) {
			HashMap<Map.Entry<Integer,Integer>,Integer> map = new HashMap<Map.Entry<Integer,Integer>,Integer> ();
			return helper(nums,target,nums.length-1,map);
		}

		public int helper(int[] nums , int target, int index,HashMap<Map.Entry<Integer,Integer>,Integer>  map)
		{
			if(index==-1) //baseCase1: end of index
				return target==0? 1:0;

			if(map.containsKey(Map.entry(index, target))) //baseCase2: if value is cached
				return map.get(Map.entry(index, target));

			//add every index there is 2 choice . we can either add or subtract . hence two recursive calls
			int add = helper(nums,target+nums[index],index-1,map);        
			int subtract = helper(nums,target-nums[index],index-1,map);

			map.put(Map.entry(index, target),add+subtract);
			return add+subtract;
		}
	}



}
