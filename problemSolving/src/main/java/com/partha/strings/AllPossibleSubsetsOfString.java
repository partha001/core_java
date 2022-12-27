package com.partha.strings;

/**
 * this progrma shows how to find String combination or all possible subsets of a 
 * given string. 1.also assume that there is repetation of characters in string
 * @author parbiswa
 *
 */
public class AllPossibleSubsetsOfString {

	public static void main(String[] args) {

	}

}

/**
 * thus if the input is AABC
 * then output will be 
 * ""
 * A
 * AA
 * AAB
 * AABC
 * AAC
 * AB
 * ABC
 * AC
 * B
 * BC
 * C
 * 
 * algo: here we will be using recursion to calculate this
 * step1: take all distinct characters in an array  and their count i.e. occurance
**/