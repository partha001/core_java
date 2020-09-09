package com.partha.problemSolving.binarySearchTree;

/**
 * https://practice.geeksforgeeks.org/problems/sum-tree/1
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 * @author biswaspa
 *
 */
public class SumTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static class Node
	{
	    int data;
	    Node left, right;

	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	/**
	 * useful link : https://www.youtube.com/watch?v=zEIWqb8nWDk
	 * @author biswaspa
	 *
	 */
	static class Solution1
	{
		boolean isSumTree(Node node)
		{
	         if(node==null){ //if root is null
	             return true;
	         }else if(node.left==null && node.right==null){ //for leaf node
	             return true;
	         }else{ //check if it satisfies sumtree
	             int leftSum = sum(node.left);
	             int rightSum = sum(node.right);
	             int total = leftSum + rightSum;
	             if(total == node.data){
	                 return isSumTree(node.left) && isSumTree(node.right); //check for sumtree for below nodes
	             }else{
	                 return false;
	             }
	             
	         }
		}
		
		private int sum(Node node){
		    if(node==null){
		        return 0;
		    }else{
		        int leftSum = sum(node.left);
		        int rightSum = sum(node.right);
		        return leftSum + rightSum + node.data;
		    }
		}
		
	}
	
	
	/**
	 * O(n)
	 */
	static class Solution2{
		boolean isSumTree(Node node){
			int ls; // for sum of nodes in left subtree 
			int rs; // for sum of nodes in right subtree 

			/* If node is NULL or it's a leaf node then 
		         return true */
			if (node == null || isLeaf(node) == true) 
				return true; 

			if (isSumTree(node.left)==true && isSumTree(node.right)==true)  
			{
				// Get the sum of nodes in left subtree 
				if (node.left == null) 
					ls = 0; 
				else if (isLeaf(node.left)==true) 
					ls = node.left.data; 
				else
					ls = 2 * (node.left.data); 

				// Get the sum of nodes in right subtree 
				if (node.right == null) 
					rs = 0; 
				else if (isLeaf(node.right)==true) 
					rs = node.right.data; 
				else
					rs = 2 * (node.right.data); 

				/* If root's data is equal to sum of nodes in left 
		               and right subtrees then return 1 else return 0*/
				if ((node.data == rs + ls)) 
					return true; 
				else
					return false; 
			} 

			return false; 
		}
		
		
		boolean isLeaf(Node node) {
			if(node==null) {
				//return false; //in gfg
				return true;	//my preferrence
			}else if(node.left==null && node.right==null) {
				return true;
			}else
				return false;
		}
				
	}

}
