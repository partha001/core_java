package com.partha.problemSolving.leetcode;

/**
 * link : https://leetcode.com/problems/plus-one/submissions/
 * @author biswaspa
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		System.out.println(new Solution3().maxProfit(new int[] {7,1,5,3,6,4}));
		
		//new Solution2().maxProfit(new int[] {});

	}
	


	/**
	 * timecomplexity: O(n^2)
	 * memoryComplexity: O(1)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
		 public int maxProfit(int[] prices) {
			 int maxProfit = 0;
			 for(int i=1;i<prices.length;i++) {
				 for(int j=0;j<i;j++) {
					 if(prices[i]-prices[j]>maxProfit) {
						 maxProfit = prices[i]-prices[j];
					 }
				 }
			 }
			 return maxProfit;
		 }
	}
	
	
	/**
	 * brining down be time complexity to O(n) by momoisation by taking two arrays
	 */
	static class Solution2 {
		
		 public int maxProfit(int[] prices) {
			 
			 //corner cases
			 if(prices.length<=1) {
				 return 0;
			 }
			 
			 //this is to store the min till i-th element
			 int minarr[] = new int[prices.length];
			 minarr[0]=prices[0];
			 for(int i=1;i<prices.length;i++) {
				 minarr[i] = Math.min(prices[i], minarr[i-1]);
			 }
			 
			 int[] profitArr = new int[prices.length];
			 profitArr[0]=0; //since item needs to be bought first before selling
			 for(int i=1;i<profitArr.length;i++) {
				 profitArr[i] = prices[i]-minarr[i-1];
			 }
			 
			 
			 int maxProfit=profitArr[0];
			 for(int i=1;i<profitArr.length;i++) {
				 if(maxProfit<profitArr[i]) {
					 maxProfit = profitArr[i];
				 }
			 }
			 return maxProfit;		 
			 
		 }
	}
	
	
	/**
	 * furthur reducing memory complexity by reducing above two arrays using 2 variables. 
	 * thus am not storing the max profit at every element level 
	 * @author biswaspa
	 *
	 */
	static class Solution3{
		
		 public int maxProfit(int[] prices) {
			 
			 if(prices.length<=1)
		            return 0;
		        int maxProfit=0;
		        int minPrice=prices[0];
		        for(int i=1;i<prices.length;i++){
		           if(prices[i]>=minPrice)
		               maxProfit = Math.max(maxProfit,prices[i]-minPrice);
		            else{
		                minPrice = prices[i];
		            }
		        }
		        return maxProfit;
		 
		 }
		
	}
	
	
		
	
}
