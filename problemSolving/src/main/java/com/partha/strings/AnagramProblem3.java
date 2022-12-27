package com.partha.strings;

import java.util.Scanner;

/**
 * this is another way of checking if two strings are anagrams or not
 * @author partha
 *
 */
public class AnagramProblem3 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("enter the first string");
		String s1=sc.nextLine();
		System.out.println("enter the second string");
		String s2=sc.nextLine();
		checkAnagram(s1, s2);
	}


	public static void checkAnagram(String s1, String s2){


		if(s1.length()==s2.length()){

			char[] arr=s1.toCharArray();
			StringBuilder sb=new StringBuilder(s2);
			
			boolean isAnagram=true;
			
			for(char c: arr){
				int index=sb.indexOf(""+c);
				if(index!= -1){
					 sb.deleteCharAt(index);
				}else{
					isAnagram=false;
					break;
				}
			}
			
			if(!isAnagram){
				System.out.println("strings are not anagram");
			}else{
				if(sb.length()==0){
					System.out.println("strings are anagram");
				}else{
					System.out.println("strings are not anagram");
				}
				
			}


		}else{
			System.out.println("strings are not anagram");
		}

	}

}
