package com.partha.ds.searching;

import java.util.Arrays;

/**
 * written by me
 * @author parbiswa
 *
 */
public class BinarySearchInArray {

	public static void main(String[] args) {
		int[] arr= {1,34,45,6,66, 22, 78 , 77};
		Arrays.sort(arr);
		int first=0;
		int last=arr.length -1;
		
		int mid=0;
		int numberToBeSearched=6;
		int foundIndex=-1;
		
		while(first<=last){
			 mid= (first + last)/2;
			 if(arr[mid]==numberToBeSearched){
				 foundIndex=mid;
				 break;
			 }else{
				 if(numberToBeSearched < arr[mid]){
					 last = mid-1;
				 }else{
					 first = mid+1;
				 }
			 }
			
		}
		System.out.println(foundIndex!=-1? "number found":"number not found");
		
	}

}
