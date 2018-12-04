package com.partha.problemSolving.stringRelated;

import java.util.Scanner;

/**
 * this is to check if a string is palindrome or not
 * @author partha
 *
 */
public class PalindromeApplication {

	public static void main(String[] args) {

		
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the  String");
		String s1=sc.nextLine();
		
		boolean flag=true;
		char[] charArray = s1.toCharArray();
		if(s1.length()%2==0){
			for(int i=0;i<(charArray.length/2);i++){
				if(charArray[i]!=charArray[charArray.length-1-i]){
					flag=false;
					break;
				}
			}
		}else{
			int mid=charArray.length/2;
			for(int i=0;i<=mid;i++){
				if(charArray[i]!=charArray[charArray.length-1-i]){
					flag=false;
					break;
				}
			}
		}
		System.out.println( flag? "it is palidrome":"it is not palindrome");
		
		
	}

}
