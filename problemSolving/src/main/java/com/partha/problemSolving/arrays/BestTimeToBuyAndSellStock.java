package com.partha.problemSolving.arrays;

import java.util.Scanner;

/**
 * @problemDefinition : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @leetCodeProbNumber : 122
 * @author partha
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		//int[] arr=readInput();
		int[] arr = new int[]{4,3};
		find(arr);
	}
	
	
	public static void find(int[] arr){
		int max=arr[0];
		int min=arr[0];
		
		for(int i=0;i< arr.length;i++){
			int current = arr[i];
			if(max < current){
				max = current ;
			}
			if(min > current){
				min = current;
			}
		}
		System.out.println("profit ="+ (max-min));
		
	}
	
	public static int[] readInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of array");
		int length = sc.nextInt();
		int[] arr=new int[length];
		for(int i=0;i< length ;i++){
			System.out.println("enter any number");
			arr[i] = sc.nextInt();
		}
		return arr;
	}

}
