package com.partha.geekForGeeks.arrays;

/**
 * this is currently in progress
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * List of numbers was given. Arrange numbers in decreasing order of their frequencies 
 * Ex:    3, 4, 4, 4, 4, 5, 5, 5, 2, 2, 2.
	Ans:  4, 4, 4, 4, 2, 2, 2, 5, 5, 5, 3.
 * @author partha
 *
 */
public class ArrangeInDecreasingOrderOfFrequency {

	public static void main(String[] args) {

		//input dataset
		int[] arr=new int[]{ 3, 4, 4, 4, 4, 5, 5, 5, 2, 2, 2};


		//Step1 -sorting the elements
		arr=selectionSort(arr);

		Set<Integer> myset=new HashSet<>();
		for(int i=0;i<arr.length;i++)
			myset.add(arr[i]);




		//Step2- creating a 2day array with the element and its count	
		int[][] countarr=new int[arr.length][2];
		int m=0;
		//int n=0;
		for(int i=0;i<myset.size();i++){
			if(i==0){
				countarr[m][0]=arr[i];
				countarr[m][1]=1;
			}
			else{
				if(arr[i]==arr[i-1]){
					countarr[m][1]=countarr[m][1]+1;
				}else{
					countarr[++m][0]=arr[i];
					countarr[m][1]=1;
					//m++;
				}
			}
		}

		//Step3- sorting the 2d array by count

		for(int i=0;i<myset.size()-1;i++){
			System.out.println("");
			int minindex=i;
			for(int j=i+1;j<myset.size();j++){
				if(countarr[j][1]<countarr[minindex][1]){
					minindex=j;
				}
			}

			if(minindex!=i){
				int temp=countarr[i][0];
				countarr[i][0]=countarr[minindex][0];
				countarr[i+1][0]=temp;

				temp = countarr[i][1];
				countarr[i][1]=countarr[minindex][1];
				countarr[i+1][1]=temp;	
			}
		}



		//finally printing the result
		for(int i=0;0!=countarr[i][1];i++){
			for(int j=0;j<countarr[i][1];j++){
				System.out.print(countarr[i][0]+ "   ");
			}
		}

	}


	public static int[] selectionSort(int[] arr){

		for(int i=0;i<arr.length-1;i++){
			int minindex=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minindex])
					minindex=j;
			}
			int temp=arr[minindex];
			arr[minindex]=arr[i];
			arr[i]=temp;
		}
		return arr;
	}


}
