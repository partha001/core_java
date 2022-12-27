package com.partha.leetcode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author biswaspa
 *
 */
public class LowestCommonAncestorInBinaryTree {

	public static void main(String[] args) {

	}
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	static class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	       if(root==null)
	    	   return null;
	       if(root==p || root==q)
	    	   return root;
	       TreeNode left = lowestCommonAncestor(root.left,p,q);
	       TreeNode right = lowestCommonAncestor(root.right, p, q);
	       if(left!=null && right!=null)
	    	   return root;
	       if(left==null && right==null)
	    	   return null;
	       return left!=null ? left : right;
	    }
	}
	
	

}
