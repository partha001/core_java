package com.partha.arrays;

public class SecondSmallestOfASortedRotatedArray {

	public static void main(String[] args) {
		int[] arr= new int[]{4,5,6,7,8,9,10};
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
			
			int i=2;
			while(i<arr.length){
				if(arr[i]<arr[i-1] && i!=arr.length-1){
					secondMin = arr[i+1];
					break;
				}
				if(i==arr.length-1 && arr[i]<arr[0] ){
					secondMin = arr[0];
				}
				i++;
			}
			System.out.println("second min : "+secondMin);
		}
		
	}
}
