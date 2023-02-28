package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self
 * @author biswaspa
 *
 */
public class CountOfSmallerNumberAfterItself {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * O (n^2)
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
	    class Node {
	        Node left, right;
	        int val, sum, dup = 1;
	        public Node(int v, int s) {
	            val = v;
	            sum = s;
	        }
	    }
	    public List<Integer> countSmaller(int[] nums) {
	        Integer[] ans = new Integer[nums.length];
	        Node root = null;
	        for (int i = nums.length - 1; i >= 0; i--) {
	            root = insert(nums[i], root, ans, i, 0);
	        }
	        return Arrays.asList(ans);
	    }
	    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
	        if (node == null) {
	            node = new Node(num, 0);
	            ans[i] = preSum;
	        } else if (node.val == num) {
	            node.dup++;
	            ans[i] = preSum + node.sum;
	        } else if (node.val > num) {
	            node.sum++;
	            node.left = insert(num, node.left, ans, i, preSum);
	        } else {
	            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
	        }
	        return node;
	    }
	}
	
	
	/**
	 * merge sort solution
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {
	    
	    public List<Integer> countSmaller(int[] nums) {
	        int len = (nums == null? 0 : nums.length);
	        
	        int[] idxs = new int[len];
	        int[] count = new int[len];
	        
	        for (int i = 0; i < len; i++) idxs[i] = i;
	        
	        mergeSort(nums, idxs, 0, len, count);
	        
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i : count) list.add(i);
	        
	        return list;
	    }
	    
	    private void mergeSort(int[] nums, int[] idxs, int start, int end, int[] count) {
	        if (start + 1 >= end) return;
	        
	        int mid = (end - start) / 2 + start;
	        mergeSort(nums, idxs, start, mid, count);
	        mergeSort(nums, idxs, mid, end, count);
	        
	        merge(nums, idxs, start, end, count);
	    }
	    
	    private void merge(int[] nums, int[] idxs, int start, int end, int[] count) {
	        int mid = (end - start) / 2 + start;
	        
	        int[] tmp = new int[end - start];
	        int[] tmpidx = new int[end - start];
	        int i = start, j = mid, k = 0;
	        while (k < end - start) {
	            if (i < mid) {
	                if (j < end && nums[j] < nums[i]) {
	                    tmpidx[k] = idxs[j];
	                    tmp[k++] = nums[j++];
	                } else {
	                    count[idxs[i]] += j - mid; // add those already counted
	                    tmpidx[k] = idxs[i];
	                    tmp[k++] = nums[i++];
	                }
	                
	            } else {
	                tmpidx[k] = idxs[j];
	                tmp[k++] = nums[j++];
	            }
	        }
	        
	        System.arraycopy(tmpidx, 0, idxs, start, end - start);
	        System.arraycopy(tmp, 0, nums, start, end - start);
	    }
	}


}
