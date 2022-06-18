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
		int result = 0;

		public int longestConsecutive(Node root)
		{
			if(root==null)
				return -1;
			calculate(root,0,root.data);
			return result>1 ? result : -1;
		}

		private void calculate(Node node, int currentLength,int expectedValue){
			if(node.data==expectedValue){
				currentLength++;
				result = Math.max(result,currentLength);
			}
			if(node.data!=expectedValue){
				currentLength = 1;
			}
			if(node.left != null)
				calculate(node.left , currentLength , node.data +1);

			if(node.right!= null)
				calculate(node.right , currentLength , node.data + 1);
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
