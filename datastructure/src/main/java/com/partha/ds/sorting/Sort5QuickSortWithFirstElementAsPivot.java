package com.partha.ds.sorting;

import java.util.stream.IntStream;

public class Sort5QuickSortWithFirstElementAsPivot {

	public static void main(String[] args) {

		//int arr[] = {12, 11, 13, 5, 6, 7}; 
		int[] arr = new int[] {12,11,66,23};
		  
        System.out.println("Given Array"); 
        IntStream.range(0, arr.length)
			.forEach(i -> System.out.print(arr[i]+ " "));
  
        sort(arr, 0, arr.length-1);
  
        System.out.println("\nSorted array"); 
        IntStream.range(0, arr.length)
			.forEach(i -> System.out.print(arr[i]+ " "));
  
	}
	
	  /**
     * Swap elements at indexes {@code i} and {@code j}
     * in the give array 
     * 
     * @param array
     * @param i
     * @param j
     */
    static void swap(int[] array, int i, int j) {
        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
    
    
    /**
     * Quick sort the given array starting from index 
     * {@code l} to {@code r} 
     * 
     * Uses the first element in the array as the pivot 
     * 
     * @param array
     * @param left
     * @param right
     */
    static void sort(int[] array, int left, int right) {
        if (left < right) {
            // select pivot element (left-most)  
            int pivot = array[left];
            // partition and shuffle around pivot 
            int start = left;
            int end = right;
            while (start < end) {
                // move right to avoid pivot element 
                start += 1;
                // scan right: find elements greater than pivot 
                while (start <= right && array[start] < pivot) {
                    start += 1;
                }
                // scan left: find elements smaller than pivot
                while (end >= left && array[end] > pivot) {
                    end -= 1;
                }
                if (start <= right && start < end) {
                    // swap around pivot  
                    swap(array, start, end);
                }
            }
            // put pivot in correct place
            swap(array, left, end);
            // sort partitions 
            sort(array, left, end - 1);
            sort(array, end + 1, right);
        }
    }

}
