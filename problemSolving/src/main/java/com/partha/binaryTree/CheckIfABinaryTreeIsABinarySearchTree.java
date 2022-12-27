package com.partha.binaryTree;


/**
 * @author parbiswa
 *
 */
public class CheckIfABinaryTreeIsABinarySearchTree {

	public static void main(String[] args) {
		BST tree1 = new BST(); 

		/* Let us create following BST 
	              50 
	           /     \ 
	          30      70 
	         /  \    /  \ 
	        20   40  60   80 */
		tree1.root = new Node(30);
		tree1.root.leftChild = new Node(20);
		tree1.root.rightChild = new Node(70);
		tree1.root.leftChild.rightChild = new Node(35);
		
		System.out.println(checkIfBST(tree1.root));

	}
	
	
	public static boolean checkIfBST(Node node){
		return checkIfBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static boolean checkIfBST(Node node , int min, int max ){
		if(node==null){
			return true;
		}else{
			if(node.value<min || node.value > max){
				return false;
			}else{
				return checkIfBST(node.leftChild,min,node.value) && checkIfBST(node.rightChild, node.value, max);
			}
		}
	}
	
	public static int getHeight(Node node){
		if(node==null)
			return 0;
		else {
			int leftSubTreeHeight = getHeight( node.leftChild);
			int rightSubTreeHeight = getHeight( node.rightChild);
			int maxSubTreeHeight = leftSubTreeHeight>=rightSubTreeHeight ? leftSubTreeHeight :rightSubTreeHeight;
			return  maxSubTreeHeight + 1 ;
		}
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


		public void preorderTraversal(){
			preorderTraversal(this.root);
		}

		private void preorderTraversal(Node node) 
		{ 
			if (node != null) {
				System.out.print(node.value + " "); 
				preorderTraversal(node.leftChild); 
				preorderTraversal(node.rightChild); 
			}	
		} 

		/** code for postorder traversal start here **/
		public void postorderTraversal(){
			postorderTraversal(this.root);
		}

		void postorderTraversal(Node node) 
		{ 
			if (node != null) {
				// first recur on left subtree 
				postorderTraversal(node.leftChild); 

				// then recur on right subtree 
				postorderTraversal(node.rightChild); 

				// now deal with the node 
				System.out.print(node.value + " "); 
			}
			
		}
		/** code for postorder traversal end here **/



		//gives min value under any given node
		int minValue(Node root) 
		{ 
			int minv = root.value; 
			while (root.leftChild != null) 
			{ 
				minv = root.leftChild.value; 
				root = root.leftChild; 
			} 
			return minv; 
		} 

		// This method mainly calls deleteRec() 
		public 	void deleteKey(int key) 
		{ 
			root = deleteRec(root, key); 
		} 


		/* A recursive function to insert a new key in BST */
		private Node deleteRec(Node root, int key) 
		{ 
			/* Base Case: If the tree is empty */
			if (root == null)  return root; 

			/* Otherwise, recur down the tree */
			if (key < root.value) 
				root.leftChild = deleteRec(root.leftChild, key); 
			else if (key > root.value) 
				root.rightChild = deleteRec(root.rightChild, key); 

			// if key is same as root's key, then This is the node 
			// to be deleted 
			else
			{ 
				// node with only one child or no child 
				if (root.leftChild == null) 
					return root.rightChild; 
				else if (root.rightChild == null) 
					return root.leftChild; 

				// node with two children: Get the inorder successor (smallest 
				// in the right subtree) 
				root.value = minValue(root.rightChild); 

				// Delete the inorder successor 
				root.rightChild = deleteRec(root.rightChild, root.value); 
			} 

			return root; 
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
