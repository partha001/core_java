package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		new Solution1().pathSum(root, 22);
	}


	static class Solution1 {

		List<List<Integer>> result;
		List<Integer> list;

		public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
			result = new ArrayList<List<Integer>>();
			list = new ArrayList<Integer>();
			if(root==null)
				return result;
			list.add(root.val);
			pathSum(root,targetSum,root.val);
			return result;
		}


		private void pathSum(TreeNode node, int targetSum,int currentSum){
			if(currentSum==targetSum && node.left==null && node.right==null){
				List<Integer> finalList = new ArrayList<>(list);
				result.add(finalList);
				return;
			}

			//note1: we are doing null check before making the recursive call
			if(node.left!=null){
				list.add(node.left.val);
				pathSum(node.left,targetSum,currentSum+node.left.val);
				list.remove(list.size()-1); 
				//note2: also note that we are removing the element from the end of the list
				//since the same list will be used for the right child
			}

			if(node.right!=null){
				list.add(node.right.val);
				pathSum(node.right,targetSum,currentSum+node.right.val);
				list.remove(list.size()-1);
			}
		}
	}



	//if we dont want class level attributes the the above code can be written as below
	private static class Solution2 {

		public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			if(root==null)
				return result;
			list.add(root.val);
			pathSum(root,targetSum,root.val,result,list);
			return result;
		}


		private List<List<Integer>> pathSum(TreeNode node, int targetSum,int currentSum, List<List<Integer>> result , List<Integer> list){
			if(currentSum==targetSum && node.left==null && node.right==null){
				List<Integer> finalList = new ArrayList<>(list);
				result.add(finalList);
				return result;
			}

			if(node.left!=null){
				list.add(node.left.val);
				pathSum(node.left,targetSum,currentSum+node.left.val, result, list);
				list.remove(list.size()-1);
			}

			if(node.right!=null){
				list.add(node.right.val);
				pathSum(node.right,targetSum,currentSum+node.right.val, result, list);
				list.remove(list.size()-1);
			}
			return result;
		}
	}



	//also if we dont want to add the element to list first and then pass is. 
	// rather currentSum and adding to list should happen when the item is processed then it can be written as below 
	private static class Solution3 {


		public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			if(root==null)
				return result;
			pathSum(root,targetSum,0,result,list);
			return result;
		}


		private List<List<Integer>> pathSum(TreeNode node, int targetSum,int currentSum, List<List<Integer>> result , List<Integer> list){
			currentSum = currentSum + node.val;
			list.add(node.val);

			if(currentSum==targetSum && node.left==null && node.right==null){
				List<Integer> finalList = new ArrayList<>(list);
				result.add(finalList);
				return result;
			}

			if(node.left!=null){
				pathSum(node.left,targetSum,currentSum, result, list);
				list.remove(list.size()-1);
			}

			if(node.right!=null){
				pathSum(node.right,targetSum,currentSum, result, list);
				list.remove(list.size()-1);
			}
			return result;
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
