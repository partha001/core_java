package com.partha.geekForGeeks.arrays;

/**
 * problem status : completed
 * geek for geek status : compiles and runs successfully
 * @author partha
 */
import java.util.Arrays;
import java.util.Scanner;

public class MissingNumberInArray {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int i=scanner.nextInt();
		for(int j=0;j<i;j++){
			
			int totalCount=scanner.nextInt();
			int[] arr=new int[totalCount-1];
			
			for(int k=0;k<totalCount-1;k++){
				arr[k]=scanner.nextInt();
			}
			
			
			//my operations starts
			int sumArray=Arrays.stream(arr).sum();
			System.out.println( ((totalCount*(totalCount+1))/2) - sumArray);
			//my operations end
			
		}
	}

}
