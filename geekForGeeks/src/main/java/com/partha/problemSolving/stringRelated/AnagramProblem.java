package com.partha.problemSolving.stringRelated;

import java.util.Scanner;

/**
 * anagram problem
 * this solution works fine for strings with non-repeating characters
 * @author partha
 *
 */
public class AnagramProblem {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("enter the first string");
		String s1=sc.nextLine();
		System.out.println("enter the second string");
		String s2=sc.nextLine();

		boolean isAnagram=true;


		if(s1.length()==s2.length()){
		
			for(int i=0;i<s1.length();i++){
				boolean found=false;
				for(int j=0;j<s2.length();j++){
					if(s1.charAt(i)==s2.charAt(j)){
						found=true;
						break;
					}
				}

				if(!found){
					isAnagram=false;
					break;
				}

			}

			System.out.println(isAnagram? "strings are anagram":"strings are not anagram");


		}else{
			System.out.println("strings are not anagram");
		}


	}

}
