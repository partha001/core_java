package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * @author biswaspa
 *
 */
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		new Solution1().titleToNumber("A");
	}
	
	static class Solution1 {
	    public int titleToNumber(String input) {      
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

}
