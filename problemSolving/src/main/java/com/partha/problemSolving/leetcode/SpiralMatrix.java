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
		System.out.println(new Solution1().spiralOrder(arr));
	}


	private static class Solution1 {
		public List<Integer> spiralOrder(int[][] matrix) {
			int bottom = matrix.length-1;
			List<Integer> list = new ArrayList();
			if(bottom==-1)
				return list;

			int right = matrix[0].length-1;
			int top = 0;
			int left = 0;
			int direction  = 1; 

			while(top<=bottom && left<=right){
				if(direction==1){ //left to right
					for(int i=left;i<=right;i++)
						list.add(matrix[top][i]);
					top++;
					direction=2;
					continue;
				}
				if(direction==2){ //top to bottom
					for(int i=top;i<=bottom;i++)
						list.add(matrix[i][right]);
					right--;
					direction=3;
					continue;
				}
				if(direction==3){ //right to left
					for(int i=right;i>=left;i--)
						list.add(matrix[bottom][i]);
					bottom--;
					direction=4;
					continue;
				}
				if(direction==4){ //bottom to top
					for(int i=bottom;i>=top;i--)
						list.add(matrix[i][left]);
					left++;              
					direction=1;
					continue;
				}
			}
			return list;   
		}
	}


}
