package com.partha.leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * @author biswaspa
 *
 */
public class MergeSortedArray {

	public static void main(String[] args) {

	}
	
	//this is the naive solution which makes use of extra space
	private static class Solution1 {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	      int[] result= new int[m+n];
	        int i=0;
	        int j=0;
	        int k=0;
	        
	        //till both has elements
	        while(i<m && j<n){
	            if(nums1[i]<=nums2[j]){
	                result[k] = nums1[i];
	                i++;
	            }else{
	                result[k]=nums2[j];
	                j++;
	            }
	            k++;
	        }
	        
	        
	        while(i<m){
	            result[k]=nums1[i];
	            i++;
	            k++;
	        }
	        
	        while(j<n){
	            result[k] = nums2[j];
	            j++;
	            k++;
	        }
	        
	        for(i=0;i<m+n;i++){
	            nums1[i]=result[i];
	        }
	        
	        //return nums1;
	    }
	}
	
	
	
	//this is the better solution since no extra space is used
	//algo : fills up num1 from behind
	private static class Solution2 {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int i=m + n -1;
	        m--;
	        n--;
	       
	        
	        while(m>=0 && n>=0){
	            if(nums1[m] >= nums2[n]){
	                nums1[ i-- ] = nums1[ m-- ];
	            }else{
	                nums1[ i-- ] = nums2[ n-- ];
	            }
	        }
	        
	       while (n >= 0) {
				nums1[i--] = nums2[n--];
			}
	        
	        while(m>=0){
	            nums1[i--] = nums1[m--];
	        }
	    }
	}

}
