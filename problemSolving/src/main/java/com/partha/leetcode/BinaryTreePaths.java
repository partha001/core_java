package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths
 * @author partha
 *
 */
public class BinaryTreePaths {
	
	public static void main(String[] args) {
		
	}
	
	
	
	private static class Solution {
	    List<String> result;
	    
	    public List<String> binaryTreePaths(TreeNode root) {
	        result = new ArrayList<String>();
	        generateList(root, "");
	        return result;
	    }
	    
	    
	    public void generateList(TreeNode node,String current){
	        if(node==null)
	            return;
	        if(node.left==null && node.right==null){
	            current = current + node.val;
	            result.add(current);
	            return;
	        }
	        current = current + node.val + "->";
	        if(node.left!=null)
	            generateList(node.left,current);
	        
	        if(node.right!=null)
	            generateList(node.right,current);
	            
	            
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
