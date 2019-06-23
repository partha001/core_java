package com.partha.problemSolving.numbers;

import java.util.Scanner;

public class ReversingInteger {

	public static void main(String[] args) {
		System.out.println("enter any integer");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result =0;
		while(n!=0){
			result = result *10;
			result = result + (n%10);
			n = n/10;				
		}
		System.out.println(result);
	}

}
