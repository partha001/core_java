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
	        
	        if(node.left!=null){
	            list.add(node.left.val);
	            pathSum(node.left,targetSum,currentSum+node.left.val);
	            list.remove(list.size()-1);
	        }
	        
	        if(node.right!=null){
	            list.add(node.right.val);
	            pathSum(node.right,targetSum,currentSum+node.right.val);
	            list.remove(list.size()-1);
	        }
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
