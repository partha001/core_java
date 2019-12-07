package com.partha.ds.sorting;

/*
 * timecomplexity : O(n^2)
 */
public class Sort3InsertionSort {

	public static void main(String[] args) {
		int[] arr= new int[]{12,11,10,8,28,21};
		
		
		for(int i=0;i<arr.length;i++){
			int current=arr[i];
			int j=i-1;
			while(j>=0 && current<arr[j]){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=current;			
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}

}
