package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/valid-anagram/
 * @author biswaspa
 *
 */
public class Day1Problem2Anagram {

	public static void main(String[] args) {

	}

	//approach1
	 public int[] twoSum(int[] nums, int target) {	       
			int[] result = new int[2];
			boolean found= false;
			for(int i=0;i<nums.length-1;i++) {
				if(!found) {
					for(int j=i+1;j<nums.length;j++) {
						if(nums[i]+nums[j]== target) {
							result[0]=i;
							result[1]=j;
							found = true;
							break;
						}
					}

				}else {
					break;
				}
			}
			return result;
	 }

//	//approach2 since single loop
//	public static int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        Map<Integer,Integer> map = new HashMap<>();
//        
//        //inserting element into hashmap
//        for(int i=0;i<nums.length;i++){
//            map.put(nums[i],i);
//        }
//        
//        for(int i=0;i<nums.length-1;i++){
//            if(map.get(target-nums[i])!=null) {
//            	result[0]=i;
//            	result[1]=map.get(target-nums[i]);
//            	break;
//            }
//        }
//        
//        return result;
//    }

	 
}
