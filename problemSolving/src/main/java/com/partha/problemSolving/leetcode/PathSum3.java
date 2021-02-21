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
	
	
	static class Solution {
	    int result =0;
	    
	    public int pathSum(TreeNode root, int sum) {
	        if(root==null)
	            return result;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            TreeNode current = queue.remove();
	            pathSum(current,sum,current.val);
	            
	            if(current.left!=null)
	                queue.add(current.left);
	            
	            if(current.right!=null)
	                queue.add(current.right);
	        }
	        return result;
	    }
	    
	    
	    public void pathSum(TreeNode node, int target, int currentSum){
	        if(currentSum==target){
	            result++;
	        }
	        
	        if(node==null)
	            return;
	        
	        if(node.left!=null)
	            pathSum(node.left , target, currentSum + node.left.val);
	        
	        if(node.right!=null)
	            pathSum(node.right , target , currentSum + node.right.val);
	    }
	}
	
	static public class TreeNode {
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
