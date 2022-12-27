package com.partha.strings;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * leet code problem : 171
 * @author partha
 *
 */
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		String input = "ZY";
		System.out.println("result is = "+calculate(input));
		
	}
	
	
	public static int calculate(String input){
		if(input==null || input.length()==0){
			return -1;
		}else{
			int sum =0 ;
			for(int i=0;i < input.length();i++){
				sum *=26;
				sum += input.charAt(i) - 'A'  + 1;
			}
			return sum;
		}
	}

}
