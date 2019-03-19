package com.partha.ds.tree.binaryTree01;

/**
 * this program shows how to implement a binary tree in java
 * @author partha
 *
 */
public class BinarySearchTreeExample1 {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(100);
		tree.insert(200);
		tree.insert(150);
		tree.insert(300);
		tree.insert(10);
		TreeNode subTreeMin = tree.getSubTreeMinimum(150);
		System.out.println(subTreeMin==null ? null : subTreeMin.getData());
		//tree.printInorder();
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

	public Integer smallest(){
		if(this.root != null)
			return root.smallest();
		return null;
	}

	public Integer largest(){
		if(this.root != null)
			return root.largest();
		return null;
	}

	/**
	 * this method is incomplete for the last case.
	 * @param data
	 */
	public void delete(int data){
		TreeNode current = this.root;
		TreeNode parent = this.root;
		//the below is to keep a track of which way the current node went
		boolean isLeftChild = false;

		if(current == null)
			return ;

		//here we are first identifying the node to be deleted
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
			return; // means the data is not found in the tree
		//performing the delete for case1
		//i.e. when the node to be deleted has no child node
		if(current.getLeftChild() == null && current.getRightChild() == null){
			if(current == root){
				root = null;
			}else {
				if(isLeftChild)
					parent.setRightChild(null);
				else
					parent.setRightChild(null);
			}
		}
		//performing delete for case2
		//i.e. when the node to be delete has one child node
		else if(current.getRightChild() == null){
			if(current == root){
				root = current.getLeftChild();
			}else if (isLeftChild){
				parent.setLeftChild(current.getLeftChild());
			}else {
				parent.setRightChild(current.getLeftChild());
			}
		}
		else if(current.getLeftChild() == null){
			if(current == root){
				root = current.getRightChild();
			}else if (isLeftChild){
				parent.setLeftChild(current.getRightChild());
			}else {
				parent.setRightChild(current.getRightChild());
			}
		}
		
		//deletion for case3 i.e. the node to be deleted has both the children
		else if (current.getRightChild()!=null && current.getLeftChild()!=null){
			//finding its inoder successor node 
			TreeNode successor = getSubTreeMinimum(current.getData());
			
			//store the successor value
			int val = successor.getData();
			
			//recursively delete the successor 
			delete(val);
			
			//copy the value of successor to current node
			//current.
			
			
			
		}
		
		
	}
	
	
	//minimum sub tree element
	/**
	 * returns null if there is no element in the subtree which is smaller than data
	 * @param data
	 * @return
	 */
	public TreeNode getSubTreeMinimum(int data){
		//first searching for the given value 
		TreeNode current = find(data);
		TreeNode result= (current ==null ? null : current.minimumKey());	
		return (result==null || result.getData()==data ? null : result);
	}



	/** methods for inorder traveral start here**/
	//this is the wrapper method will be called
	void printInorder(){     
		printInorder(root);  
	} 

	private void printInorder(TreeNode node) 
	{ 
		if (node == null) 
			return; 

		/* first recur on left child */
		printInorder(node.getLeftChild()); 

		/* then print the data of node */
		System.out.print(node.getData() + " "); 

		/* now recur on right child */
		printInorder(node.getRightChild()); 
	} 
	/** methods for inorder traveral end here**/


	/** code for preorder traversal start here **/
	//this is the wrapper method
	void printPreorder(){
		printInorder(this.root);
	}

	private void printPreorder(TreeNode node) 
	{ 
		if (node == null) 
			return; 

		/* first print data of node */
		System.out.print(node.getData() + " "); 

		/* then recur on left sutree */
		printPreorder(node.getLeftChild()); 

		/* now recur on right subtree */
		printPreorder(node.getRightChild()); 
	} 
	/** code for preorder traversal end here **/


	/** code for postorder traversal start here **/
	//this is the wrapper method 
	public void printPostorder(){
		printPostorder(this.root);
	}

	void printPostorder(TreeNode node) 
	{ 
		if (node == null) 
			return; 

		// first recur on left subtree 
		printPostorder(node.getLeftChild()); 

		// then recur on right subtree 
		printPostorder(node.getRightChild()); 

		// now deal with the node 
		System.out.print(node.getData() + " "); 
	}
	/** code for postorder traversal end here **/
	
	
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

	public int smallest(){
		if(this.leftChild == null)
			return this.data;
		return this.leftChild.smallest();
	}

	public int largest(){
		if(this.rightChild == null)
			return this.rightChild.getData();
		return this.rightChild.smallest();
	}
	
	
	//helper function to find the minimum value node in a subtree rooted at current node
	public TreeNode minimumKey(){
		if(this.getLeftChild()!=null)
			return this.leftChild.minimumKey();
		return this;
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
