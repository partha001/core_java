package com.partha.ds.tree.binaryTree01.practice;

public class BinarySearchTreeExample1 {
	
	public static void main(String[] args){
		
	}
	
	
	class BinarySearchTree{
		Node root;
		
		BinarySearchTree(){
			super();
		}
		
		BinarySearchTree(Node node){
			super();
			this.root=node;
		}
		
	}
	
	
	 class Node{
		 
		 int data;
		 Node leftChild;
		 Node rightChild;
		 
		public Node(int data) {
			super();
			this.data = data;
		}
		
	 }

}

