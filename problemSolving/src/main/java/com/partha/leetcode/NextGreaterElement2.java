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
