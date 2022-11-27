package com.partha.problemSolving.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @problem https://leetcode.com/problems/path-sum-iii/
 * @author biswaspa
 *
 */
public class PathSum3 {

	public static void main(String[] args) {

	}


	//this logic is correct but doesnt clear all test case 
	//since for 1 test case the values are larger than what integer can support. 
	//so take currentSum as long 
	private static class Solution1 {
		int result =0;

		public int pathSum(TreeNode root, int sum) {
			if(root==null)
				return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode current = queue.poll();
				pathSum(current,sum,current.val);

				if(current.left!=null)
					queue.add(current.left);

				if(current.right!=null)
					queue.add(current.right);
			}
			return result;
		}


		private void pathSum(TreeNode node, int target, long currentSum){
			if((long)currentSum==target){
				result++;
			}

			if(node.left!=null)
				pathSum(node.left , target, currentSum + node.left.val);

			if(node.right!=null)
				pathSum(node.right , target , currentSum + node.right.val);
		}

	}


	// this is the recursive solution without taking a queue
	private static class Solution2 {
		
		int count=0;
		
		public int pathSum(TreeNode root, int targetSum) {
			if(root==null){
				return 0;
			}
			check(root,0,targetSum);
			pathSum(root.left,targetSum);
			pathSum(root.right,targetSum);
			return count;
		}
		
		public void check(TreeNode root,long sum,int target){
			if(root==null){
				return;
			}
			if(sum+root.val==(long)target){
				count+=1;
			}
			check(root.left,sum+root.val,target);
			check(root.right,sum+root.val,target);
		}
	}

	private class TreeNode {
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
