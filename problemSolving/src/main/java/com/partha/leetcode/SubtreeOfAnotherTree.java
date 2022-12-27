package com.partha.leetcode;


/**
 * https://leetcode.com/problems/subtree-of-another-tree
 * @author partha
 *
 */
public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private static class Solution {
		public boolean isSubtree(TreeNode s, TreeNode t) {
			if (s == null) return false;
			if (isSame(s, t)) return true;
			return isSubtree(s.left, t) || isSubtree(s.right, t); //note OR is used since the subtree can be on either side
		}

		private boolean isSame(TreeNode s, TreeNode t) {
			if (s == null && t == null) return true;
			if (s == null || t == null) return false;

			if(s.val==t.val && isSame(s.left,t.left) && isSame(s.right,t.right))
				return true;
			return false;
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
