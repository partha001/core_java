package com.partha.ds.sorting;

import java.util.stream.IntStream;

public class Sort10HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[]{10,9,8,6,7,5,5,3,2,1};
		heapSort(arr);
		IntStream.range(0, arr.length)
		.forEach(i -> System.out.print(arr[i]+ " "));
	}
	
	
	public static void heapSort(int[] arr) {
		//step1 : build heap
		buildHeap(arr, arr.length);
		
		//step2 : removing element from top and putting at end and heapify
		for(int i=arr.length-1;i>0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}
	
	public static void buildHeap(int[] arr,int n) {
		int start=n/2 - 1; //first non-leaf node
		for(int i=start;i>=0;i--) {
			heapify(arr, n, i);
		}
	}
	
	public static void heapify(int[] arr,int n,int i) {
		int left = i*2 + 1;
		int right = i*2 + 2;
		int largest = i;
		if(left<n && arr[left]>arr[largest] ) {
			largest = left;
		}
		if(right<n && arr[right]>arr[largest]) {
			largest = right;
		}
		if(largest!=i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr,n,largest);
		}
	}

}
