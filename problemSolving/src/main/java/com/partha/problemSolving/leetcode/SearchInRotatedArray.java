package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @author biswaspa
 *
 */
public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * naive approach.
	 * timecomplexity : O(n)
	 * @author biswaspa
	 */
	private static class Solution1 {

		public int search(int[] nums, int target) {
			if(nums.length==0)
				return -1;

			//finding pivot
			int temp=-1;
			for(int i=1;i<nums.length;i++){
				if(nums[i]<nums[i-1])
					temp=i;
			}

			//searching on the basic of pivot
			int result = 0;
			if(temp==-1){
				result =  search(nums,0,nums.length-1,target);
			}else{
				if(target>=nums[temp] && target<=nums[nums.length-1]){
					result = search(nums,temp,nums.length-1,target);  
				}else{
					result = search(nums,0,temp-1,target);
				}
			}
			return result;

		}


		public int search(int[] nums,int start,int end, int target){
			while(start<=end){
				int mid= (start + end)  /2;
				if(nums[mid]==target){
					return mid;
				}else  if(target<nums[mid]){
					end = mid-1;
				}else{
					start = mid+1;
				}
			}
			return -1;
		}
	}



	/**
	 * timecomplexity :log(N) but lot of binary search
	 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {

		public int search(int[] nums, int target) {
			if(nums.length==0)
				return -1;

			//find pivot
			int pivot = findPivot(nums,0,nums.length-1);

			if(pivot==-1) //case : where there is no pivot
				return binarySearch(nums,target,0,nums.length-1);

			if(nums[pivot]==target) //case: where there is a valid pivot
				return pivot;

			if(nums[0]<=target)
				return binarySearch(nums,target,0,pivot-1);
			return binarySearch(nums,target,pivot+1,nums.length-1);
		}


		public int binarySearch(int[] nums,int target, int start,int end){
			if(start>end){
				return -1;
			}else{
				int mid = (start + end)/2;
				if(nums[mid]== target){
					return mid;
				}else if(nums[mid]>target){
					return binarySearch(nums,target,start,mid-1);
				}else{
					return binarySearch(nums,target,mid+1,end);
				}
			}
		}


		public int findPivot(int[] nums,int start,int end){
			if(start>end)
				return -1;
			if(start==end)
				return start;
			int mid = ( start + end ) /2 ;
			if (mid < end && nums[mid]> nums[mid+1])
				return mid;
			if(mid > start && nums[mid]<nums[mid-1])
				return mid-1;
			if( nums[start] >= nums[mid])
				return findPivot(nums, start, mid - 1);
			return findPivot(nums,mid+1,end);

		}
	}


	/**
	 * timecomplexity : logN but number of binary search is reduced and code reusage
	 * @author biswaspa
	 *
	 */
	private static class Solution3 {

		public int search(int[] nums, int target) {
			if(nums.length==-1)
				return -1;
			return findTarget(nums,target,0,nums.length-1);
		}

		private int findTarget(int[] nums, int target, int start, int end) {
			if(start>end)
				return -1;
			int mid = ( start + end )/2;			

			if(nums[mid]==target)		//case1
				return mid;

			if(nums[start]<=nums[mid]) {
				if(target<=nums[mid] && target >= nums[start])
					return findTarget(nums,target,start,mid-1);
				return findTarget(nums,target,mid+1,end);
			}

			if(target >= nums[mid] && target <= nums[end])
				return findTarget(nums, target , mid + 1, end); 
			return findTarget(nums, target , start, mid-1);
		}
	}

}
