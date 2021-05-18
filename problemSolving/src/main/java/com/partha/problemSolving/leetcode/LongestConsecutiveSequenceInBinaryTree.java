package com.partha.problemSolving.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://practice.geeksforgeeks.org/problems/longest-consecutive-sequence-in-binary-tree/1#
 * note : it is to be noted that the consecutive path can start from any node [i.e. not just root node]
 * @author partha
 *
 */
public class LongestConsecutiveSequenceInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//uses recursion on every Node
	private static class GfG
	{   
	    int max = 0;
	    
	    public void path(Node root, int count, int data){
	        
	        if(root == null){
	            return;
	        }
	        
	        if(root.data == data){
	            count++;
	            max = Math.max(count, max);
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
	
	
	//using level order traversal
	private static class Solution2
	{
		int length=0;
		public int longestConsecutive(Node root)
		{
			if(root==null)
				return length;
			// findLength(root,root.data,0); 
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()){
				Node currentNode = queue.poll();
				findLength(currentNode,currentNode.data,0);
				if(currentNode.left!=null)
					queue.add(currentNode.left);

				if(currentNode.right!=null)
					queue.add(currentNode.right);
			}
			return this.length<2?-1:this.length;
		}

		private void findLength(Node node,int expectedVal,int currentLength){
			if(node.data==expectedVal){
				length = Math.max(this.length, currentLength+1);

				if(node.left!=null)
					findLength(node.left , node.data+1, currentLength+1);

				if(node.right!=null)
					findLength(node.right , node.data+1, currentLength+1);
			}
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
