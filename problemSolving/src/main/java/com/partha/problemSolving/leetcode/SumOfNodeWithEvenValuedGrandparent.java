package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author biswaspa
 *
 */
public class SumOfNodeWithEvenValuedGrandparent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * my solution based on level order traversal
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
	    	    
	    public int sumEvenGrandparent(TreeNode root) {
	        int sum=0;
	        if(root==null)
	            return sum;
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            TreeNode current = queue.remove();
	            if(current.val%2==0){
	                List<TreeNode> list = findCandidates(current,1,new ArrayList<TreeNode>());
	                for(TreeNode node:list){
	                    sum+=node.val;
	                }
	            }
	            	            
	            if(current.left!=null)
	                queue.add(current.left);
	            
	            if(current.right!=null)
	                queue.add(current.right);
	        }
	        
	        return sum;
	    }
	    
	    
	    private List<TreeNode> findCandidates(TreeNode node,int level,ArrayList<TreeNode> result){
	        if(node==null)
	            return result;
	        if(level==3){
	           result.add(node);
	           return result;
	       }
	        findCandidates(node.left,level+1,result);
	        findCandidates(node.right,level+1,result);
	        return result;
	        
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
