package com.partha.problemSolving.numbers;

/**
 * this program is the same as the previous program w.r.t time complexity
 * but this has better readablity
 * @author parbiswa
 *
 */
public class SpiralOutputOf2DMatrix2 {

	public static void main(String[] args) {
		int[][] arr = new int[][]{ {11,12,13,14,15},{16,17,18,19,20}, {21,22,23,24,25},{26,27,28,29,30}};
		printSpiral(4, 5, arr);
	}
	
	public static void printSpiral(int row,int col,int[][] arr){
		int direction =1;
		
		int left=0;
		int right = col-1;
		int top = 0;
		int bottom = row-1;
		
		while(left<=right && top<=bottom){
			
			//movement = left to right movement in same row
			if(direction==1){
				for(int i=left;i<=right;i++){
					System.out.print(arr[top][i]+ " ");
				}
				direction=2;
				top++;
			}
			
			//movement = top to bottom in same column
			if(direction==2){
				for(int i=top;i<=bottom;i++){
					System.out.print(arr[i][right]+ " ");
				}
				direction=3;
				right--;
			}
			
			//movement = right to left in same row
			if(direction==3){
				for(int i=right;i>=left;i--){
					System.out.print(arr[bottom][i]+ " ");
				}
				direction=4;
				bottom--;
			}
			
			//movement = bottom to up in same column
			if(direction==4){
				for(int i=bottom;i>=top;i--){
					System.out.print(arr[i][left]+" ");
				}
				direction=1;
				left++;
			}
			
		}
	}

}

/**
 * if its the below matrix
 * 
 * 11  12  13  14  15
 * 16  17  18  19  20
 * 21  22  23  24  25
 * 26  27  28  29  30
 * 
 * then the output will be 
 * 11 12 13 14 15 20 25 30 29 28 27 26 21 16 17 18 19 24 23 22
 */
