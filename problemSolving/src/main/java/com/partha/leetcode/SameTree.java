package com.partha.leetcode;

import com.partha.leetcode.BalancedBinaryTree.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 * @author partha
 *
 */
public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution1 {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        if(p==null && q==null)
	            return true;
	        if(p==null  || q==null)
	            return false;
	        if(p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right))
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
