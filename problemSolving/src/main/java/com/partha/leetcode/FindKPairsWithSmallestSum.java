package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums
 * @author partha
 *
 */
public class FindKPairsWithSmallestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution {
	    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        // initialize a priority queue that keeps the smallest elements at each index
	        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
	            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
	        );
	        for (int i = 0; i < nums1.length; i++) {
	            minHeap.add(new int[] { i , 0 });
	        }

	        // iterate up to k and get the min values.
	        // as you run into a min value, add back on the next min!!
	        List<List<Integer>> result = new ArrayList<>();
	        for (int i = 0; i < k; i++) {
	            if (minHeap.isEmpty()) break;

	            int[] minPairIndexes = minHeap.remove();
	            int indexList1 = minPairIndexes[0], indexList2 = minPairIndexes[1];
	            List<Integer> res = Arrays.asList(nums1[indexList1], nums2[indexList2]);
	            result.add(res);

	            // now update the pq
	            if (indexList2 < nums2.length - 1) {
	                // this means we still have another pair for the index
	                // otherwise, we ran out
	                minHeap.add(new int[] { indexList1 , indexList2 + 1 });
	            }
	        }
	        
	        return result;
	    }
	}

}
