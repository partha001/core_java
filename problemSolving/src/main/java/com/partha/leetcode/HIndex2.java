package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index-ii
 * @author partha
 *
 */
public class HIndex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * this is the exact same solutin as h-index1. and it works for this problem as well
	 * the difference with solution2 lies in the sort
	 * @author partha
	 *
	 */
	private static class Solution1 {
		public int hIndex(int[] citations) {
			int n = citations.length;
			int left = 0;
			int right = n - 1;
			Arrays.sort(citations);

			while(left <= right){
				int mid = (left + right) /2;

				if(citations[mid] == n - mid){
					return citations[mid];
				} else if(citations[mid] < n - mid){
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			return n - left;
		}
	}

	/**
	 * binary search algo
	 * @author partha
	 *
	 */
	private static class Solution2 {
		public int hIndex(int[] citations) {
			int left=0;
			int right=citations.length-1;
			int h=0;
			while(left<=right){
				int mid=(left+right)/2;
				if(citations.length-mid<=citations[mid]){
					h=citations.length-mid;
					right=mid-1;
				}
				else{
					left=mid+1;
				}
			}
			return h;
		}
	}

}
