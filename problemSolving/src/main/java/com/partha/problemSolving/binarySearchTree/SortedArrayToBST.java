package com.partha.problemSolving.binarySearchTree;


/**
 * referred from : https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 */

public class SortedArrayToBST {


	public static void main(String[] args){

		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7}; 
		int n = arr.length; 
		BST tree = new  BST(sortedArrayToBST(arr, 0, n - 1)); 
		tree.inorderTraversal();
	}

	/* A function that constructs Balanced Binary Search Tree from a sorted array */
	static  Node sortedArrayToBST(int arr[], int start, int end) { 

		/* Base Case */
		if (start > end) { 
			return null; 
		} 

		/* Get the middle element and make it root */
		int mid = (start + end) / 2; 
		Node node = new Node(arr[mid]); 

		/* Recursively construct the left subtree and make it left child of root */
		node.leftChild = sortedArrayToBST(arr, start, mid - 1); 

		/* Recursively construct the right subtree and make it right child of root */
		node.rightChild = sortedArrayToBST(arr, mid + 1, end); 

		return node; 
	} 



	public static class BST{

		public Node root;

		public BST() {
			super();
		}


		public BST(Node root) {
			super();
			this.root = root;
		}


		// This method mainly calls InorderRec() 
		public void inorderTraversal() 
		{ 
			inorderTraversal(this.root); 
		}


		private void inorderTraversal(Node root) 
		{ 
			if (root != null) 
			{ 
				inorderTraversal(root.leftChild); 
				System.out.print(root.value + " "); 
				inorderTraversal(root.rightChild); 
			} 
		} 


	}


	public static class Node{

		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value) {
			super();
			this.value = value;
		}

	}

}
/*
1) Get the Middle of the array and make it root.
2) Recursively do same for left half and right half.
      a) Get the middle of left half and make it left child of the root
          created in step 1.
      b) Get the middle of right half and make it right child of the
          root created in step 1.
*/