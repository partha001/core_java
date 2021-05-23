package com.partha.problemSolving.leetcode;


/**
 * https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
 * @author partha
 *
 */
public class DistanceBetweenTwoNodesInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		
		
		System.out.println(new Solution2().findDist(root, 2,10));
	}

	
	/**
	 * find level of a. find level of b.
	 * if both exists then find lca and find level of lca
	 * if lca == a then return levelB -levelA
	 * if lca== b then return LevelA- levelB
	 * else return (levelA + levelb ) - 2*lcaLevel 
	 * @author partha
	 *
	 */
	private static class Solution1 {

		public int findDist(TreeNode root, int a, int b) {
			int aLevel = findLevel(root,a,-1);
			int bLevel = findLevel(root,b,-1);
			
			if(aLevel==-1 || bLevel==-1)
				throw new RuntimeException("either of the nodes doesnt exist");
			
			TreeNode lca = lowestCommonAncestor(root,a,b);
			if(lca.val==a) { //case1
				return bLevel - aLevel;
			}else if(lca.val==b){ //case2
				return aLevel-bLevel;
			}
			int lcaLevel = findLevel(root,lca.val,-1); //case3
			return (aLevel+bLevel) - 2*lcaLevel;
		}


		//considers root as the 0th level. expects ceed level as -1
		private int findLevel(TreeNode root, int target,int level)
		{
			if(root==null)
	            return -1;
	        if(root.val==target)
	            return level+1;
	 
	        int left =findLevel(root.left,target,level+1) ;
	        return (left!=-1)? left : findLevel(root.right,target,level+1);
		}
		
		
		private TreeNode lowestCommonAncestor(TreeNode root, int a, int b){
			if(root == null){  // base case 
				return null;
			}
			if(root.val == a || root.val == b){
				return root;
			}
			TreeNode left = lowestCommonAncestor(root.left, a, b);
			TreeNode right = lowestCommonAncestor(root.right, a, b);

			if(left!=null && right!=null)
				return root;
			
			if(left==null && right==null)
				return null;
			
			return left!=null? left : right;
		}


	}
	
	
	
	
	/**
	 * find level of a. find level of b.
	 * if both exists then find lca and find level of lca
	 * if lca == a then return levelB -levelA
	 * if lca== b then return LevelA- levelB
	 * else return (levelA + levelb ) - 2*lcaLevel 
	 * @author partha
	 *
	 */
	private static class Solution2 {

		public int findDist(TreeNode root, int a, int b) {
			
			
			TreeNode lca = lowestCommonAncestor(root,a,b);
			System.out.println(lca.val);
			return 0;
		}


		//considers root as the 0th level. expects ceed level as -1
		private int findLevel(TreeNode root, int target,int level)
		{
			if(root==null)
	            return -1;
	        if(root.val==target)
	            return level+1;
	 
	        int left =findLevel(root.left,target,level+1) ;
	        return (left!=-1)? left : findLevel(root.right,target,level+1);
		}
		
		
		private TreeNode lowestCommonAncestor(TreeNode root, int a, int b){
			if(root == null){  // base case 
				return null;
			}
			if(root.val == a || root.val == b){
				return root;
			}
			TreeNode left = lowestCommonAncestor(root.left, a, b);
			TreeNode right = lowestCommonAncestor(root.right, a, b);

			if(left!=null && right!=null)
				return root;
			
			if(left==null && right==null)
				return null;
			
			return left!=null? left : right;
		}


	}





	private static class GfG {
		int height1 = 0; int height2 = 0;

		public int findDist(TreeNode root, int a, int b) {
			// Your code here
			TreeNode lca = LCA(root, a, b);
			// System.out.print(lca.data);	       
			search_node(lca, a, b, 0);      
			return height1 + height2;
		}

		private TreeNode LCA(TreeNode root, int a, int b){
			if(root == null){  // base case 
				return null;
			}
			if(root.val == a || root.val == b){
				return root;
			}
			TreeNode left = LCA(root.left, a, b);
			TreeNode right = LCA(root.right, a, b);

			if(left!=null && right!=null){
				return root;
			}
			else if(left!=null && right == null){
				return left;
			}
			else if(left==null && right!=null){
				return right;
			}
			else
				return null;
		}

		void search_node(TreeNode root, int a, int b, int level){
			if(root == null){
				return;
			}

			if(root.val == a){
				height1 = level;
			}
			if(root.val == b){
				height2 = level;
			}

			search_node(root.left, a, b, level+1);
			search_node(root.right, a, b, level+1);
		}


	}


	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

}
