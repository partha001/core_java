package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 * @author partha
 */
public class FindDuplicateSubtrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * TC: O(n^2).
	 * SC: O(n^2)
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	        HashMap<String,Integer> map=new HashMap<>();
	        List<TreeNode>ans=new ArrayList<>();
	        traverse(map,ans,root);
	        return ans;
	    }
	    public String traverse(HashMap<String,Integer>map,List<TreeNode>list,TreeNode root){
	        if(root==null){
	            return "#";
	        }
	        String ans=root.val+","+traverse(map,list,root.left)+","+traverse(map,list,root.right);
	        map.put(ans,map.getOrDefault(ans,0)+1);
	        if(map.get(ans)==2){
	            list.add(root);
	        }
	        return ans;
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
