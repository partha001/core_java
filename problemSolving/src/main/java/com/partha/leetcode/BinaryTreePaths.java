package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths
 *
 * @author partha
 */
public class BinaryTreePaths {

    public static void main(String[] args) {

    }


    private static class Solution1 {


        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<String>();
            generateList(root, "", result);
            return result;
        }


        public void generateList(TreeNode node, String current, List<String> result) {
            if (node == null)
                return;
            if (node.left == null && node.right == null) {
                current = current + node.val;
                result.add(current);
                return;
            }
            current = current + node.val + "->";
            if (node.left != null)
                generateList(node.left, current, result);

            if (node.right != null)
                generateList(node.right, current, result);


        }
    }


    //without using class level attribute to store the result
    //in fact this has better execution time.
    private static class Solution2 {

        public List<String> binaryTreePaths(TreeNode root) {
            ArrayList<String> result = new ArrayList();
            if (root == null)
                return result;
            return build(root, result, "");
        }

        private ArrayList<String> build(TreeNode node, ArrayList<String> result, String s) {
            if (node == null)
                return result;

            if (node.left == null && node.right == null) {
                s += node.val;
                result.add(new String(s));
                return result;
            }
            s += node.val + "->";

            ArrayList<String> left = build(node.left, result, s);
            ArrayList<String> right = build(node.right, left, s);
            return right;


        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
