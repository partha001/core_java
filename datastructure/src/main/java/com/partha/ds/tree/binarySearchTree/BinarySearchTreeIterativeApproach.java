package com.partha.ds.tree.binarySearchTree;

public class BinarySearchTreeIterativeApproach {

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(50); 
//		tree.insert(30); 
//		tree.insert(20); 
//		tree.insert(40); 
//		tree.insert(70); 
//		tree.insert(60); 
//		tree.insert(80); 
		tree.delete(50);
		//System.out.println(tree.delete(50););
		System.out.println(tree.search(21));
	}
	
	public static class BST{
		Node root;
		
		public void insert(int value){
			Node node = new Node(value);		
			if(this.root==null){	
				this.root = node;
			}else{
				Node parent = null;
				Node current = this.root;
				while(current!=null){
					parent = current;
					if(current.value<=value){
						current = current.right;
					}else{
						current = current.left;
					}
				}
				
				if(parent.value <= value){
					parent.right = node;
				}else {
					parent.left = node ;
				}
			}
		}
		
		
		public boolean search(int data){
			boolean flag = false;
			Node current = this.root;
			while(current!=null){
				if(current.value==data)
					return true;
				else if(current.value<data)
					current = current.right;
				else
					current =  current.left;
			}
			return flag;
		}
		
		
		public void delete(int data){
			
			Node parent = null;
			Node current = this.root;
			while(current!=null){
				if(current.value==data && current.left==null && current.right==null)
					current = null;
			}
		}
	}
	
	
	public static class Node{
		int value;
		Node right;
		Node left;
		
		public Node(int value) {
			super();
			this.value = value;
		}
		
		
	}

}
