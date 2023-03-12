package com.partha.leetcode;

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
	 * binary search algo
	 * @author partha
	 *
	 */
	private static class Solution {
	    public int hIndex(int[] citations) {
	        int l=0,r=citations.length-1,h=0;
	        while(l<=r){
	            int mid=(l+r)/2;
	            if(citations.length-mid<=citations[mid]){
	                h=citations.length-mid;
	                r=mid-1;
	            }
	            else{
	                l=mid+1;
	            }
	        }
	        return h;
	    }
	}

}
