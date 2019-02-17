package com.partha.ds.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr= new int[]{12,11,10,8,28,21};
		
		for(int i=0;i<arr.length-1;i++){
			int minindex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minindex])
					minindex=j;
			}
			int temp=arr[minindex];
			arr[minindex]=arr[i];
			arr[i]=temp;
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
	}

}
