package com.partha.problemSolving.hr;

public class TwoDArray {

	public static void main(String[] args) {
		int[][] arr = new int[][]{
			{1 ,1 ,1 ,0 ,0 ,0},
			{0 ,1 ,0 ,0 ,0 ,0},
			{1 ,1 ,1 ,0 ,0 ,0},
			{0 ,0 ,2 ,4 ,4 ,0},
			{0 ,0 ,0 ,2 ,0 ,0},
			{0 ,0 ,1 ,2 ,4 ,0}
		};

		int[][] sumArr = new int[4][4];
		int result = Integer.MIN_VALUE;
		for(int row=0;row<4;row++){
			for(int col=0;col<4;col++){
				int temp = sum(arr,row,col);
				result = temp >result ? temp : result ;
			}
		}



		System.out.println(result);
		// return result ;
	}

	static int sum(int[][] arr,int row,int col){
		//	        int firstRow = arr[row][col]+ arr[row][col+1] + arr[row][col+2];
		//	        int secondRow =  arr[row+1][col+1];
		//	        int thirdRow = arr[row+2][col]+ arr[row+2][col+1] + arr[row+2][col+2];
		//	        return firstRow + secondRow + thirdRow ;

		int sum=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(i==1){
					if(j==1){
						sum = sum + arr[row+i][col+j];
					}
				}else{
					sum = sum + arr[row+i][col+j];
				}
			}
		}

		return sum;
	}






}
