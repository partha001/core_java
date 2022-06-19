package com.partha.problemSolving.leetcode;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * @author partha
 *
 */
public class MinimumNumberOfPlatforms {

	public static void main(String[] args) {

		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
	    int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
	    
	    System.out.println( new Solution2().findPlatforms(arr, dep, 6));
	    
	}
	
	
	
	
	/**
	 * timeComplexity : O(n^n)
	 * @author partha
	 *
	 */
	private static class Solution1 {
		
		
		public int findPlatforms(int[] arr,int[] dep,int n) {
			if(n==0)
				return 0;
			
			int result = 1;
			for(int i=0;i<n;i++) {
				int platform =1;
				for(int j=i+1;j<n;j++) {
					if ((dep[j]>arr[i] && dep[j]<=dep[i]) || //dep[j] falls within the limits of trainI
							(arr[j]>=arr[i] && arr[j]<=dep[i]) //when arr[j] falls within limits of trainI
							)
						platform++;
				}
				result = Math.max(result, platform);
			}			
			return result;
		}	
	}
	
	
	
	
	/**
	 * O(nlogn)
	 * @author partha
	 * explanation : https://www.youtube.com/watch?v=38JLfQGVlkw
	 *
	 */
	private static class Solution2 {
		
		public int findPlatforms(int[] arr,int[] dep,int n) {
			if(n==0)
				return 0;
			
			Arrays.sort(arr);
			Arrays.sort(dep);
			int result=1;
			int platforms=1;
			int i=1;  //pointer for arrival array
			int j=0;  //pointer for departure array
			while(i<n && j<n) {
				if(arr[i]<=dep[j]) {
					platforms++;
					i++;
				}else {
					platforms--;
					j++;
				}
				result = Math.max(result, platforms);
			}			
			return result;
		}
	}
	
}
