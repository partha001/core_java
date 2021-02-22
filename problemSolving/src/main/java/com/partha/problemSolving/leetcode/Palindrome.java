package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * @author biswaspa
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		//solution1.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(solution1.isPalindrome("A man,opnama"));
		
	}
	
	/**
	 * @author biswaspa mysolution
	 *
	 */
	
	static class Solution1 {
	    public boolean isPalindrome(String s) {
	        if(s==null || s.length()<=1){
	            return true;
	        }
	        
	        String input = s.toLowerCase();
	        char[] arr = input.toCharArray();
	        int start=0;
	        int end=input.length()-1;
	        //System.out.println(arr.length-1);
	        while(start<end){
	            boolean startValid = isValidCharacter(arr[start]);
	            boolean endValid = isValidCharacter(arr[end]);
	            if(startValid && endValid) {
	            	 if(arr[start]==arr[end]){
	 	                start++;
	 	                end--;
	 	            }else{
	 	                return false;
	 	            }
	            }
	            	            
	            if(!startValid){
	                start++;
	            }
	            if(!endValid){
	                end--;
	            }
	        }
	        System.out.println("while complte");
	        return true;
	    }
	    
	    
	    private boolean isValidCharacter(char c){
	        int startAscii = 'a';
	        int endAscii = 'z';
	        int currentAscii = c;
	        if((startAscii<=currentAscii && currentAscii<=endAscii) 
	        		|| (48<=currentAscii && currentAscii<=57)){
	            return true;
	        }else {
	            return false;
	        }
	    }
	}
	
	
	/**
	 * this is a more optimised solution
	 * @author biswaspa
	 *
	 */
	static class Solution2 {
		    public boolean isPalindrome(String s) {
		        if (s.length() <= 1) {
		            return true;
		        }
		        char[] palindrome = s.toCharArray();
		        int start = 0; 
		        int end = palindrome.length - 1;
		        while (start <= end) {
		            while ((!Character.isLetter(palindrome[start]) &&                                                   !Character.isDigit(palindrome[start]))
		                   && end - start != 0) {
		                start++;
		                System.out.println("increased");
		            }
		            while ((!Character.isLetter(palindrome[end]) &&                                                     !Character.isDigit(palindrome[end]))
		                  && end - start != 0) {
		                end--;
		                System.out.println("decreased");
		            }
		            if (Character.toLowerCase(palindrome[start]) != 
		                Character.toLowerCase(palindrome[end])) {
		                return false;
		            } else {
		                start++;
		                end--;
		            }
		            System.out.println(start + " " + end);
		        }
		        return true;
		    }
		}
	

}
