package com.partha.problemSolving.strings;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		String input = "AA";
		method1();
		char[] arr = input.toCharArray();
		double result =0;
		for(int i=0;i< arr.length;i++){
			if(i==0){
				int val = arr[i]-64;
				result = result + val;
			}else{
				int val = arr[i]-64;
				double exponent = arr.length-i-1;
				double charWeight = Math.pow(26, exponent);
				//result = result + charWeight
			}
			
		}
		System.out.println(result);
	}
	
	
	public static void method1(){
		int a = 'A';
		System.out.println(a);
		
	}

}
