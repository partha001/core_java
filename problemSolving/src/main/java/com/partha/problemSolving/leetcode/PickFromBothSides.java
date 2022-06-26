package com.partha.problemSolving.leetcode;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/pick-from-both-sides/
 * @author partha
 *
 */
public class PickFromBothSides {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// A = [5, -2, 3 , 1, 2]
	// B = 3
	//result = 8;


	private static class Solution {
		public int solve(ArrayList<Integer> A, int B) {
			int allLeft =0;
			for(int i=0;i<B;i++){
				allLeft += A.get(i);          
			}

			int result = allLeft;

			int bIndex = B-1;
			int left = A.size()-1;
			for(int i=0;i<B;i++) {
				allLeft = allLeft - A.get(bIndex-i) + A.get(left-i);
				result = Math.max(result, allLeft);
			}        

			return result;  

		}
	}



}
