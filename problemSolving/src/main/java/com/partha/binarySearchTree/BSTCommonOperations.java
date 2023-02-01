package com.partha.binarySearchTree;

import java.util.Stack;

public class BSTCommonOperations {

	public static void main(String[] args) {

		/************ Let us create following BST 
		        50 
		     /     \ 
		    30      70 
		   /  \    /  \ 
		  20   40  60   80
		 *********************/

		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);
		root.right = new TreeNode(70);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);


		//preorderRecursive(root);
		//inorderRecursive(root);
		//postorderRecursive(root);
		//preorderIterative(root);
		//inorderIterative(root);
		postorderIterative(root);


	}

	/* Pop all items one by one. Do following for every popped item
    a) print it
    b) push its right child
    c) push its left child
    Note that right child is pushed first so that left is processed first */
	private static void preorderIterative(TreeNode node) {
		if(node==null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);

		while (stack.empty() == false) {
			TreeNode current = stack.peek();
			System.out.print(" "+current.val);
			stack.pop();
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}



	private static void inorderIterative(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = node;
		while (!stack.empty() || curr != null)
		{
			// if the current node exists, push it into the stack (defer it)
			// and move to its left child
			if (curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			else {
				// otherwise, if the current node is null, pop an element from
				// the stack, print it, and finally set the current node to its
				// right child
				curr = stack.pop();
				System.out.print(curr.val + " ");

				curr = curr.right;
			}
		}
	}
	
	
	
	// Iterative function to perform postorder traversal on the tree
    public static void postorderIterative(TreeNode root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty stack and push the root node
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
    
        // create another stack to store postorder traversal
        Stack<Integer> out = new Stack<>();
    
        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a node from the stack and push the data into the output stack
        	TreeNode curr = stack.pop();
            out.push(curr.val);
    
            // push the left and right child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }
    
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
    
        // print postorder traversal
        while (!out.empty()) {
            System.out.print(out.pop() + " ");
        }
    }
 



	private static void preorderRecursive(TreeNode node) {
		if(node!=null) {
			System.out.print(" "+  node.val );
			preorderRecursive(node.left);
			preorderRecursive(node.right);
		}
	}


	private static void inorderRecursive(TreeNode node) {
		if(node!=null) {
			inorderRecursive(node.left);
			System.out.print(" "+  node.val );
			inorderRecursive(node.right);
		}
	}



	private static void postorderRecursive(TreeNode node) {
		if(node!=null) {
			postorderRecursive(node.left);
			postorderRecursive(node.right);
			System.out.print(" "+  node.val );
		}
	}



	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
