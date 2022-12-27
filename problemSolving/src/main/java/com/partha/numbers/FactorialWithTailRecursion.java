package com.partha.numbers;

import java.util.Scanner;

public class FactorialWithTailRecursion {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of test cases");
		int tests=sc.nextInt();
		for(int i=0;i<tests;i++){
			System.out.println("enter any number");
			int input=sc.nextInt();
			System.out.println("entered-number="+input+"   factorial="+factorial(input));
		}
	}
	
	
	public static int factorial(int input){
		return factorial(input,1);
	}
	
	public static int factorial(int n , int result){
		if(n==0)
			return result;
		return factorial(n-1,n*result);
	}

}
