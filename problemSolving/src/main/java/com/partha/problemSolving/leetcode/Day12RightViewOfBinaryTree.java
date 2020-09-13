package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * @author biswaspa
 *
 */
public class Day12RightViewOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		
		new Solution1().rightSideView(root);
	}


	public static class TreeNode {
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


	public static class Solution1{

		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> result= new ArrayList<Integer>();
			if(root==null)
				return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				
				int nodeCountAtLevel = queue.size();
				for(int i=0;i<nodeCountAtLevel;i++) {
					TreeNode current = queue.poll();
					if(current.left!=null)
						queue.add(current.left);
					
					if(current.right!=null)
						queue.add(current.right);
					
					if(i==nodeCountAtLevel-1) {
						result.add(current.val);
					}
				}			
			}
			return result;
		}

	}

}

/**
 * 
 */
