package com.partha.problemSolving.arrays;

public class SecondLargestElementInUnsortedArray {

	public static void main(String[] args) {
		int[] arr=new int[]{77,51,78,23,99};
		System.out.println(findSecondLargest(arr));
	}
	
	public static int findSecondLargest(int[] arr){
		int max=0;
		int secondMax =0 ;
		for(int i : arr){
			if( i> max  && i>secondMax){
				secondMax = max;
				max = i;
			}
			else if (i > secondMax && i<max){
				secondMax = i;
			}
		}
		return secondMax;
	}

}
