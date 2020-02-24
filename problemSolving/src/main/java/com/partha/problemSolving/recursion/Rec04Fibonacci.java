package com.partha.problemSolving.recursion;

public class Rec04Fibonacci {

	public static void main(String[] args) {
		System.out.println(0);
		System.out.println(1);
		printFibonacci(10, 3, 0, 1);
	}

	public static void printFibonacci(int total,int current,int a, int b) {
		if(current<=total) {
			int c= a+b;
			System.out.println(c);
			a = b;
			b = c;
			current++;
			printFibonacci(total, current, a, b);
		}
	}

}



