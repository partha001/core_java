package com.partha.dynamicProgramming;

/**
 * @problemStatement: you are being given an integer array named my_array, you need to
 * 			find the sum of elements between indices i and j (i<=j), inclusive.
 * 			note that there are many such queries that we need to answer
 * @author bd7453
 * @input :   [1,-2,3,10,-8,0]
 * @sampleoutput: sumRange(0,2)=2
 * 					sumRange(1,4) = 3
 * 					sumRange(3,3) = 10
 */
public class Ex05SumOfTheRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[] {1,-2,3,10,-8,0};
		int length = arr.length;
		int[][] result = new int[length][length];
		result=getSumRange(arr);
		System.out.println(result[0][2]);
		System.out.println(result[1][4]);
		System.out.println(result[3][3]);
		

	}
	
	//my solution
	public static int[][] getSumRange(int[] arr) {
		int length = arr.length;
		int[][] result = new int[length][length];
		
		for(int i=0;i<length;i++) {
				result[i][i]=arr[i];
		}
		
		
		for(int i=0;i<length;i++) {
			for(int j=i+1;j<length;j++) {
				result[i][j]= result[i][j-1]+arr[j];
			}
		}
		
		printArr(result, length, length);
		return result;
	}
	
	
	public static void printArr(int[][] arr,int rows,int columns) {
		System.out.println("***************************");
		for(int i =0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("***************************");
	}

}
