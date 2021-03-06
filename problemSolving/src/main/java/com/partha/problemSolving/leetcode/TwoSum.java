package com.partha.problemSolving.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * two sum problem 
 * https://leetcode.com/problems/two-sum/
 * @author biswaspa
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		System.out.println(new Solution4().twoSum(new int[] {1,2,3,4}, 7));
	}

	/**
	 * method : brute-force
	 * TimeComplexity : O(nxn)
	 * MemoryComplexity : O(1)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
		
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

	}


	/**
	 * method: two pass
	 * TimeComplexity : O(n)
	 * spaceComplexity : O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution2 {
		
		public int[] twoSum(int[] nums, int target) {  

			Map<Integer, Integer> map = new HashMap<>();
			for(int i=0;i<nums.length;i++) {
				map.put(nums[i], i);
			}
			
			for(int i=0;i<nums.length;i++) {
				int current = nums[i];
				Integer number = map.get(target - current);
				if(number!=null) {
					return new int[] {i,number.intValue()};
				}
			}
			
			throw new RuntimeException("not found");
		}
		
	}
	
	
	/**
	 * method: one pass
	 * TimeComplexity : O(n)
	 * spaceComplexity : O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution3 {
		
		public int[] twoSum(int[] nums, int target) {
		    Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        if (map.containsKey(complement)) {
		            return new int[] { map.get(complement), i };
		        }
		        map.put(nums[i], i);
		    }
		    throw new IllegalArgumentException("No two sum solution");
		}
		
	}
	
	
	/**
	 * however if the array is sorted then two pointer approach can be used
	 * @author biswaspa
	 *
	 */
	static class Solution4 {
		
		public int[] twoSum(int[] nums, int target) {
			Arrays.sort(nums);
			
			int left=0;
			int right=nums.length-1;
			while(left<right) {
				int sum=nums[left]+nums[right];
				if(sum==target) {
					return new int[] {left,right};
				}else if(sum<target) {
					left++;
				}else {
					right--;
				}
			}
			throw new RuntimeException("no such pair found");
		}
	}


}
