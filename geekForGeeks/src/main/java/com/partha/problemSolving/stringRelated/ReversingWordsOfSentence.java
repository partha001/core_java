package com.partha.problemSolving.stringRelated;

/**
 * reversing words in a sentence 
 * example input : india is my country
 * example output : country my is india 
 * @author partha
 *
 */
public class ReversingWordsOfSentence {

	public static void main(String[] args) {
		String sentence="india is my country";
		System.out.println(reverseWords(sentence));
	}


	public static String reverseWords(String sentence){
		String[] arr = sentence.split("\\s");
		StringBuilder reverseString=new StringBuilder();
		
//		for(int i=arr.length-1;i>=0;i--){
//						//either use this 
//						if(i!=0)
//							reverseString.append(arr[i]+" ");
//						else
//							reverseString.append(arr[i]); 
//			reverseString.append(i!=0 ? arr[i]+" " :  arr[i]);
//		}


		for(int i=arr.length-1;i>=0;i--)
			reverseString.append(i!=0 ? arr[i]+" " :  arr[i]);

		return reverseString.toString();
	}

}
