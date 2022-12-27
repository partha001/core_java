package com.partha.arrays;

import java.util.Scanner;

/**
 * @problemDefinition : https://leetcode.com/problems/pascals-triangle/
 * @leetCodeProbNumber : 13
 * @author partha
 * @status incomplete [refer to https://www.geeksforgeeks.org/pascal-triangle/]
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		System.out.println("enter an integer for the triangle height");
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		drawTriangle(height);
	}
	
	
	public static void drawTriangle(int height){
		for(int i=0;i<height;i++){
			int num =1;
			for(int j=0;j<=i;j++){
				
				//System.out.print(start +" ");
			}
		}
	}

}
