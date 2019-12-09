package com.partha.ds.sorting;

import java.util.stream.IntStream;

public class Sort5QuickSortWithFirstElementAsPivot {

	public static void main(String[] args) {

		int arr[] = {12, 11, 13, 5, 6, 7}; 
		  
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
     * @param l
     * @param r
     */
    static void sort(int[] array, int l, int r) {
        if (l < r) {
            // select pivot element (left-most)  
            int pivot = array[l];
            // partition and shuffle around pivot 
            int i = l;
            int j = r;
            while (i < j) {
                // move right to avoid pivot element 
                i += 1;
                // scan right: find elements greater than pivot 
                while (i <= r && array[i] < pivot) {
                    i += 1;
                }
                // scan left: find elements smaller than pivot
                while (j >= l && array[j] > pivot) {
                    j -= 1;
                }
                if (i <= r && i < j) {
                    // swap around pivot  
                    swap(array, i, j);
                }
            }
            // put pivot in correct place
            swap(array, l, j);
            // sort partitions 
            sort(array, l, j - 1);
            sort(array, j + 1, r);
        }
    }

}
