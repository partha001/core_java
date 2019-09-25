package com.partha.problemSolving.hr;

/**
 * problemDefiniton: https://www.hackerrank.com/challenges/crush/problem
 * @author partha
 *
 */
public class ArrayManipulation {

	public static void main(String[] args) {
		int[][] queries =  { {1,2,100},{2,5,100},{3,4,100}};
		System.out.println(arrayManipulation(5, queries));
		
	}

	static long arrayManipulation(int n, int[][] queries) {
		
		int[] arr= new int[n];
		int operations = queries.length;
		
		for(int i =0 ; i <operations;i++){
			int[] query = queries[i];
			arr = operationResult(arr, query[0] , query[1], query[2]);
		}
		
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i < arr.length;i++ ){
			if(arr[i]>max)
				max  = arr[i];
		}
		
		return max;

	}
	
	public static int[] operationResult(int[] arr,int left,int right,int toBeAdded){
		for(int i=left;i<right;i++){
			arr[i] = arr[i] + toBeAdded;
		}
		return arr;
	}

}
