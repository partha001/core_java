package com.partha.arrays;

/**
 * @problem_definition : https://leetcode.com/problems/contains-duplicate/description/
 * @author parbiswa
 * @timecomplexity :O(n^2)
 */
public class ContainsDuplicatesOrNot {

	public static void main(String[] args) {
		int[] arr = new int[]{23,12,45,2};
		System.out.println(containsDuplicates(arr));
		
	}

	public static boolean containsDuplicates(int[] arr){
		
		boolean found = false;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]==arr[j]){
					found = true;
					break;
				}
			}
			if(found){
				break;
			}
		}
		return found;
	}

}
