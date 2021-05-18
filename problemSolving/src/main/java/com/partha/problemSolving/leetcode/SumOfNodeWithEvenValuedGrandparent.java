package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * @author biswaspa
 *
 */
public class SumOfNodeWithEvenValuedGrandparent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * my solution based on level order traversal
	 * this is the best solution since question can be for any level [it can be even grand-grand childern]
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
	
	
	//solution using recursion
	private static class Solution2 {
	    
	    int sum = 0;
	    public int sumEvenGrandparent(TreeNode root) {
	        if(root == null){
	            return 0;
	        }
	        path(root);
	        return sum;
	    }
	    
	    private void path(TreeNode root){
	        if(root == null){
	            return;
	        }
	        
	        if(root.val % 2 == 0){
	            if(root.left!=null && root.left.left!=null){
	                sum = sum + root.left.left.val;
	            }
	            if(root.left!=null && root.left.right!=null){
	                sum = sum + root.left.right.val;
	            }
	            if(root.right!=null && root.right.left!=null){
	                sum = sum + root.right.left.val;
	            }
	            if(root.right!=null && root.right.right!=null){
	                sum = sum + root.right.right.val;
	            }
	        }
	        path(root.left);
	        path(root.right);
	    }
	    

	}
	
	
	//using level order traversal
	private static class Solution3 {
	    
	    int result =0;
	    
	    public int sumEvenGrandparent(TreeNode root) {
	        if(root==null)
	            return result;
	        Queue<TreeNode> queue = new LinkedList();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            TreeNode current = queue.poll();
	            calculate(current);
	            if(current.left!=null  )
	                queue.add(current.left);
	            if(current.right!=null)
	                queue.add(current.right);
	        }
	        return result;
	    }
	    
	    public void calculate(TreeNode node){
	        // if(node.val%2!=0)
	        //     return;
	        if(node.left!=null){
	            if(node.left.left!=null)
	                result+=node.left.left.val;
	            if(node.left.right!=null)
	                result+=node.left.right.val;
	        }
	        if(node.right!=null){
	            if(node.right.left!=null)
	                result+=node.right.left.val;
	            if(node.right.right!=null)
	                result+=node.right.right.val;
	        }
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
