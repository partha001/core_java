package com.partha.problemSolving.recursion;

public class Rec03Exponent {

	public static void main(String[] args) {
		System.out.println(calculateExponent(4, 2));
	}

	public static int calculateExponent(int n,int m) {
		if(n==0) {
			return 1;
		}
		else if(n==1) {
			return m;
		}else {
			return m*calculateExponent(n-1,m);
		}
	}

}
