package com.partha.geekForGeeks.arrays;

import java.util.Scanner;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int testcases=scanner.nextInt();
		for(int i=0;i<testcases;i++){
			int length=scanner.nextInt();
			int sum=scanner.nextInt();
			int[] arr=new int[length];
			
			for(int j=0;j<length;j++){
				arr[j]=scanner.nextInt();
			}
			
		
			int startindex=0;
			int endindex=0;
			boolean sumFound=false;
			

			for(int m=0;m<length-1;m++){
				startindex=m;
				int currentsum=0;
				for(int n=m;n<length;n++){
					currentsum=currentsum+arr[n];
					if(currentsum==sum){
						endindex=n;
						sumFound=true;
						break;
					}else if(currentsum>sum){
						sumFound=false;
						break;
					}
				}
				if(sumFound)
					break;
				
			}
			
			if(sumFound)
				System.out.println((startindex+1) + " "+ (endindex+1));
			else
				System.out.println(-1);
			
			
		}
				
	}

}
