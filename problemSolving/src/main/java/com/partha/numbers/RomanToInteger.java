package com.partha.numbers;

/**
 * @problemDefinition : https://leetcode.com/problems/roman-to-integer/
 * @leetCodeProbNumber : 13
 * @author partha
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		String romanInput = "MCMXCIV";
		convertRomanToInteger(romanInput.toUpperCase());
	}

	public static void convertRomanToInteger(String s){
		int result =0;
		int lastInteger = 0;
		char[] arr = s.toCharArray();
		int arrLength = arr.length;

		for(int i=arrLength-1;i>=0;i--){
			char currentChar = arr[i];
			int currentCharToInt = romanCharToInteger(""+currentChar);
			if(i==(arrLength-1)){
				result = result + currentCharToInt;
			}else{
				if(currentCharToInt >= lastInteger){
					result = result  + currentCharToInt;
				}else {
					result =    result - currentCharToInt;
				}
			}
			lastInteger = currentCharToInt;
		}

		System.out.println(result);
	}


	/*	conversion table
	Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	 */
	public static int romanCharToInteger(String s){
		switch(s){
		case("I"):
			return 1;
		case("V"):
			return 5;
		case("X"):
			return 10;
		case("L"):
			return 50;
		case("C"):
			return 100;
		case("D"):
			return 500;
		case("M"):
			return 1000;
		default:
			throw new RuntimeException();
		}
	}

}
