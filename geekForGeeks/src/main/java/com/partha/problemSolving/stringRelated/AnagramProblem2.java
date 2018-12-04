package com.partha.problemSolving.stringRelated;

import java.util.Scanner;

/**
 * anagram problem
 * this is a beter way for checking if an two strings are anagram or not
 * @author partha
 *
 */
public class AnagramProblem2 {

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

			int[] countArr=new int[256];
			for(int i=0;i<s1.length();i++){
				countArr[s1.charAt(i)]++;
				countArr[s2.charAt(i)]--;
			}


			boolean flag=true;
			for(int i=0;i<256;i++){
				if(countArr[i]!=0){
					flag=false;
					break;
				}
			}

			if(flag){
				System.out.println("entered strings are anagrams");
			}else{
				System.out.println("entered strings are not anagrams");
			}


		}else{
			System.out.println("strings are not anagram");
		}

	}

}
