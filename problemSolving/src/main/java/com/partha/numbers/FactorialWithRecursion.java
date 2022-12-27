package com.partha.numbers;

import java.util.Scanner;

/**
 * this program is to find factorial of a number using recursion
 * @author partha
 *
 */
public class FactorialWithRecursion {
	
	
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
	
	public static int  factorial(int input){
		if(input==1){
			return input;
		}else{
			return input*factorial(input-1);
		}
	}

}
