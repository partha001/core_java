package com.partha.hr.tree;

public class SwappingTree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.left = new Node(70);
	}
	
	
	
	public static class Tree{
		Node root;
	}
	
	public static class Node {
		int data ;
		Node left;
		Node right;
		public Node(int data) {
			super();
			this.data = data;
		}	
	}

}
