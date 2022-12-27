package com.partha.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number
 * @author partha
 *
 */
public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private static class Solution1 {
		// Custom sort numbers: Ot(n * log2(n)), Os(n)
		public static String largestNumber(int[] nums) {
			//assert nums != null && nums.length > 0;

			String[] strs = new String[nums.length];
			for (int i = 0; i < nums.length; i++) {
				strs[i] = String.valueOf(nums[i]);
			}

			//sorting with string concatenated comparison
			Arrays.sort(strs, (s1,s2) -> {
				return (s2 + s1).compareTo(s1 + s2);
			});    // With concatenated comparison

			// Skip leading zeroes
			if (strs[0].equals("0")) {
				return "0";
			}

			// Concatenate number strings
			StringBuilder sb = new StringBuilder();
			for (String s : strs) {
				sb.append(s);
			}

			return sb.toString();
		}
	}



	private static class Solution2 {
		// Custom sort numbers: Ot(n * log2(n)), Os(n)
		public static String largestNumber(int[] nums) {
			assert nums != null && nums.length > 0;

			String[] strs = new String[nums.length];
			for (int i = 0; i < nums.length; i++) {
				strs[i] = String.valueOf(nums[i]);
			}

			Arrays.sort(strs, new NumberStringComparator1());   // With recursive comparison

			// Skip leading zeroes
			if (strs[0].equals("0")) {
				return "0";
			}

			// Concatenate number strings
			StringBuilder sb = new StringBuilder();
			for (String s : strs) {
				sb.append(s);
			}

			return sb.toString();
		}

		static class NumberStringComparator1 implements Comparator<String> {

			@Override
			public int compare(String s1, String s2) {
				int index1 = 0, index2 = 0;
				while (index1 < s1.length() && index2 < s2.length()) {
					int digit1 = s1.charAt(index1) - '0', digit2 = s2.charAt(index2) - '0';
					if (digit1 != digit2) {
						return Integer.compare(digit2, digit1);
					}

					index1++;
					index2++;
				}

				// KEY: Recursive comparison, if prefixes are identical
				if (index1 < s1.length()) {
					return compare(s1.substring(index1), s2);
				} else if (index2 < s2.length()) {
					return compare(s1, s2.substring(index2));
				} else {
					return 0;
				}
			}
		}

	}

}
