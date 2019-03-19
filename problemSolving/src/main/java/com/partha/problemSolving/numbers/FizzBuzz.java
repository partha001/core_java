package com.partha.problemSolving.numbers;


/**
 * @problemstatement: Write a program that outputs the string representation of numbers from 1 to n.<br>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of <br>
 * five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.<br>
 * @author parbiswa
 *
 */
public class FizzBuzz {

	public static void main(String[] args) {
		int enteredNumber = 15;
		method1(enteredNumber);
	}
	
	public static void method1(int n){
		for(int i=1;i<=n;i++){
			if(i%3==0 && i%5==0)
				System.out.println("FizzBuzz");
			else if(i%5 == 0)
				System.out.println("Buzz");
			else if(i%3==0)
				System.out.println("Fizz");
			else 
				System.out.println(i);
		}
		
	}

}
