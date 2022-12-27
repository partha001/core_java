package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author biswaspa
 *
 */
public class KthSmallestElement {

	public static void main(String[] args) {

	}
	
	//using inOrderTraversal
	static class Solution1 {
	    List<Integer> list = new ArrayList<Integer>();
	    
	    public int kthSmallest(TreeNode root, int k) {
	        if(root==null)
	            return -1;
	        inOrder(root);
	        return list.get(k-1);
	        
	    }
	    
	    public void inOrder(TreeNode node){
	        if(node!=null){
	            inOrder(node.left);
	            list.add(new Integer(node.val));
	            inOrder(node.right);
	        }
	    }
	}
	
	
	//helper class
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
