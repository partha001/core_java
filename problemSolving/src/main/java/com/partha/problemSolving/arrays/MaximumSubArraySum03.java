package com.partha.problemSolving.arrays;

/**
 * @description: here are using devide-and-conquer approach. i.e. 
 * @complexity : O(n log n) . recursively calling itself . the time-complexity is much like merge-sort complexity calculation
 * @author partha
 * @link : https://www.youtube.com/watch?v=ohHWQf1HDfU&vl=en
 *
 */
public class MaximumSubArraySum03 {

	public static void main(String[] args) {
		int[] arr= new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSumSubarray(arr, 0, 6));
	}

	// function to return maximum number among three numbers
	static int maximum(int a, int b, int c)
	{
		if (a>=b && a>=c)
			return a;
		else if (b>=a && b>=c)
			return b;
		return c;
	}

	// function to find maximum sum of subarray crossing the middle element
	static int maxCrossingSubarray(int ar[], int low, int mid, int high)
	{
		/*
	      Initial leftSum should be -infinity.
		 */
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int i;

		/*
	      iterating from middle
	      element to the lowest element
	      to find the maximum sum of the left
	      subarray containing the middle
	      element also.
		 */
		for (i=mid; i>=low; i--)
		{
			sum = sum+ar[i];
			if (sum>leftSum)
				leftSum = sum;
		}

		/*
	      Similarly, finding the maximum
	      sum of right subarray containing
	      the adjacent right element to the
	      middle element.
		 */
		int rightSum = Integer.MIN_VALUE;
		sum = 0;

		for (i=mid+1; i<=high; i++)
		{
			sum=sum+ar[i];
			if (sum>rightSum)
				rightSum = sum;
		}

		/*
	      returning the maximum sum of the subarray
	      containing the middle element.
		 */
		return (leftSum+rightSum);
	}

	// function to calculate the maximum subarray sum
	static int maxSumSubarray(int ar[], int low, int high)
	{
		if (high == low) // only one element in an array
		{
			return ar[high];
		}

		// middle element of the array
		int mid = (high+low)/2;

		// maximum sum in the left subarray
		int maximumSumLeftSubarray = maxSumSubarray(ar, low, mid);
		// maximum sum in the right subarray
		int maximumSumRightSubarray = maxSumSubarray(ar, mid+1, high);
		// maximum sum in the array containing the middle element
		int maximumSumCrossingSubarray = maxCrossingSubarray(ar, low, mid, high);

		// returning the maximum among the above three numbers
		return maximum(maximumSumLeftSubarray, maximumSumRightSubarray, maximumSumCrossingSubarray);
	}



}
