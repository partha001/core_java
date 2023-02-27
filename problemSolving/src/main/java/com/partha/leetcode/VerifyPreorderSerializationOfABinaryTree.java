package com.partha.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * @author biswaspa
 *
 */
public class VerifyPreorderSerializationOfABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * TC: O(N)
	 * SC: O(N)
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
		public boolean isValidSerialization(String preorder) {
			// using a stack, scan left to right
			// case 1: we see a number, just push it to the stack
			// case 2: we see #, check if the top of stack is also #
			// if so, pop #, pop the number in a while loop, until top of stack is not #
			// if not, push it to stack
			// in the end, check if stack size is 1, and stack top is #
			if (preorder == null) {
				return false;
			}
			Stack<String> st = new Stack<>();
			String[] strs = preorder.split(",");
			for (int pos = 0; pos < strs.length; pos++) {
				String curr = strs[pos];
				while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
					st.pop();
					if (st.isEmpty()) {
						return false;
					}
					st.pop();
				}
				st.push(curr);
			}
			return st.size() == 1 && st.peek().equals("#");
		}
	}


	/**
	 * TC: O(N)
	 * SC: O(1)
	 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/solutions/78551/7-lines-easy-java-solution/
	 * @author biswaspa
	 *
	 */
	private static class Solution2{
		public boolean isValidSerialization(String preorder) {
			String[] nodes = preorder.split(",");
			int diff = 1;
			for (String node: nodes) {
				if (--diff < 0) return false;
				if (!node.equals("#")) diff += 2;
			}
			return diff == 0;
		}
	}

}
