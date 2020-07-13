package com.partha.ds.tree.binarySearchTree;

import java.util.Stack;

public class BinarySearchTreeIterativeApproach {

	public static void main(String[] args) {
		
		/******** Let us create following BST 
		        50 
		     /     \ 
		    30      70 
		   /  \    /  \ 
		  20   40  60   80 
		*************************************/
		
		BST tree = new BST();
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		//tree.insert(10); 
		tree.insert(40); 
		tree.insert(70); 
//		tree.insert(60); 
		tree.insert(80); 
		//tree.insert(78); 
		//tree.insert(79); 
//		tree.insert(55); 
//    	tree.insert(65);
//		tree.insert(90);
		tree.delete(50);
		
		//tree.preOrderTraversal();
		tree.inOrderTraversal();
		//tree.postOrderTraversal();
		//System.out.println(tree.delete(20));
		//System.out.println(tree.delete(10));
		//System.out.println(tree.search(50));
	}

	public static class BST{
		Node root;
		
		public void preOrderTraversal(){
			if(this.root==null)
				return ;
			else {
				Stack<Node> stack = new Stack<Node>();
				stack.push(this.root);
				Node current;
				while(!stack.isEmpty()){
					current = stack.pop();
					System.out.print(current.value+ " ");
					
					if(current.right!=null){
						stack.push(current.right);
					}
					if(current.left!=null){
						stack.push(current.left);
					}
				}
			}
		}
		
		public void inOrderTraversal() 
	    { 
	        if (this.root == null) 
	            return; 
	  
	  
	        Stack<Node> s = new Stack<Node>(); 
	        Node curr = root;
	  
	        // traverse the tree 
	        while (curr != null || s.size() > 0) 
	        { 
	  
	            /* Reach the left most Node of the curr Node */
	            while (curr !=  null) 
	            { 
	                /* place pointer to a tree node on the stack before 
	                 * traversing the node's left subtree */
	                s.push(curr); 
	                curr = curr.left;
	            } 
	  
	            /* Current must be NULL at this point */
	            curr = s.pop(); 
	  
	            System.out.print(curr.value + " "); 
	  
	            /* we have visited the node and its left subtree. 
	             *  Now, it's right subtree's turn */
	            curr = curr.right; 
	        } 
	    } 
		
		public void postOrderTraversal()  
	    { 
			Node node = this.root;
	        Stack<Node> S = new Stack<Node>(); 
	           
	        // Check for empty tree 
	        if (node == null) 
	            return ; 
	        S.push(node); 
	        Node prev = null; 
	        while (!S.isEmpty())  
	        { 
	            Node current = S.peek(); 
	   
	            /* go down the tree in search of a leaf an if so process it  
	            and pop stack otherwise move down */
	            if (prev == null || prev.left == current ||  
	                                        prev.right == current)  
	            { 
	                if (current.left != null) 
	                    S.push(current.left); 
	                else if (current.right != null) 
	                    S.push(current.right); 
	                else
	                { 
	                    S.pop(); 
	                    System.out.print(current.value+" ");
	                } 
	   
	                /* go up the tree from left node, if the child is right  
	                   push it onto stack otherwise process parent and pop  
	                   stack */
	            }  
	            else if (current.left == prev)  
	            { 
	                if (current.right != null) 
	                    S.push(current.right); 
	                else 
	                { 
	                    S.pop(); 
	                    System.out.print(current.value + " ");
	                } 
	                   
	                /* go up the tree from right node and after coming back 
	                 from right node process parent and pop stack */
	            }  
	            else if (current.right == prev)  
	            { 
	                S.pop(); 
	                System.out.print(current.value+ " ");
	               // list.add(current.data); 
	            } 
	   
	            prev = current; 
	        } 
	   
	
	    } 
		
		
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


		/**
		 * @param data
		 * @return Node which contains the value to be searched else returns null
		 */
		public Node search(int data){
			Node current = this.root;
			while(current!=null){
				if(current.value==data)
					return current;
				else if(current.value<data)
					current = current.right;
				else
					current =  current.left;
			}
			return null;
		}


		/**
		 * @param data
		 * @return returns true if data is found and deleted else returns false
		 */
		public boolean delete(int data){

			Node parent = null;
			Node current = this.root;
			boolean isLeftChild = true;
			boolean found = false;

			//first searching the node to be deleted and populating the above values
			while(current!=null){
				if(current.value<data){
					parent = current;
					current = current.right;
					isLeftChild = false;
				}
				else if(current.value > data){
					parent = current;
					current = current.left;
					isLeftChild = true;
				}
				else {
					found = true;
					break;
				}
			}

			if(found){

				//case1: if node to be deleted is a leaf node
				if(current.left==null && current.right==null){

					if(isLeftChild){
						parent.left = null;
					}else{
						parent.right = null ;
					}
				}

				//case2: if has one child
				if((current.left == null && current.right!=null) || (current.right == null && current.left!=null)){

					if(isLeftChild){

						if(current.right == null){
							parent.left = current.left;
						}else if(current.left == null){
							parent.left = current.right;
						}


					}else{

						if(current.right == null){
							parent.right = current.left;
						}else if(current.left == null){
							parent.right = current.right;
						}
					}

				}

				//case3: current has both left and right child
				if(current.left != null && current.right != null){

					//finding the successor [successor = min of right subtree]
					Node successor = null;
					Node successorParent = null ;
					successor = current.right;
					successorParent = current;
					while(successor.left!=null) {
						successorParent = successor;
						successor = successor.left;
					}

					if(successorParent.value<successor.value) {
						successorParent.right = null;
					}else {
						successorParent.left = null;
					}

					//if successor doesnt have right child 
					//replacing successor with node to be deleted
					if(parent==null) {
						
						if(successor.right==null) {
							successor.left = current.left;
							successor.right = current.right;
							successorParent.left = null;
							this.root = successor;
						}else {
							if(successorParent.value == current.value) {
								successor.left = current.left;
								this.root = successor;
							}else {
								successorParent.left = successor.right;
								successor.left = current.left;
								successor.right = current.right;
								this.root = successor ;
							}
						}
					}else {
						if(isLeftChild) {
							parent.left = successor;
						}else {
							parent.right = successor;
						}
						successor.left = current.left;
						if(successor.right==null) {
							successor.right = current.right;
						}else {
							if(successorParent.value==current.value) {
								
							}else {
								
								successorParent.left = successor.right ;
								successor.right = current.right;
							}
						}

					}
				}

			}

			return found;
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
