package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * @author biswaspa
 *
 */
public class IntersectionOfArrays {

	public static void main(String[] args) {

//		[4,9,5]
//				[9,4,9,8,4]
		int[] arr1 = new int[] {4,9,5};
		int[] arr2 = new int[] {9,4,9,8,4};
		int[] result = new Solution1().intersect(arr1, arr2);
		System.out.println();
		
	}
	
	
	/**
	 * most naive solution 
	 * complexity : O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
	    public int[] intersect(int[] nums1, int[] nums2) {
	            if(nums1.length==0 || nums2.length==0){
	                return new int[0];
	            }
	        
	       
		       List<Integer> result = new ArrayList<>();
		       Map<Integer,Integer> map = new HashMap();
		        for(int i=0;i<nums1.length;i++){
		            map.put(nums1[i], map.get(nums1[i])==null? 1: map.get(nums1[i]).intValue()+1);
		        }
		        
		        for(int i=0;i<nums2.length;i++){
		            if(map.get(nums2[i])!=null && map.get(nums2[i]).intValue()!=0){
		                result.add(nums2[i]);
		                map.put(nums2[i], map.get(nums2[i]).intValue()-1);
		            }
		        }
		        
		        int[] arr = new int[result.size()];
		        for(int i=0;i<arr.length;i++) {
		        	arr[i] = result.get(i);
		        }
		        
		        return arr;		    
		    
	    }
	}

}
