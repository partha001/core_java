package com.partha.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * @author partha
 *
 */
public class SerializeDeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	/**
	 * @source this is the leetcode official solution.
	 * @author partha
	 *
	 */
	public class Codec2 {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			return rserialize(root, "");
		}

		public String rserialize(TreeNode root, String str) {
			// Recursive serialization.
			if (root == null) {
				str += "null,";
			} else {
				str += str.valueOf(root.val) + ",";
				str = rserialize(root.left, str);
				str = rserialize(root.right, str);
			}
			return str;
		}


		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] data_array = data.split(",");
			List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
			return rdeserialize(data_list);
		}



		public TreeNode rdeserialize(List<String> l) {
			// Recursive deserialization.
			if (l.get(0).equals("null")) {
				l.remove(0);
				return null;
			}

			TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
			l.remove(0);
			root.left = rdeserialize(l);
			root.right = rdeserialize(l);

			return root;
		}
	}

	private static  class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if(root == null) return "null";
			StringBuilder ser = new StringBuilder();
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			while(!q.isEmpty()){
				TreeNode node = q.remove();
				if(node == null){
					ser.append("null ");
				}else{
					ser.append(node.val).append(" ");
					q.add(node.left);
					q.add(node.right);
				}
			}
			return ser.toString();

		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.equals("") || data.equals("null")) return null;
			String[] values = data.split(" ");
			Queue<TreeNode> q = new LinkedList<>();
			TreeNode root = new TreeNode (Integer.valueOf(values[0]));
			q.add(root);
			int idx=1;// idx of value of nodes
			while(!q.isEmpty()){
				TreeNode node = q.remove();
				if(!values[idx].equals("null")){
					TreeNode left = new TreeNode(Integer.valueOf(values[idx]));
					node.left = left;
					q.add(node.left);
				}
				idx++;
				if(!values[idx].equals("null")){
					TreeNode right = new TreeNode(Integer.valueOf(values[idx]));
					node.right = right;
					q.add(node.right);
				}
				idx++;
			}

			return root;


		}
	}


	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
