package com.partha.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii
 * @author partha
 *
 */
public class NextGreaterElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1,2,1};
		int[] result = new NextGreaterElement2.Solution2().nextGreaterElements(input);
		System.out.println(result);
	}


	/**
	 * Time complexity:O(N)
	 * Space complexity:O(N)
	 * @author partha
	 */
	private static class Solution {
		public int[] nextGreaterElements(int[] nums) {
			int[] result = new int[nums.length];
			int n = nums.length;
			Stack<Integer> stack = new Stack();
			for(int i=2* nums.length-1;i>=0;i--){
				int current = nums[i %n];

				while(!stack.isEmpty() && stack.peek()<=current) //popping all elements lesser than current
					stack.pop();

				if(i<n){ //updating result array
					if(!stack.isEmpty())
						result[i] = stack.peek();
					else
						result[i] = -1;               
				}

				stack.push(current); //putting current element in the stack again
			}
			return result;
		}
	}

	/**
	 * Time complexity:O(N)
	 * Space complexity:O(N)
	 * @author partha
	 * https://www.youtube.com/watch?v=ARkl69eBzhY
	 */
	private static class Solution2 {
		public int[] nextGreaterElements(int[] nums) {
			int len = nums.length;
			int[] result = new int[nums.length];
			Arrays.fill(result, -1);
			Stack<Integer> stack = new Stack<>(); //the stack will hold the index of the elements
			for (int i = 0; i < len*2; i++) {
				int index = i % len;
				while(!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
					int pop = stack.pop();
					result[pop] = nums[index];
				}

				if(i<len) //this condition is optional but stack.push() has to be done
					stack.push(index);
			}
			return result;
		}
	}

}
