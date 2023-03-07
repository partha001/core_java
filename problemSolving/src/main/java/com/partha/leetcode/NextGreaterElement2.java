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

	}
	
	
	/**
     * Time complexity:O(N)
     * Space complexity:O(N)
	 * @author partha
	 */
	private static class Solution1 {
	    public int[] nextGreaterElements(int[] nums) {
	        int n = nums.length;
	        int nge[] = new int[n];
	        Stack < Integer > st = new Stack < > ();
	        for (int i = 2 * n - 1; i >= 0; i--) {
	            while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
	                st.pop();
	            }
	            if (i < n) {
	                if (st.isEmpty() == false) nge[i] = st.peek();
	                else nge[i] = -1;
	            }
	            st.push(nums[i % n]);
	        }
	        return nge;
	    }
	}
	
	/**
     * Time complexity:O(N)
     * Space complexity:O(N)
	 * @author partha
	 */
	private static class Solution2 {
	    public int[] nextGreaterElements(int[] nums) {
	        int len = 2 * nums.length - 1;
	        int[] result = new int[nums.length];
	        Arrays.fill(result, -1);
	        Stack<Integer> stack = new Stack<>();
	        for (int i = 0; i < len; i++) {
	            int index = i % nums.length;
	            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
	                int pop = stack.pop();
	                result[pop] = nums[index];
	            }
	            stack.push(index);
	        }
	        return result;
	    }
	}

}
