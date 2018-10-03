package com.partha.geekForGeeks.arrays;

/**
 * solved and working
 * @author partha
 */
import java.util.Scanner;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testcount=scanner.nextInt();
		for(int i=0;i<testcount;i++) {
			int length=scanner.nextInt();
			int sum=scanner.nextInt();

			int[] arr=new int[length];
			for(int p=0;p<length;p++)
				arr[p]=scanner.nextInt();
			

			int currentsum;
			int startindex=0;
			int endindex=0;
			boolean sumfound=false;




			for(int m=0;m<length;m++) {
				currentsum=0;
				startindex=m;
				for(int n=m;n<length;n++) {
					currentsum=currentsum+ arr[n];
					if(currentsum==sum) {
						endindex=n;
						sumfound=true;
						break;
					}else if(currentsum>sum) {
						break;
					}
				}
				if(sumfound) {
					break;
				}			
			}

			if(sumfound) {
				System.out.println((startindex+1)+" "+(endindex+1));
			}else {
				System.out.println(-1);
			}

		}

	}

}
