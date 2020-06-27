package com.partha.ds.searching;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearchInArrayUsingRecursion {

	public static void main(String[] args) {
		int[] arr = new int[] {12,10,6,22,5,100,77};
		//int[] arr = new int[] {12,10,6};

		//first sorting the array
		Arrays.sort(arr);
		//		IntStream.range(0, arr.length)
		//			.forEach(i-> System.out.print(arr[i]+ " "));

		System.out.println("enter a number to search");
		Scanner sc = new Scanner(System.in);
		int numberToSearch = sc.nextInt();
		System.out.println("number exists = "+binarySearchUsingRecursion(arr, 0, arr.length-1, numberToSearch));

	}


	public static boolean binarySearchUsingRecursion(int[] arr, int start, int end , int numberToSearch) {
		if(start<=end) {
			int mid = (start + end)/2;
			if(arr[mid]==numberToSearch) {
				return true;
			}else if(arr[mid]>numberToSearch) {				
				return binarySearchUsingRecursion(arr, start, mid-1, numberToSearch);
			}else {
				return binarySearchUsingRecursion(arr, mid+1, end, numberToSearch);
			}
		}else {
			return false;
		}
	}

}
