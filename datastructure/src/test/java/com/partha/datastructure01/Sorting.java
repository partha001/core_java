package com.partha.datastructure01;

import java.util.stream.IntStream;

public class Sorting {

	public static void main(String[] args) {
		int[] arr = new int[] {11,10,5,6,7,-12};
		//bubbleSort(arr);
		//selectionSort(arr);
		//insertionSort(arr);
		mergeSort(arr, 0, arr.length-1);
		IntStream.range(0, arr.length).forEach(i -> System.out.print(arr[i]+ " "));
	}


	static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}

	static void selectionSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int maxIndex =0;
			for(int j=1;j<arr.length-i;j++) {
				if(arr[maxIndex]<arr[j]) {
					maxIndex = j;
				}

			}
			//changing between maxIndex and currentIndex
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp; 
		}
	}


	static void insertionSort(int[] arr) {
		if(arr.length>1) {
			for(int i=1;i<arr.length;i++) {
				int currentItem = arr[i];
				int j = i-1;
				while(j>=0 && currentItem < arr[j]) {
					arr[j+1] = arr[j];
					j--;
				}
				arr[j+1] = currentItem;
			}
		}
	}


	static void mergeSort(int[] arr, int left, int right) {
		if(left<right) {
			int mid = (left + right )/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1 , right);
			merge(arr , left , mid , right);
		}
	}

	static void merge(int[] arr, int left , int mid , int right) {
		int length1 = mid - left + 1;
		int length2 = right - mid ;
		
		int[] larr = new int[length1];
		int[] rarr = new int[length2];
		
		//populating the left array
		for(int i=0;i<length1;i++) {
			larr[i] = arr[left+i];
		}
		
		//populating the right array
		for(int j=0;j<length2;j++) {
			rarr[j] = arr[mid + j + 1];
		}
		
		//merging
		int i=0,j=0,k=left;
		while(i<length1 && j<length2) {
			if(larr[i]<=rarr[j]) {
				arr[k]= larr[i];
				i++;
			}else {
				arr[k]= rarr[j];
				j++;
			}
			k++;
		}
		
		while(i<length1) {
			arr[k] = larr[i];
			i++;
			k++;
		}
		
		while(j<length2) {
			arr[k] = rarr[j];
			j++;
			k++;
		}		
	}
	
	
//	static void quickSort(int[] arr,int left, int right) {
//		if(left<right) {
//			int pivot = arr[left];
//			int start = left;
//			int end = right;
//			
//			while(start<end) {
//				
//				start++;
//				
//				//scanning from left to right
//				while(start<right && arr[start]<pivot) {
//					start++;
//				}
//				
//				//scanning from right to left
//				while(end>left && arr[end]>pivot) {
//					end--;
//				}
//				
//				if(start)
//				
//			}
//		}
//	}
	
	
	static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]= temp;
	}

}
