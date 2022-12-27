package com.partha.leetcode;

/**
 * link : https://leetcode.com/problems/symmetric-tree/
 * @author biswaspa
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		//System.out.println(new Solution1().maxProfit(new int[] {7,1,5,3,6,4}));
		
		//new Solution2().maxProfit(new int[] {});

	}
	

	 //* Definition for a binary tree node.
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
	 
	  /**
	   * working solution submitted on leetcode
	   * @author biswaspa
	   *
	   */
	class Solution1 {
	    public boolean isSymmetric(TreeNode root) {
	        return checkIfSymmetric(root , root);
	    }
	    
	    private boolean checkIfSymmetric(TreeNode node1 , TreeNode node2){
	        if(node1==null && node2==null){
	            return true;
	        }
	        else if( (node1==null && node2!=null)  || (node2==null && node1!=null) ){
	            return false;
	        }
	        else if(node1.val != node2.val){
	            return false;
	        }else {
	            boolean flag1 = checkIfSymmetric(node1.left,node2.right);
	            boolean flag2 = checkIfSymmetric(node1.right,node2.left);
	            return (flag1 && flag2);
	        }
	    }
	}
		
	
}
