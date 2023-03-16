package com.partha.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * @author partha
 *
 */
public class NextGreaterElement1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[]{1};
		int[] nums2 = new int[] {1,3};
		System.out.println(new NextGreaterElement1.Solution2().nextGreaterElement(nums1, nums2));

	}
	
	/**
	 * TC: O(length1 *length2)
	 * SC: O(length1)
	 * naive solution
	 * @author partha
	 * https://www.youtube.com/watch?v=68a1Dc_qVq4
	 * 
	 */
	private static class Solution1 {
	    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //key=number value=index
	        int[] result = new int[nums1.length];
	        Arrays.fill(result,-1);
	        for(int i=0;i<nums1.length;i++)
	            map.put(nums1[i],i);
	        
	        for(int i=0;i<nums2.length;i++){
	            if(!map.keySet().contains(nums2[i]))
	                continue;
	            
	            int number=nums2[i];
	            int index= map.get(number);
	            for(int j=i+1;j<nums2.length;j++){
	                if(nums2[j]>number){
	                    result[index] = nums2[j];
	                    break;
	                }
	            }
	        }
	        return result;
	    }

	}
	
	/**
	 * TC : O(length1 + length2)
	 * SC:  O(length1)
	 * https://www.youtube.com/watch?v=68a1Dc_qVq4
	 * @author partha
	 *	here the stack always contains element in the ascendng order
	 */
	private static class Solution2 {
	    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //key=number value=index
	        int[] result = new int[nums1.length];
	        Arrays.fill(result,-1);
	        for(int i=0;i<nums1.length;i++)
	            map.put(nums1[i],i);
	        
	        Stack<Integer> stack = new Stack();
	        //till this point its same as previous solution
	        for(int i=0;i<nums2.length;i++){
	            int current = nums2[i];

	            while(!stack.isEmpty() && current> stack.peek()){
	                int val = stack.pop();
	                int index = map.get(val);
	                result[index] = current;
	            }

	            if(map.keySet().contains(current))
	                stack.push(current);
	        }
	        return result;

	    }

	}

}
