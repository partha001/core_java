package com.partha.problemSolving.arrays;

/**
 * @problem: subarray with given sum
 * @description:
	Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
	Ouptut: Sum found between indexes 2 and 4
	
	Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
	Ouptut: Sum found between indexes 1 and 4
	
	Input: arr[] = {1, 4}, sum = 0
	Output: No subarray found
 * @author partha
 */

public class SubarrayWithGivenSum {

	public static void main(String[] args) {

//		//for taking input
//		Scanner scanner=new Scanner(System.in);
//		int testcases=scanner.nextInt();
//		for(int i=0;i<testcases;i++){
//			int length=scanner.nextInt();
//			int sum=scanner.nextInt();
//			int[] arr=new int[length];
//
//			for(int j=0;j<length;j++){
//				arr[j]=scanner.nextInt();
//			}
//			
//			subArrayWithGivenSum(arr, sum);
//		}
		
		
		int[] arr=new int[]{1, 4, 0, 0, 3, 10, 5};
		subArrayWithGivenSum(arr, 7);

	}

	public static void subArrayWithGivenSum(int[] arr, int sum){
		int startindex=0;
		int endindex=0;
		int length= arr.length;
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
			System.out.println((startindex) + " "+ (endindex));
		else
			System.out.println(-1);


	}

}


