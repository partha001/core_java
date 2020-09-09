package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * problem definition : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @author biswaspa
 *
 */
public class Day11LevelOrder {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left =  new TreeNode(15); 
		node.right.right =  new TreeNode(7);		
	}
	
	/**
	 * here am calculating the height
	 * @author biswaspa
	 *
	 */
	 static public class TreeNode {
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
	
	static class Solution1 {
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
	        int levels =  height(root);
	        for(int i=levels;i>=1;i--){
	            List<Integer> tempList = traverselevel(root,i,new ArrayList<Integer>());
	            finalList.add(tempList);
	        }
	        return finalList;
	    }
	    
	    
	    public List<Integer> traverselevel(TreeNode root,int level ,List<Integer> list){
	        if(root==null){
	            return list;
	        }
	        else if(level==1){
	            list.add(root.val);
	            return list;
	        }else{
	            traverselevel(root.left,level-1 , list);
	            traverselevel(root.right,level-1 , list);
	            return list;
	        }
	    }
	    
	    
	    public int height(TreeNode root){
	        if(root==null){
	            return 0;
	        }else{
	            int leftHeight = height(root.left);
	            int rightHeight = height(root.right);
	            return Math.max(leftHeight,rightHeight)+1;
	        }
	    }
		
	}
	
	/**
	 * without using height
	 * @author biswaspa
	 *
	 */
	static class Solution2{
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> finalList = new ArrayList<List<Integer>>();
			if(root==null){
				return finalList;
			}else {
				Queue<TreeNode> queue = new LinkedList<TreeNode>();
				queue.add(root);
				while(!queue.isEmpty()) {
					int subListLength = queue.size();
					
					List<Integer> sublist = new ArrayList<>();
					for(int i=0;i<subListLength;i++) {
						TreeNode node = queue.poll();
							sublist.add(node.val);
							
							if(node.left!=null) {
								queue.add(node.left);
							}
							
							if(node.right!=null) {
								queue.add(node.right);
							}
							
					}
					
					//finalList.add(sublist); //for adding sublist in top down style
					finalList.add(0, sublist); //for adding sublist in bottom up style
				}
				
				return finalList;
			}
			

		}
	}



}
