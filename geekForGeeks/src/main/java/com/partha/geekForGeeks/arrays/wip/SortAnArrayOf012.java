package com.partha.geekForGeeks.arrays.wip;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortAnArrayOf012 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int i=scanner.nextInt();
		for(int j=0;j<i;j++){
			int n=scanner.nextInt();
		int[] arr=new int[n];
		
		//taking inputs
		IntStream.range(0, n).forEach(k-> arr[k]=scanner.nextInt());
		
		int[] arr2=Arrays.stream(arr).sorted().toArray();
		for(int m=0;m<arr.length;m++){
			if(arr2.length-1==m)
				System.out.print(arr2[m]);
			else 
				System.out.print(arr2[m]+" ");
		}
			
		}
	}

}
