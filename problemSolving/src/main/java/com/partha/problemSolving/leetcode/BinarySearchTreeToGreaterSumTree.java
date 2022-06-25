package com.partha.problemSolving.leetcode;

/**
 * @problem : https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * @author biswaspa
 *
 */
public class BinarySearchTreeToGreaterSumTree {
	
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * solution with class level attribute
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    int sum = 0;
	   
	    public TreeNode bstToGst(TreeNode root) {
	        if(root==null)
	            return root;
	        bstToGst(root.right);
	        sum = sum + root.val;
	        root.val = sum;
	        bstToGst(root.left);
	        return root;
	    }
	}
	
	
	/**
	 * solution without a class level attribute
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    public TreeNode bstToGst(TreeNode root) {
	        search(root, 0);
	        return root;
	    }
	    
	    private int search(TreeNode node, int sum) {
	        if (node == null) return sum;
	        
	        sum = search(node.right, sum);
	        sum += node.val;
	        node.val = sum;
	        sum = search(node.left, sum);
	        
	        return sum;
	    }
	}
	
	
	
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

}
