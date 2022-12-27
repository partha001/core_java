package com.partha.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * given a binary tree and a number find if there is any root to leaf path exists 
 * or not whose sum is equal to the given number
 * @author parbiswa
 * @refer : https://www.youtube.com/watch?v=Jg4E4KZstFE
 *
 */
public class RootToLeafSumOfBinaryTree {

	public static void main(String[] args) {
		BST tree1 = new BST(); 

		/* Let us create following BST 
	              50 
	           /     \ 
	          30      70 
	         /  \    /  \ 
	        20   40  60   80 */
		tree1.insert(50); 
		tree1.insert(30); 
		tree1.insert(20); 
		tree1.insert(40); 
		tree1.insert(70); 
		tree1.insert(60); 
		tree1.insert(80);
		tree1.insert(90);
		tree1.inorderTraversal();

		System.out.println(rootToLeafSum(tree1.root,101));



	}

	public static boolean rootToLeafSum(Node node, int sum){
		return rootToLeafSum(node, sum, new ArrayList<Integer>());
	}

	public static boolean rootToLeafSum(Node node, int sum,List<Integer> result){
		if(node==null)
			return false;
		if(node.leftChild==null && node.rightChild==null) //leaf node{
		{
			if(node.value == sum){
				result.add(node.value);
				return true;
			}else{
				return false;

			}
		}
		if(rootToLeafSum(node.leftChild, sum-node.value,result)){
			result.add(node.value);
			return true;
		}
		if(rootToLeafSum(node.rightChild, sum-node.value,result)){
			result.add(node.value);
			return true;
		}
		return false;
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

			//node insertion
			public void insert(int data){
				this.root = insert(data, this.root);				
			}


			private Node insert(int value, Node node){
				if(node==null){
					node = new Node(value);
					return node;
				}

				if(value > node.value)
					node.rightChild = insert(value,node.rightChild);
				else if(value < node.value)
					node.leftChild = insert(value,node.leftChild);

				return node;
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
