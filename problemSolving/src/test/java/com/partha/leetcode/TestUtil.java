package com.partha.leetcode;

import com.github.javafaker.Faker;

public class TestUtil {
	
	private static Faker faker = new Faker();
	
	static class TestArray {
		int rows;
		int cols;
		int[][] arr;
	}
	
	/**
	 * 
	 * @param minElement inclusive
	 * @param maxElement exclusive
	 * @return
	 */
	public static TestArray getTest2dArray(int minElement,int maxElement) {
		TestArray array = new TestArray();
		int rows = faker.number().randomDigit();
		int cols = faker.number().randomDigit();
		array.rows = rows;
		array.cols = cols;
		int[][] arr = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				arr[i][j] = faker.number().numberBetween(minElement, maxElement);
			}
		}
		array.arr = arr;
		return array;		
	}
	
	
	
}
