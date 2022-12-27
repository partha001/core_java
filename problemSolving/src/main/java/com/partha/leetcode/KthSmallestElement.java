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
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		int result = new KthSmallestElement.Solution2().kthSmallest(root, 1);
		System.out.println(result);
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
	
	
	 private static class Solution2 {

	     int count=0;
	     TreeNode result=null;

	     public int kthSmallest(TreeNode root, int k) {
	         if(root==null)
	             return -1;
	         find(root,k);
	         return result.val;
	     }

	     public void find(TreeNode node,int k){
	       if(node!=null && count<k){
	           if(node.left!= null) find(node.left,k);
	           count++;
	           if(count==k){
	               this.result = node;
	               return;
	           }
	             
	           if(node.right!=null) find(node.right,k);
	       }   
	     }
	 }
	 
	 
	 /**
	  * this is the officical solution
	  * @author partha
	  *
	  */
	 private static class Solution3 {
		  public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
		    if (root == null) return arr;
		    inorder(root.left, arr);
		    arr.add(root.val);
		    inorder(root.right, arr);
		    return arr;
		  }

		  public int kthSmallest(TreeNode root, int k) {
		    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
		    return nums.get(k - 1);
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
