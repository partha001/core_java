package com.partha.problemSolving.leetcode;

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
	    
        int level = 0;
	    List<Integer> list = new ArrayList<>();
	    
	    public List<Integer> rightSideView(TreeNode root) {	     
	        if(root == null)
	            return list;      //Time O(n) and space O(1)
	        
	        int count = 1;	        
	        populateList(root, count);
	        return list;
	    }
	    
	    private void populateList(TreeNode root, int count){
	        
	        if(root == null){
	            return;
	        }
	        
	        if(count > level){  // case when level is greater than Index 
	            level = count;
	            list.add(root.val);
	        }
	        
	        if(root.right!=null) populateList(root.right, count+1);
	        if(root.left!=null)  populateList(root.left, count+1);
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
