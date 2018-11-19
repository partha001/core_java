package com.partha.geekForGeeks.arrays;

<<<<<<< HEAD
=======
/**
 * solved and working
 * @author partha
 */
>>>>>>> ee9c3f82c55b935ecb5d8165c811374c9511ebd3
import java.util.Scanner;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
<<<<<<< HEAD
		
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
				
=======
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

>>>>>>> ee9c3f82c55b935ecb5d8165c811374c9511ebd3
	}

}
