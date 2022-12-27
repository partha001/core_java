package com.partha.dynamicProgramming;

/**
 * problem statement: you are being given a postive integer N. you need to split that integer
 * into sum of atleast 2 positive integers in such a way that the splitted integers when multiplied for the
 * maximum product among all combinations
 * 
 * 
 * @author partha
 *
 */
public class NumberSplitting {

	public static void main(String[] args) {

		Solution1 solution1 = new Solution1();
		System.out.println(solution1.noSplitting(10));
	}
	
	
	private static class Solution1 {
		
		private int noSplitting(int N){
		    
		    // Initializing maxProduct array and filling all with Integer.MIN_VALUE
		    int[] maxProduct = new int[N + 1];
		    for(int i = 0; i < maxProduct.length; i++){
		        maxProduct[i] = Integer.MIN_VALUE;
		    }
		    
		    // Base cases
	        maxProduct[1] = 0;
	        maxProduct[2] = 1;
	        
	        // 'i' is for setting the number to be split
	        for(int i = 3; i <= N; i++){
	            // 'j' fixes the first split to be made
	            for(int j = 1; j <= (i - 1); j++){
	                maxProduct[i] = Math.max(j * maxProduct[i - j], Math.max(j * (i - j), maxProduct[i]));
	            }
	        }
	        return maxProduct[N];
		}
		
	}

}

