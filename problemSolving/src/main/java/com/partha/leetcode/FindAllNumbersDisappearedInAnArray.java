package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

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
			for(int i=0;i<nums.length;i++){

				//cant do it this way since the inplace replacement doest reflect in correct
				//int correct = nums[i]-1; 						
				//while(nums[i]!=i+1 && nums[i] != nums[correct] )

				while(nums[i]!=i+1 && nums[i] != nums[nums[i]-1] ){ //firstCondition takes care of range . while secondCondition checks if in right place
					int temp = nums[i];
					nums[i] = nums[temp-1];
					nums[temp-1] = temp;
				}
			}
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<nums.length;i++){
				if(nums[i]!=i+1){
					list.add(i+1);
				}
			}
			return list;  
		}
	}


}
