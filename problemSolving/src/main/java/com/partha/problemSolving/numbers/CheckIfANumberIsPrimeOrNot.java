package com.partha.problemSolving.numbers;

import java.util.Scanner;

/**
 * checking with condition that a prime 6N+1= 
 * @author partha
 *
 */
public class CheckIfANumberIsPrimeOrNot {

	public static void main(String[] args) {
		System.out.println("enter any integer");
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		if(n == 2)
			System.out.println("it is a prime number");
		else if( n ==3 )
			System.out.println("it is a prime number");
		else{
			boolean flag = false;
			if(((n-1)/6) %1 == 0)
				flag = true;
			else if(((n+1)/6) %1 == 0)
				flag = true;
			
			System.out.println( flag ? "it is prime" : "it is not a prime");
		}
	}

}
