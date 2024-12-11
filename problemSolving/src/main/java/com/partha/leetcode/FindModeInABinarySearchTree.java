package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *
 * @author partha
 */
public class FindModeInABinarySearchTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


    private static class Solution1 {
        int max = 1;

        public int[] findMode(TreeNode root) {
            HashMap<Integer, Integer> map = new HashMap<>();

            find_mode(root, map);

            int[] ans = new int[map.size()];
            int idx = 0;

            for (Integer key : map.keySet()) {
                if (map.get(key) == max)
                    ans[idx++] = key;
            }
            return Arrays.copyOf(ans, idx);
        }

        private void find_mode(TreeNode root, HashMap<Integer, Integer> map) {
            if (root == null)
                return;

            if (map.containsKey(root.val)) {
                int count = map.get(root.val) + 1;
                map.put(root.val, count);
                max = Math.max(count, max);
            } else
                map.put(root.val, 1);

            find_mode(root.left, map);
            find_mode(root.right, map);
        }
    }


    /**
     * SC: O(1)
     * @author partha
     */
    private static class Solution2 {

        int maxCount = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList();
        TreeNode previous = null;
        int currentElementCount = 0;

        public int[] findMode(TreeNode root) {
            find(root);
            int[] finalResult = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                finalResult[i] = result.get(i);
            }
            return finalResult;
        }


		/** the traversal style is important here . i.e inorder **/
        private void find(TreeNode node) {
            if (node == null)
                return;

            find(node.left);

            //calculating currentElementCount
            if (previous == null || previous.val != node.val)
                currentElementCount = 1;
            else if (previous != null && previous.val == node.val)
                currentElementCount++;

            //adding to result depending upon max-count
            if (currentElementCount == maxCount) {
                result.add(node.val);
            } else if (currentElementCount > maxCount) {
                maxCount = currentElementCount;
                result.clear();
                result.add(node.val);
            }

            previous = node;
            find(node.right);
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
