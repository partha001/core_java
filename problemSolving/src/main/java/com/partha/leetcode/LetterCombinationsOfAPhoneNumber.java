package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author biswaspa
 *
 */
public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Solution1 {

		public List<String> letterCombinations(String digits) {
			List<String> result = new ArrayList<String>();
			if(digits==null || digits.length()==0)
				return result;


			Map<Character, String> maps = new HashMap<>();
			maps.put('2', "abc");
			maps.put('3', "def");
			maps.put('4', "ghi");
			maps.put('5', "jkl");
			maps.put('6', "mno");
			maps.put('7', "pqrs");
			maps.put('8', "tuv");
			maps.put('9', "wxyz");

			List<String> question = new ArrayList<>();
			for(char i: digits.toCharArray()) {
				question.add(maps.get(i));
			}

			generate(question,result,"",0,digits.length())  ;     
			return result;
		}


		private void generate(List<String> remainingList,List<String> result,String temp,int index,int maxLength){
			if(temp.length()==maxLength){
				result.add(temp);
				return;
			}

			String current = remainingList.get(index);
			for(char c: current.toCharArray()){
				generate(remainingList,result,temp + c,index+1,maxLength); 
				//note how the index is increased to read character to next list within question.
			}


		}
	}

}
