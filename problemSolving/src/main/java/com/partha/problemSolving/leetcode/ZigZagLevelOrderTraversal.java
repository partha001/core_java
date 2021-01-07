package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.partha.problemSolving.leetcode.ZigZagLevelOrderTraversal.TreeNode;


public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {

		//        [1,2,3,4,null,null,5]
		//					  1
		//				  /      \
		//				2		    3
		//			  /   \		  /   \
		//			4      null  null   5


		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		new Solution1().zigzagLevelOrder(root);
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


	static class  Solution1 {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
			List<List<Integer>> list = new ArrayList();
			if(root==null)
				return list;
			boolean leftToRight = true;
			Stack<TreeNode> currentLevel = new Stack();
			Stack<TreeNode> nextLevel = new Stack();

			currentLevel.push(root);
			List<Integer> sublist = new ArrayList();

			while(!currentLevel.isEmpty()){
				TreeNode node = currentLevel.pop();
				sublist.add(node.val);
				if(leftToRight){
					if(node.left!=null)  nextLevel.push(node.left);
					if(node.right!=null) nextLevel.push(node.right);                
				}else{
					if(node.right!=null) nextLevel.push(node.right);
					if(node.left!=null)  nextLevel.push(node.left);
				}

				if(currentLevel.isEmpty()){
					list.add(sublist);
					sublist = new ArrayList();
					leftToRight = !leftToRight;
					currentLevel = nextLevel ;
					nextLevel = new Stack();
				}
			}

			return list;
		}
	}

}
