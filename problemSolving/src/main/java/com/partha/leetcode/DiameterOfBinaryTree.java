package com.partha.leetcode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * @author partha
 *
 */
public class DiameterOfBinaryTree {

	public static void main(String[] args) {

	}
	
	private static  class Solution {
		
	    public int diameterOfBinaryTree(TreeNode root) {
	        if(root==null)
	            return 0;
	        int leftHeight = height(root.left);
	        int rightHeight = height(root.right);
	        int leftDiameter = diameterOfBinaryTree(root.left);
	        int rightDiameter = diameterOfBinaryTree(root.right);
	        return Math.max(leftHeight+rightHeight, Math.max(leftDiameter,rightDiameter));      
	    }
	    
	    
	    private int height(TreeNode node){
	        if(node==null)
	            return 0;
	        int leftHeight = height(node.left)+1;
	        int rightHeight = height(node.right)+1;
	        return Math.max(leftHeight,rightHeight);
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
