package com.partha.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * @author biswaspa
 *
 */
public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		node.right = new TreeNode(2);
		node.left = new TreeNode(3);
		System.out.println(new Solution2().rightSideView(node));

	}
	
	private static class Solution1{

		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> result= new ArrayList<Integer>();
			if(root==null)
				return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				
				int nodeCountAtLevel = queue.size();
				for(int i=0;i<nodeCountAtLevel;i++) {
					TreeNode current = queue.poll();
					if(current.left!=null)
						queue.add(current.left);
					
					if(current.right!=null)
						queue.add(current.right);
					
					if(i==nodeCountAtLevel-1) {
						result.add(current.val);
					}
				}			
			}
			return result;
		}

	}
	
	
	/**
	 * timeComplexity: O(n) Time  spaceComplexity:O(1)
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {
	    List<Integer> rightside = new ArrayList();
	    
	    public void helper(TreeNode node, int level) {
	        if (level == rightside.size()) 
	            rightside.add(node.val);
	        
	        if (node.right != null) 
	            helper(node.right, level + 1);  
	        if (node.left != null) 
	            helper(node.left, level + 1);
	    }    
	    
	    public List<Integer> rightSideView(TreeNode root) {
	        if (root == null) return rightside;
	        
	        helper(root, 0);
	        return rightside;
	    }
	}
	
	
	
	
	
	private static  class TreeNode {
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
