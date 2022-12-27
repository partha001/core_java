package com.partha.arrays;

//in progress
public class SecondLargestElementInRotatedArray {

	public static void main(String[] args) {
		int[] arr = new int[]{6,7,1,2,3,4,5};
		System.out.println(findSecondLargest(arr));
	}
	
	public static int findSecondLargest(int[] arr){
		for(int i = 0;i< arr.length;i++){
			
			
			if(i==0 && arr[i]<arr[arr.length-1])
				return arr[arr.length -2];
			else if(i==1 && arr[i]==arr[arr.length-1]+1 && (arr[0]==arr[1]-1))
				return arr[arr.length-1];
			else if(arr[i]>arr[i+1]){
				return arr[i-1];
			}
			
		}
		return 0;
	}

}
