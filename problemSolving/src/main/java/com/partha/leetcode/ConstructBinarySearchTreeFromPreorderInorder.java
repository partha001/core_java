package com.partha.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * @author biswaspa
 *
 */
public class ConstructBinarySearchTreeFromPreorderInorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Time Complexity: O(n^2). Worst case occurs when tree is left skewed. Example Preorder and Inorder traversals for worst case are {A, B, C, D} and {D, C, B, A}. 
	 * @author biswaspa
	 *
	 */
	public static class Solution1{
		int preindex=0;
	    public TreeNode buildTree(int[] preorder, int[] inorder) 
	    {
	        return buildtreehelper(preorder,inorder,0,preorder.length-1);
	        
	    }
	    
	    public TreeNode buildtreehelper(int[] preorder,int[] inorder,int start,int end)
	    {
	        if(start>end)
	        {
	            return null;
	        }
	        int key=preorder[preindex];
	        preindex++;
	        TreeNode root=new TreeNode(key);
	        
	        int isearch=search(inorder,start,end,root.val);
	        
	        root.left=buildtreehelper(preorder,inorder,start,isearch-1);
	        root.right=buildtreehelper(preorder,inorder,isearch+1,end);
	        return root;
	    }
	    
	    public int search(int[] arr,int start,int end,int k)
	    {
	        for(int i=start;i<=end;i++)
	        {
	            if(arr[i]==k)
	            {
	                return i;
	            }
	        }
	        return -1;
	    }
	}
	
	
	//using hashmap and without queue
	static class Solution2 {
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        Map<Integer,Integer> in = new HashMap<>();
	        for(int i=0;i<inorder.length;i++) in.put(inorder[i],i);
	        return buildTree(preorder,in,0,inorder.length-1,0);
	    }
	    
	    TreeNode buildTree(int[]pre,Map<Integer,Integer> in, int start, int end, int preIndx){
	        if(preIndx >= pre.length /*when the list is empty*/|| start > end) return null;
	        TreeNode node = new TreeNode(pre[preIndx],null,null);
	        if(start == end) return node;
	        int mid = in.get(pre[preIndx]);
	        node.left = buildTree(pre,in,start,mid-1,preIndx+1);
	        node.right = buildTree(pre,in,mid+1,end,preIndx+mid-start+1);
	        return node;
	    }
	}
	
	
	//using hashmap and with Queue
	static class Solution3 {
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        Map<Integer,Integer> in = new HashMap<>();
	        for(int i=0;i<inorder.length;i++) in.put(inorder[i],i);
	        Queue<Integer> pre = new LinkedList<>();
	        for(int val : preorder) pre.offer(val);
	        return buildTree(pre,in,0,inorder.length-1);
	    }
	    
	    TreeNode buildTree(Queue<Integer> pre, Map<Integer,Integer> in, int start, int end){
	        if(pre.size() == 0 || start > end) return null;
	        int preval = pre.poll();
	        TreeNode node = new TreeNode(preval,null,null);
	        if(start == end) return node;
	        int mid = in.get(preval);
	        node.left = buildTree(pre,in,start,mid-1);
	        node.right = buildTree(pre,in,mid+1,end);
	        return node;
	    }
	}
	
	
	public static class TreeNode {
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
