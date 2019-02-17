package com.partha.problemSolving.strings;

/**
 * source: https://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html
 * this is the best solution which involves loop and recursion
 * @author partha
 *
 */
public class Permutation02 {

	public static void main(String[] args) {
		 permutation("","GOD");
	}

	/*
	  * A method exposed to client to calculate permutation of String in Java. 
	  */
//	   public static void permutation(String input){
//	          permutation("", input);
//	   }

	   /*
	    * Recursive method which actually prints all permutations
	    * of given String, but since we are passing an empty String
	    * as current permutation to start with,
	    * I have made this method private and didn't exposed it to client. 
	    */
	   private static void permutation(String perm, String word) {
	        if (word.isEmpty()) {
	            System.out.println(perm + word);

	        } else {
	            for (int i = 0; i < word.length(); i++) {
//	            	if(i==1)
//	            		System.out.println("");
	                permutation(perm + word.charAt(i), word.substring(0, i) 
	                                        + word.substring(i + 1, word.length()));
	            }
	        }

	    }



}
