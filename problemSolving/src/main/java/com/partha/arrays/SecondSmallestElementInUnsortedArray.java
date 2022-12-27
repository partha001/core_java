package com.partha.arrays;

public class SecondSmallestElementInUnsortedArray {

	public static void main(String[] args) {
		int[] arr= new int[]{1,23,45,7,7,2,13};
		printSecondSmallest(arr);
	}
	
	public static void printSecondSmallest(int[] arr){
		if(arr.length<2){
			System.out.println("second minimum not available");
		}else{
			int min , secondMin;
			if(arr[0]<=arr[1]){
				min = arr[0];
				secondMin =arr[1];
			}else{
				min = arr[1];
				secondMin = arr[0];
			}
			
			for(int i=2;i<arr.length;i++){
				if(arr[i]< min){
					secondMin = min;
					min = arr[i];
				}else if(arr[i]>min && arr[i]<secondMin){
					secondMin = arr[i];
				}
			}
			System.out.println("second min : "+secondMin);
		}
		
	}

}
