package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index
 * @author biswaspa
 *
 */
public class HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Solution1 {

		public int hIndex(int[] citations) {
			Arrays.sort(citations);
			int n=citations.length;
			int index=0;
			while(index<n && citations[index]<n-index)
			{
				index++;
			}
			return n-index;
		}

	}

	
	/**
	 * using bucketSort
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {
		public int hIndex(int[] citations) {
		    int n = citations.length;
		    int[] buckets = new int[n+1];
		    for(int c : citations) {
		        if(c >= n) {
		            buckets[n]++;
		        } else {
		            buckets[c]++;
		        }
		    }
		    int count = 0;
		    for(int i = n; i >= 0; i--) {
		        count += buckets[i];
		        if(count >= i) {
		            return i;
		        }
		    }
		    return 0;
		}
	}
	
	
	/**
	 * using binary search algorithm
	 * TC nLog n
	 * @author biswaspa
	 *
	 */
	private static class Solution3 {
	    public int hIndex(int[] citations) {
	        int n = citations.length;
	        int left = 0;
	        int right = n - 1;
	        Arrays.sort(citations);

	        while(left <= right){
	            int mid = (left + right) /2;

	            if(citations[mid] == n - mid){
	                return n-mid;
	            } else if(citations[mid] < n - mid){
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return n - left;
	    }
	}
	


}
