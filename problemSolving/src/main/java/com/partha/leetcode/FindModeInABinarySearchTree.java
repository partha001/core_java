package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * @author partha
 *
 */
public class FindModeInABinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private static class Solution1 {
		int max =1;

		public int[] findMode(TreeNode root) 
		{
			HashMap<Integer,Integer> map = new HashMap<>();

			find_mode(root , map);

			int[] ans = new int[map.size()];
			int idx=0;

			for(Integer key: map.keySet())
			{
				if(map.get(key) == max)
					ans[idx++] = key;
			}
			return Arrays.copyOf(ans , idx);
		}

		private void find_mode(TreeNode root , HashMap<Integer,Integer> map)
		{
			if(root == null)
				return;

			if(map.containsKey(root.val))
			{
				int count = map.get(root.val) + 1;
				map.put(root.val , count);
				max = Math.max(count , max);
			}
			else
				map.put(root.val , 1);

			find_mode(root.left , map);
			find_mode(root.right , map);
		}
	}


	/**
	 * SC: O(1)
	 * @author partha
	 *
	 */
	private static class Solution2{

		int max = Integer.MIN_VALUE;
		int count = 1;
		List<Integer> list = new ArrayList<>();
		TreeNode prev = null;

		public int[] findMode(TreeNode root) {
			getModes(root, list);
			int[] result = new int[list.size()];
			for(int i=0; i<list.size(); i++) {
				result[i] = list.get(i);
			}
			return result;
		}

		private void getModes(TreeNode root, List<Integer> list) {
			if(root == null) {
				return;
			}

			getModes(root.left, list);
			if(prev != null) {
				if(prev.val == root.val) {
					count++;
				} else {
					count = 1;
				}
			}


			if(count > max) {
				max = count;
				list.clear();
				list.add(root.val);
			} else if(count == max) {
				list.add(root.val);
			}
			prev = root;
			getModes(root.right, list);
		}


	}



	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}


}
