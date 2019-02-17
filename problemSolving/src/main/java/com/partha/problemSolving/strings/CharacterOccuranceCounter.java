package com.partha.problemSolving.strings;

import java.util.Scanner;

/**
 * counts character occurance using simply array and asci
 * @author partha
 *
 */
public class CharacterOccuranceCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any string");
		String enteredString=sc.nextLine();
		getOccuringChar(enteredString);


	}
	
	
	static void getOccuringChar(String enteredString){
		//initializing the array that will contain the count against asci value as index
		int[] countArr=new int[256];
		//updating the array
		for(int i=0;i<enteredString.length();i++)
			countArr[enteredString.charAt(i)]++;
		
		char[] charArr= new char[enteredString.length()];
		for(int i=0;i<enteredString.length();i++){
			
			char currentChar=enteredString.charAt(i);
			charArr[i]=currentChar;	
			
			int found=0;
			for(int j=0;j<charArr.length;j++){
				if(currentChar==charArr[j])
					found++;
			}
						
			if(found==2){
				System.out.println(currentChar +" occurs "+ countArr[currentChar]);
				
			}
			
		}
	}

}
