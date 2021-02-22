package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * @author biswaspa
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] arr = new int[][] {{1, 2, 3} , { 4, 5, 6} , {7, 8, 9}};

	}


	class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			List<Integer> list = new ArrayList<>();
			int direction =1;
			int[][] arr = matrix;

			int left=0;			
			int top = 0;
			int bottom = matrix.length-1;
			int right = matrix[0].length-1;                              //
			while(left<=right && top<=bottom){ 

				//movement = left to right movement in same row
				if(direction==1){
					for(int i=left;i<=right;i++){
						//System.out.print(arr[top][i]+ " ");'/b  ....nbg 
						list.add(arr[top][i]);
					}
					direction=2;
					top++;
				}

				//movement = top to bottom in same column
				if(direction==2){
					for(int i=top;i<=bottom;i++){
						//System.out.print(arr[i][right]+ " ");
						list.add(arr[i][right]);
					}
					direction=3;
					right--;
				}

				//movement = right to left in same row
				if(direction==3){
					for(int i=right;i>=left;i--){
						//System.out.print(arr[bottom][i]+ " ");
						list.add(arr[bottom][i]);
					}
					direction=4;
					bottom--;
				}

				//movement = bottom to up in same column
				if(direction==4){
					for(int i=bottom;i>=top;i--){
						//System.out.print(arr[i][left]+" ");
						list.add(arr[i][left]);
					}
					direction=1;
					left++;
				}

			}
			return list;	
		}
	}

}
