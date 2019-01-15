package com.partha.ds01.tree.binaryTree01;

/**
 * this program shows how to implement a binary tree in java
 * @author partha
 *
 */
public class BinarySearchTreeImplementation {

	public static void main(String[] args) {

	}

}

class BinarySearchTree{
	
	public TreeNode root;
	
	public TreeNode find(int data){
		if(this.root!=null)
			return root.find(data);
		else
			return null;
	}
	
	
	public void insert(int data){
		if(root == null)
			this.root = new TreeNode(data);
		else root.insert(data);
	}
	
	public void delete(int data){
		TreeNode current = this.root;
		TreeNode parent = this.root;
		//the below is to keep a track of which way the current node went
		boolean isLeftChild = false;
		
		if(current == null)
			return ;
		
		while( current != null && current.getData() != data){
			parent = current;
			if(data < current.getData()){
				current = current.getLeftChild();
				isLeftChild = true;
			}else{
				current = current.getRightChild();
				isLeftChild = false;
			}			
		}
		if( current == null)
			return;
		if(current.getLeftChild() == null && )
		
		
		
	}
		
}

class TreeNode{
	
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	/** utility methods start here  **/
	
	//using a recursive approach
	public TreeNode find(int data){
		if(this.getData()==data){
			return this;
		}else if(data < this.getData() && this.getLeftChild()!=null){
			return  this.leftChild.find(data);
		}else if(this.getRightChild()!=null){
			return this.rightChild.find(data);	
		}
		return null;
	}
	
	//using a recursive approach
	public void insert(int data){
		if(data >= this.data){
			if(this.rightChild == null)
				this.rightChild = new TreeNode(data);
			else
				this.rightChild.insert(data);
		}else{
			if(this.leftChild == null)
				this.leftChild = new TreeNode(data);
			else
				this.leftChild.insert(data);
		}
	}
	
	/** utility methods end here  **/
	
	//defining the constructor
	public TreeNode(int data){
		super();
		this.data=data;
	}
	
	//defining necessary getters and setters
	public int getData() {
		return data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	
	
	
}
