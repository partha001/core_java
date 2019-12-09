package com.partha.ds.sorting;

public class Sort4MergeSort {
	

	public static void mergeSort(int[] arr,int left,int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(arr,left,mid);
			mergeSort(arr, mid+1, right);
			merge(arr,left,mid,right);
		}
	}
	

	
	
	public static void merge(int[] arr,int left,int mid,int right) {
		int length1 = mid - left +1;
		int length2 = right - mid;
		
		int[] larr = new int[length1];
		int[] rarr = new int[length2];
		
		for(int i=0;i<length1;i++) {
			larr[i]=arr[left+i];			
		}
		
		for(int j=0;j<length2;++j) {
			rarr[j]=arr[mid+1+j];
		}
		
		int i=0;
		int j=0;
		int k= left;
		
		while(i<length1 && j<length2) {
			if(larr[i]<=rarr[j]) {
				arr[k]=larr[i];
				i++;
			}else {
				arr[k] = rarr[j];
				j++;
			}
			k++;
		}
		
		while(i<length1) {
			arr[k]=larr[i];
			k++;
			i++;
		}
		
		while(j<length2) {
			arr[k]=rarr[j];
			k++;
			j++;
		}
	}
    
    
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
   
  

    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        mergeSort(arr, 0, arr.length-1);
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
    
    //

}
