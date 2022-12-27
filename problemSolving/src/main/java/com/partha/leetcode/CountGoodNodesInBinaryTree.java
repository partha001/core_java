package com.partha.leetcode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * @author partha
 *
 */
public class CountGoodNodesInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private static class Solution1 {

		int good = 0;

		public int goodNodes(TreeNode root) {
			if(root==null)
				return good;
			countGood(root,root.val);
			return good;

		}

		private void countGood(TreeNode node,int max){
			if(node==null)
				return;
			if(node.val>=max){
				good++;
			}

			countGood(node.left, Math.max(max,node.val));
			countGood(node.right, Math.max(max,node.val));
		}
	}

	/**
	 * solution without the class level attribute for count.
	 * @author partha
	 *
	 */
	private static class Solution2
	{
		public int goodNodes(TreeNode root)
		{
			if(root==null)
				return 0;
			return dfs(root,root.val);
		}


		private int dfs(TreeNode root,int maxVal)
		{
			if(root==null)
				return 0;
			if(root.left==null&&root.right==null)
			{
				if(root.val>=maxVal)
					return 1;
				return 0;
			}
			
			int c=0;
			if(root.val>=maxVal)
			{
				maxVal=root.val;
				c++;
			}
			
			int l=dfs(root.left,maxVal);
			int r=dfs(root.right,maxVal);
			return l+c+r;
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
