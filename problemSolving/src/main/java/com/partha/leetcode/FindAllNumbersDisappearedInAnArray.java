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
		// TODO Auto-generated method stub

	}
	
	
	class Solution {
	    public List<Integer> findDisappearedNumbers(int[] nums) {
	      for(int i=0;i<nums.length;i++){
	          while(nums[i]!=i+1 && nums[i] != nums[nums[i]-1] ){
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
