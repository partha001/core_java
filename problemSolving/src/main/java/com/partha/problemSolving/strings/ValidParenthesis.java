package com.partha.problemSolving.strings;

import java.util.Scanner;
import java.util.Stack;

/**
 * @problemDefinition : https://leetcode.com/problems/valid-parentheses/
 * @author partha
 *
 */
public class ValidParenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter any set of parenthesis without space");
		String input = sc.nextLine();
		System.out.println(checkValid(input)? "valid" : "invalid");
		
	}
	
	
	public static boolean checkValid(String input){
		boolean flag = false;
		
		Stack<Character> stack = new Stack();
		for(Character c: input.toCharArray()){
			if(stack.size()==0){
				stack.push(c);
			}else{
				if((c.toString().equals(")") && stack.peek().toString().equals("("))  
						|| (c.toString().equals("]") && stack.peek().toString().equals("[")) 
						|| (c.toString().equals("}") && stack.peek().toString().equals("{")) 
					){
					stack.pop();
				}else{
					stack.push(c);
				}
			}
		}
		
		return stack.size() == 0 ? true : false ;
	}

}
