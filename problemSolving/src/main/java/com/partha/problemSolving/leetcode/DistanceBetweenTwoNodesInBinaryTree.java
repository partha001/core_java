package com.partha.problemSolving.leetcode;


/**
 * https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
 * @author partha
 *
 */
public class DistanceBetweenTwoNodesInBinaryTree {

	public static void main(String[] args) {
		
	}
	
	class GfG {
	    int height1 = 0; int height2 = 0;
	    
	    Node LCA(Node root, int a, int b){
	        if(root == null){  // base case 
	            return null;
	        }
	        if(root.data == a || root.data == b){
	            return root;
	        }
	        Node left = LCA(root.left, a, b);
	        Node right = LCA(root.right, a, b);
	        
	        if(left!=null && right!=null){
	            return root;
	        }
	        else if(left!=null && right == null){
	            return left;
	        }
	        else if(left==null && right!=null){
	            return right;
	        }
	        else
	        return null;
	    }
	    
	    void search_node(Node root, int a, int b, int level){
	        if(root == null){
	            return;
	        }
	        
	        if(root.data == a){
	            height1 = level;
	        }
	        if(root.data == b){
	            height2 = level;
	        }
	        
	        search_node(root.left, a, b, level+1);
	        search_node(root.right, a, b, level+1);
	    }
	    
	    int findDist(Node root, int a, int b) {
	        // Your code here
	        Node lca = LCA(root, a, b);
	       // System.out.print(lca.data);
	       
	       search_node(lca, a, b, 0);
	       
	       return height1 + height2;
	    }
	}
	    
	    
	    private static class Node
	    {
	         Node left, right;
	         int data;
	     
	        // constructor 
	         Node(int data)
	        {
	            this.data = data;
	            left = null;
	            right = null;
	        }
	    }

}
