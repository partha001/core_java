package com.partha.recursion;

public class Rec01SumOfNNaturalNumbers {

	public static void main(String[] args) {
		System.out.println(sum(4));
	}
	
	
	public static int sum(int n) {
		if(n>=0) {
			return n+sum(n-1);
		}else {
			return 0;
		}
	}

}
