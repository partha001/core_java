package com.partha.leetcode;

/**
 * https://leetcode.com/problems/flipping-an-image/
 * @author partha
 *
 */
public class FlippingImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Solution1 {
		public int[][] flipAndInvertImage(int[][] image) {

			for(int i=0;i<image.length;i++){
				reverse(image[i]);
				invert(image[i]);
			}

			// Either can use the for loop to invert the array individually or can use in single for loop
			// for(int i=0;i<image.length;i++){
			//    invert(image[i]);
			// }

			return image;

		}

		static void reverse(int []image){
			int s=0;
			int e=image.length-1;

			while(s<e){
				int temp=image[s];
				image[s] = image[e];
				image[e] = temp;
				s++;
				e--;
			}
		}

		static void invert(int []arr){
			for(int i=0;i<arr.length;i++){
				if(arr[i]==0){
					arr[i]=1;
				}
				else{
					arr[i]=0;
				}
			}
		}
	}


	private static class Solution2{
		public int[][] flipAndInvertImage(int[][] image) {
			int r = image.length, c = image[0].length;
			int ans[][] = new int[r][c];
			for(int i = 0; i < r; i++)
				ans[i] = reverse(image[i]);
			return ans;
		}
		public int[] reverse(int a[]){
			int ans[] = new int[a.length];
			int n = a.length;
			for(int i = 0; i < n; i++)
				ans[i] = a[n - 1 - i] == 0 ? 1 : 0;
			return ans;
		}
	}

}
