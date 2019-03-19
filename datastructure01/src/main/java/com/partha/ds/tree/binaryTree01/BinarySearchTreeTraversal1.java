package com.partha.ds.tree.binaryTree01;

/**
 * link : https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
 * @author parbiswa
 */
public class BinarySearchTreeTraversal1 {

	public static void main(String[] args) {
		 BST tree = new BinarySearchTreeTraversal1().new BST(); 
		  
	        /* Let us create following BST 
	              50 
	           /     \ 
	          30      70 
	         /  \    /  \ 
	        20   40  60   80 */
	        tree.insert(50); 
	        tree.insert(30); 
	        tree.insert(20); 
	        tree.insert(40); 
	        tree.insert(70); 
	        tree.insert(60); 
	        tree.insert(80); 
	        
	        //printing nodes a particular level
	        System.out.println("printing nodes at given level");
	        tree.printGivenLevel(tree.root, 1);
	        
	        //printing nodes a particular level
	        System.out.println("printing nodes at given level");
	        tree.printGivenLevel(tree.root.left, 2);
	  
	        System.out.println("Inorder traversal of the given tree"); 
	        tree.inorder(); 

	        
	        
	}
	
   class BST{
	   
	   class Node 
	    { 
	        int key; 
	        Node left, right; 
	  
	        public Node(int item) 
	        { 
	            key = item; 
	            left = right = null; 
	        } 
	    } 
	   
	// Root of BST 
	    Node root; 
	  
	    // Constructor 
	    BST() 
	    { 
	        root = null; 
	    } 
	  
	    
	 // A utility function to do inorder traversal of BST 
	    void inorderRec(Node root) 
	    { 
	        if (root != null) 
	        { 
	            inorderRec(root.left); 
	            System.out.print(root.key + " "); 
	            inorderRec(root.right); 
	        } 
	    } 
	  
	    int minValue(Node root) 
	    { 
	        int minv = root.key; 
	        while (root.left != null) 
	        { 
	            minv = root.left.key; 
	            root = root.left; 
	        } 
	        return minv; 
	    } 
	  
	    // This method mainly calls insertRec() 
	    void insert(int key) 
	    { 
	        root = insertRec(root, key); 
	    } 
	  
	    /* A recursive function to insert a new key in BST */
	    Node insertRec(Node root, int key) 
	    { 
	  
	        /* If the tree is empty, return a new node */
	        if (root == null) 
	        { 
	            root = new Node(key); 
	            return root; 
	        } 
	  
	        /* Otherwise, recur down the tree */
	        if (key < root.key) 
	            root.left = insertRec(root.left, key); 
	        else if (key > root.key) 
	            root.right = insertRec(root.right, key); 
	  
	        /* return the (unchanged) node pointer */
	        return root; 
	    } 
	    
	    // This method mainly calls InorderRec() 
	    void inorder() 
	    { 
	        inorderRec(root); 
	    } 
	    
	    /* Compute the "height" of a tree -- the number of 
	    nodes along the longest path from the root node 
	    down to the farthest leaf node.*/
	    int height(Node root) 
	    { 
	        if (root == null) 
	           return 0; 
	        else
	        { 
	            /* compute  height of each subtree */
	            int lheight = height(root.left); 
	            int rheight = height(root.right); 
	              
	            /* use the larger one */
	            if (lheight > rheight) 
	                return(lheight+1); 
	            else return(rheight+1);  
	        } 
	    } 
	    
	    
	    /* Print nodes at the given level */
	    void printGivenLevel (Node root ,int level) 
	    { 
	        if (root == null) 
	            return; 
	        if (level == 1) 
	            System.out.println(root.key + " "); 
	        else if (level > 1) 
	        { 
	            printGivenLevel(root.left, level-1); 
	            printGivenLevel(root.right, level-1); 
	        } 
	    } 

   }

}
