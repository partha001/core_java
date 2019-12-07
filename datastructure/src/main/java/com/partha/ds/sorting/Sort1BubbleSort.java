package com.partha.ds.sorting;

/*
 * timecomplexity : O(n^2)
 */
public class Sort1BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = new int[]{10,9,8,6,7,5,5,3,2,1};

		System.out.println("printint the values before sorting");
		for(int i=0;i<arr.length-1;i++)
			System.out.print(arr[i]+" ");


		for(int i=0;i<arr.length-2;i++){
			for(int j=0;j<arr.length-2-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}

		System.out.println("\n\nprinting the values after sorting");
		for(int i=0;i<arr.length-1;i++)
			System.out.print(arr[i]+" ");

	}


}
