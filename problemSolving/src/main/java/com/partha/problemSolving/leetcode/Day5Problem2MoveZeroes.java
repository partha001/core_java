package com.partha.problemSolving.leetcode;

import java.util.stream.IntStream;

public class Day5Problem2MoveZeroes {

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		solution1.moveZeroes(new int[] {0 , 1, 0, 2});
	}
		
		static class Solution1 {
		    public void moveZeroes(int[] nums) {
		        int zeroPointer=-1;
		        for(int i=0;i<nums.length;i++){
		            if(nums[i]==0){
		              zeroPointer = i ;
		            }else{
		                if(zeroPointer!=-1){
		                    nums[zeroPointer] = nums[i];
		                    zeroPointer = i;
		                }
		            }
		        }
		        
		        IntStream.range(0, nums.length).forEach(i -> System.out.print(nums[i]));
		    }
		}
	

}
