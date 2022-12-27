package com.partha.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * solution discussion : https://leetcode.com/problems/house-robber-iii/discuss/1611881/JAVA-or-3-Approaches-or-Recursion-or-DP-or-Greedy-or-Detailed-Explanation
 * @explanation : https://www.youtube.com/watch?v=nHR8ytpzz7c
 * @author biswaspa
 *
 */
public class HouseRobber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private  class TreeNode {
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

	/**
	 * T.C : O(2^n)
	 *	S.C : O(1) (ignoring stack memory used for recursion)
	 * @author biswaspa
	 *
	 */
	private class Solution1{
		public int rob(TreeNode root) {
			if (root == null) return 0;

			int ans = 0;

			// max value from left grandchildren
			if (root.left != null) {
				ans += rob(root.left.left) + rob(root.left.right);
			}

			// max value from right grandchildren
			if (root.right != null) {
				ans += rob(root.right.left) + rob(root.right.right);
			}

			return Math.max(ans + root.val, rob(root.left) + rob(root.right));  //(Case1,Case2)
		}
	}


	/**
	 * T.C : O(n)
	 * S.C. : O(n)
	 * note how the map is used for memoization
	 * @author biswaspa
	 *
	 */
	class Solution2{
		public int rob(TreeNode root) {
			return rob(root, new HashMap<>());
		}

		public int rob(TreeNode root, Map<TreeNode, Integer> map) {

			if (root == null) 
				return 0;

			if (map.containsKey(root)) 
				return map.get(root);

			int ans = 0;

			if (root.left != null) {
				ans += rob(root.left.left, map) + rob(root.left.right, map);
			}
			if (root.right != null) {
				ans += rob(root.right.left, map) + rob(root.right.right, map);
			}

			ans = Math.max(ans + root.val, rob(root.left, map) + rob(root.right, map));
			map.put(root, ans);

			return ans;
		}
	}

	/**
	 * T.C. : O(n)
	 * S.C. : O(1)
	 * @author biswaspa
	 * @explanation every node returns an array of size 2 . 
	 * here arr[0] contains the max without including the node itself. [case1 : without including the node itself]
	 * while arr[1] contains the max value including the node itself.  [case2 : with the node itelf]
	 */
	private class Solution3 {

		public int rob(TreeNode root) {
			int[] ans = robHouse(root);
			return Math.max(ans[0],ans[1]);
		}

		public int[] robHouse(TreeNode root){
			if(root==null){
				return new int[2];
			}

			int left[] = robHouse(root.left);
			int right[] = robHouse(root.right);

			int ans[] = new int[2];

			ans[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
			ans[1] = root.val+left[0]+right[0];

			return ans;
		}
	}


}
