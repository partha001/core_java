package com.partha.problemSolving.leetcode;

/**
 * https://practice.geeksforgeeks.org/problems/longest-consecutive-sequence-in-binary-tree/1#
 * @author partha
 *
 */
public class LongestConsecutiveSequenceInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class GfG
	{   
	    int max = 0;
	    
	    public void path(Node root, int count, int data){
	        
	        if(root == null){
	            return;
	        }
	        
	        if(root.data == data){
	            count++;
	            if(count >= max){
	                max = count;
	            }
	        }
	        
	        if(root.data!=data){
	            count = 1;
	        }
	        
	        path(root.left, count, root.data + 1);
	        path(root.right, count, root.data + 1);
	        
	    }
		public int longestConsecutive(Node root)
	        {
	          if(root == null){
	              return -1;
	          }
	          
	          int count = 0;
	          
	          path(root, count, root.data);
	          
	          if(max>1){
	              return max;
	          }
	          else
	          return -1;
	        }
	}
	
	
	private static class Node
	{
	    int data;
	    Node left, right;
	    public Node(int data)
	    {
	        this.data = data;
	        left = right = null;
	    }
	}

}
