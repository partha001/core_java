package com.partha.leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/path-sum/
 * @author biswaspa
 *
 */
public class PathSum {

	public static void main(String[] args) {
		
	}


	/**
	 * my solution
	 * @author biswaspa
	 *
	 */
	static class Solution {

		public boolean found = false;

		public boolean hasPathSum(TreeNode root, int targetSum) {
			if(root==null)
				return false;
			hasSum(root,targetSum,root.val); 
			return found;
		}


		private void hasSum(TreeNode node,int targetSum,int currentSum){
			if(currentSum==targetSum && node.left==null && node.right==null){
				if(this.found==false){
					this.found = true;
					return;
				}
			}

			if(node.left!=null && !found)
				hasSum(node.left,targetSum,currentSum + node.left.val);

			if(node.right!=null && !found)
				hasSum(node.right,targetSum,currentSum + node.right.val);

		}
	}




	static class TreeNode {
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
