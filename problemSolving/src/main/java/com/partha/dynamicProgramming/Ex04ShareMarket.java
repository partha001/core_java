package com.partha.dynamicProgramming;

/**
 * @problemStatement you are being given an arrray in which the i'th element is th price of a given stock on a day 'i'.
 * if you are permitted to complete at most 1 transaction (i.e. buy once and sell once), what is the maximum profit you can gain?
 * it is to be noted tht you cannot sell a stock before you buy one
 * @author partha
 *
 */
public class Ex04ShareMarket {

	public static void main(String[] args) {

		Ex04ShareMarket sm = new Ex04ShareMarket();
		int[] price = {8, 1, 2, 4, 6, 3};
		int size = 6;
		System.out.println("Maximum profit that we can gain from price array {8, 1, 2, 4, 6, 3} is " + sm.maxProfit(price, size));
	}



	private int maxProfit(int[] price, int n){

		// Initializing all the arrays and variables
		int[] minUptil = new int[n];
		int[] maxProfit = new int[n];
		int highestProfit = Integer.MIN_VALUE;



		// Min price uptil 0th day is Price[0]
		minUptil[0] = price[0];

		// Filling the minUptil array
		for(int i = 1; i <= n - 1; i++){
			minUptil[i] = Math.min(minUptil[i - 1], price[i]);
		}


		// Filling the maxProfit array
		for(int i = 0; i <= n - 1; i++){
			maxProfit[i] = price[i] - minUptil[i];
			if(highestProfit < maxProfit[i]){
				highestProfit = maxProfit[i];
			}
		}

		return highestProfit;
	}






}
