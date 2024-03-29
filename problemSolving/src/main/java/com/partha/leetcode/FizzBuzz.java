package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {

	}
	
	/**
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
	    public List<String> fizzBuzz(int n) {
	        List<String> list = new ArrayList<>();
	        for(int i=1;i<=n;i++){
	            if(i%5==0 && i%3==0){
	                list.add("FizzBuzz");
	            }else if(i%5==0){
	                list.add("Buzz");
	            }else if(i%3 == 0){
	                list.add("Fizz");
	            }else {
	                list.add(""+i);
	            }
	        }
	        return list;
	    }
	}
	
	
	

}
