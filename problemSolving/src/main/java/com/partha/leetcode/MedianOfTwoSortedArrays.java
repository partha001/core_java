package com.partha.leetcode;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * @author biswaspa
 *
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		new Solution1().findMedianSortedArrays(new int[] {1,2}, new int[] {3,4});
	}

	/**
	 * brute force approach .
	 * timeComplexity = O(m+n) spaceComplexity= O(m+n)
	 * @author biswaspa
	 *
	 */
	private static class Solution1{

		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int length = nums1.length + nums2.length;
			int[] arr = new int[length];
			int i=0 ,j=0, k=0;

			while(i<nums1.length && j<nums2.length) {
				if(nums1[i]<=nums2[j]) {
					arr[k] = nums1[i];
					i++;
				}else {
					arr[k]=nums2[j];
					j++;
				}
				k++;
			}


			while(i<nums1.length) {
				arr[k] = nums1[i];
				i++;
				k++;
			}


			while(j<nums2.length) {
				arr[k] = nums2[j];
				j++;
				k++;
			}

			double median =0;
			if(length%2==0) {
				int mid = length/2;
				double v1 = arr[mid-1];
				double v2 = arr[mid];
				median = (v1 + v2)/2;
			}else {
				int mid = length/2;
				median = arr[mid];
			}
			return median;
		}
	}



	/**
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	 *
	 * Solution
	 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
	 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
	 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
	 *
	 * Time complexity is O(log(min(x,y))
	 * Space complexity is O(1)
	 *
	 * https://leetcode.com/problems/median-of-two-sorted-arrays/
	 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
	 */
	private static class Solution2 {

		public double findMedianSortedArrays(int input1[], int input2[]) {
			//if input1 length is greater than switch them so that input1 is smaller than input2.
			if (input1.length > input2.length) {
				return findMedianSortedArrays(input2, input1);
			}
			int x = input1.length;
			int y = input2.length;

			int low = 0;
			int high = x;
			while (low <= high) {
				int midX = (low + high)/2;
				int midY = (x + y + 1)/2 - midX;

				//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
				//if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
				int maxLeftX = (midX == 0) ? Integer.MIN_VALUE : input1[midX - 1];
				int minRightX = (midX == x) ? Integer.MAX_VALUE : input1[midX];

				int maxLeftY = (midY == 0) ? Integer.MIN_VALUE : input2[midY - 1];
				int minRightY = (midY == y) ? Integer.MAX_VALUE : input2[midY];

				if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
					//We have partitioned array at correct place
					// Now get max of left elements and min of right elements to get the median in case of even length combined array size
					// or get max of left for odd length combined array size.
					if ((x + y) % 2 == 0) {
						return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
					} else {
						return (double)Math.max(maxLeftX, maxLeftY);
					}
				} else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
					high = midX - 1;
				} else { //we are too far on left side for partitionX. Go on right side.
					low = midX + 1;
				}
			}

			//Only we we can come here is if input arrays were not sorted. Throw in that scenario.
			throw new IllegalArgumentException();
		}

	}

}
