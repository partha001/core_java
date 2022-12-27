package com.partha.leetcode;

/**
 * leetcode: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * solution : working
 * @author biswaspa
 *
 */
public class FirstAndLastPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result =new Solution2().searchRange(new int[] {5,7,7,8,8,10},8);
		System.out.println(result[0]+" "+result[1]);
	}



	private static class Solution1 {

		public static int[] searchRange(int[] nums, int target) {
			Result result = search(nums, 0, nums.length-1, target);
			if(result.found) {

				int left = result.index;	
				Result leftResult = search(nums, 0, left-1, target);
				while(leftResult.found) {
					left = leftResult.index;
					leftResult =  search(nums, 0, left-1, target);
				}

				int right = result.index;
				Result rightResult = search(nums, right+1, nums.length-1 , target);
				while(rightResult.found) {
					right = rightResult.index;
					rightResult =  search(nums, right+1, nums.length-1 , target);
				}

				return new int[] {left,right};

			}else {
				return new int[] {-1,-1};
			}
		}

		public static Result search(int nums[],int start,int end,int target) {
			if(start<=end) {
				int mid = (start + end )/2;
				if(nums[mid]==target) {
					return new Result(true,mid);
				}else if(nums[mid]>target) {
					return search(nums ,start ,mid-1 ,target );
				}else {
					return search(nums ,mid+1 ,end ,target );
				}
			}else {
				return new Result(false,-1);
			}
		}

		static class Result {
			boolean found;
			int index;

			public Result(boolean found, int index) {
				super();
				this.found = found;
				this.index = index;
			}


		}

	}





	//this is basically the same code as above just restructed.
	private static class Solution2 {
		public int[] searchRange(int[] nums, int target) {
			if(nums.length==0)
				return new int[]{-1,-1};

			int search = find(nums,0,nums.length-1,target);
			if(search==-1)
				return new int[]{-1,-1};
			int first = search;
			int last = search;
			
			int temp = first;
			while(first>=0 && temp!=-1) {
				temp = find(nums,0,first-1,target);
				first = temp!=-1 ? temp:first;
			}
			
			temp = last;
			while(last<nums.length && temp!=-1) {
				temp = find(nums,last+1,nums.length-1,target);
				last = temp!=-1 ? temp: last;
			}
					
			return new int[]{first,last};
		}




		public int find(int[] nums, int start, int end, int target){
			if(start<=end) {
				int mid = (start + end )/2;
				if(nums[mid]==target)
					return mid;
				else if (nums[mid]>target)
					return find(nums,start,mid-1,target);
				return find(nums,mid+1,end,target);
			}
				return -1;
		}   

	}


}
