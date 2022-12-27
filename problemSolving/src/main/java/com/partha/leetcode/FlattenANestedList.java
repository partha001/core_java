package com.partha.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * @author partha
 *
 */
public class FlattenANestedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private static class NestedIterator implements Iterator<Integer> {

		Stack<NestedInteger> stack = new Stack<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			makeStack(nestedList);
			
		}

		@Override
		public Integer next() {
			if(hasNext()) return stack.pop().getInteger();
			return null;
		}

		@Override
		public boolean hasNext() {
			while(!stack.isEmpty() && !stack.peek().isInteger()) {
				makeStack(stack.pop().getList());
			}

			return !stack.isEmpty();
		}

		private void makeStack(List<NestedInteger> nestedList) {
			for(int i = nestedList.size() - 1; i>=0; i--) {
				stack.push(nestedList.get(i));
			}
		}
	}




	private interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return empty list if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}


}
