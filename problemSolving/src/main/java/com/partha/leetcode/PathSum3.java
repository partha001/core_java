package com.partha.leetcode;

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
	private static class Solution {
		int count=0;
		public int pathSum(TreeNode root, int targetSum) {
			if(root==null){
				return count;
			}
			Queue<TreeNode> q=new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()){
				TreeNode temp=q.poll();
				check(temp,0,targetSum);
				if(temp.left!=null){
					q.add(temp.left);
				}
				if(temp.right!=null){
					q.add(temp.right);
				}
			}
			return count;
		}

		//note: no condition for null since we are doing null check before adding to processing queue above
		public void check(TreeNode root,long sum,int target){
			if(sum+root.val==(long)target){
				count++;
			}
			if(root.left!=null)
				check(root.left,sum+root.val,target);

			if(root.right!=null)
				check(root.right,sum+root.val,target);
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
