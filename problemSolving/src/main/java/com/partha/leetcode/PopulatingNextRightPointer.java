package com.partha.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * @author biswaspa
 *
 */
public class PopulatingNextRightPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	/**
	 * My solution. level order traversal based
	 * @author biswaspa
	 *
	 */
	private static class Solution {
		
	    public Node connect(Node root) {
	        if(root==null)
	            return null;
	        Queue<Node> queue = new LinkedList();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            int length = queue.size();
	            for(int i=0;i<length;i++){
	                Node temp = queue.remove();
	                if(temp.left!=null)
	                    queue.add(temp.left);
	                
	                if(temp.right!=null)
	                    queue.add(temp.right);
	                
	                if(i==length-1){
	                    temp.next = null;
	                }else{
	                    temp.next = queue.peek();
	                }
	                   
	            }
	        }
	        return root;
	    }
	}
	
	
	private static class Solution2 {
	    
	    public Node connect(Node root) {   
	        if(root == null || root.left == null && root.right == null){
	            return root;
	        }        
	        connect_level(root);        
	        return root;
	    }
	    
	    private void connect_level(Node root){	        
	        if(root == null){
	            return;
	        }	        
	        if(root.left!=null && root.right!=null){
	            root.left.next = root.right;
	        }     
	        if(root.right!=null && root.next!=null && root.next.left!=null){
	          root.right.next = root.next.left;
	        }   
	        connect_level(root.left);
	        connect_level(root.right);
	    }
	    
	    
	}
	
	
	private static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};

}
