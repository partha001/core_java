package com.partha.numbers;

public class SpiralOutputOf2DMatrix {

	public static void main(String[] args) {
		int[][] arr = new int[][]{ {11,12,13,14,15},{16,17,18,19,20}, {21,22,23,24,25},{26,27,28,29,30}};
		printSpiral(4, 5, arr);
	}
	
	public static void printSpiral(int row,int col,int[][] arr){
//		for(int i =0;i<row;i++){
//			
//			for(int j=0;j<col;j++){
//				System.out.print(arr[i][j]+ "  ");
//			}
//			System.out.println("");
//		}
		
		int i=0 , curRow=0 , curCol=0;
		int lastRow =  row-1;
		int lastCol =  col-1;
		
		while(curRow <= lastRow  && curCol <= lastCol){
			
			for( i=curCol ; i<=lastCol; i++){
				System.out.print( arr[curRow][i] + " " );
			}
			curRow++;
			 
			for( i=curRow; i<=lastRow;i++){
				System.out.print( arr[i][lastCol]+ " ");
			}
			lastCol--;
			
			if( curRow <= lastRow){
				for(i=lastCol;i>=curCol;i--){
					System.out.print( arr[lastRow][i]+ " ");
				}
				lastRow--;
			}
			if(curCol <= lastCol){
				for(i=lastRow;i>=curRow;i--){
					System.out.print( arr[i][curCol]+ " ");
				}
				curCol++;
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
