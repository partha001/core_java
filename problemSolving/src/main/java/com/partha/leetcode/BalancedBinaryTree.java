package com.partha.leetcode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * @param args
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {

	}



	//Definition for a binary tree node.
	public class TreeNode {
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
	 * O(nxn)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
		public boolean isBalanced(TreeNode root) {
			if(root==null)
				return true;
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			if(Math.abs(leftHeight - rightHeight)<=1)
				return isBalanced(root.left) && isBalanced(root.right);
			return false;
		}

		public int height(TreeNode root){
			if(root==null)
				return 0;
			return 1 + Math.max(height(root.left) , height(root.right)) ;        
		}

	}


	/**
	 * TimeComplexity O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution2{

		public boolean isBalanced(TreeNode node){
			return isBalanced(node, new Height());
		}

		public boolean isBalanced(TreeNode root, Height height) 
		{ 
			/* If tree is empty then return true */
			if (root == null) { 
				height.height = 0; 
				return true; 
			} 

			/* Get heights of left and right sub trees */
			Height lheight = new Height(); 
			Height rheight = new Height(); 
			boolean l = isBalanced(root.left, lheight); 
			boolean r = isBalanced(root.right, rheight); 
			int lh = lheight.height, rh = rheight.height; 

			/* Height of current node is max of heights of 
			           left and right subtrees plus 1*/
			height.height = (lh > rh ? lh : rh) + 1; 

			/* If difference between heights of left and right 
			           subtrees is more than 2 then this node is not balanced 
			           so return 0 */
			if (Math.abs(lh -rh) >= 2) 
				return false; 

			/* If this node is balanced and left and right subtrees 
			           are balanced then return true */
			else
				return l && r; 
		} 


		class Height { 
			int height = 0; 
		} 

	}


	/**
	 * Not using  repeatative calls like in solution1 nor additional class as used in Solution2 is required.
	 * @author biswa
	 *
	 */
	private static class Solution3 {

		boolean result = true;

		public boolean isBalanced(TreeNode root) {
			height(root);
			return result;
		}

		private int height(TreeNode node){
			if(result == false) //to avoid furthur processing
				return 0; //return value in this case doesnt matter since we are interested in the flag

			if(node==null)
				return 0;

			int left = height(node.left);
			int right = height(node.right);

			if(Math.abs(left - right) >1)
				result = false;

			return Math.max(left , right) +1;
		}
	}



}
