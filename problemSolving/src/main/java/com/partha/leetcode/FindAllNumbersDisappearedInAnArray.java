package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author partha
 *
 */
public class FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		new FindAllNumbersDisappearedInAnArray.Solution1().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});

	}


	private static class Solution1 {
		public List<Integer> findDisappearedNumbers(int[] nums) {
			int i=0;
			while(i<nums.length){
				// correct is the index where the ith element should actually be
				int correct = nums[i] - 1;
				if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[correct]){ 
					/* First condition: Ignoring the negatives Second condition: If element=length of the array, just ignore it and move ahead */
					swap(nums,i,correct); // swap if not at the correct position
				}else{
					i++; // else move ahead
				}
			}

			//IntStream.range(0,nums.length).forEach(m-> System.out.println(nums[m]));
			List<Integer> list = new ArrayList<>();
			for(int a=0;a<nums.length;a++){
				if(nums[a]!=a+1){
					list.add(a+1);
				}
			}
			return list;
		}

		private void swap(int[] nums,int x, int y){
			int temp = nums[x];
			nums[x] = nums[y];
			nums[y] = temp;
		}
	}


}
