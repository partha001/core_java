package com.partha.problemSolving.hr.array;

import java.util.Arrays;

/**
 * problemDefiniton: https://www.hackerrank.com/challenges/crush/problem
 * description: this is the most intutive solution
 * @author partha
 *
 */
public class ArrayManipulation {

	public static void main(String[] args) {
//		int[][] queries =  { {1,2,100},{2,5,100},{3,4,100}};
//		System.out.println(arrayManipulation(5, queries));
		
		int[][] queries =  { {2,6,8},{3,5,7},{1,8,1},{5,9,15}};
		System.out.println(arrayManipulation(10, queries));
		
	}

	static long arrayManipulation(int n, int[][] queries) {
		
		long[] arr= new long[n];
		int operations = queries.length;
		
		for(int i =0 ; i <operations;i++){
			int[] query = queries[i];
			arr = operationResult(arr, query[0] , query[1], query[2]);
		}
		
		
		long max = Long.MIN_VALUE;		
		max = Arrays.stream(arr).max().getAsLong();
		
		return max;

	}
	
	public static long[] operationResult(long[] arr,int left,int right,int toBeAdded){
		for(int i=left-1;i<right;i++){
			arr[i] = arr[i] + toBeAdded;
		}
		return arr;
	}

}
