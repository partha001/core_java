package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/heaters/
 *
 * @author partha
 */
public class Heaters {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


    /**
     * naive solution
     * TC: O(n * m)
     *
     * @author partha
     */
    private static class Solution1 {
        public int findRadius(int[] houses, int[] heaters) {
            // calculate the minimum distance to each heater for each house.
            // get the maximum of the minimum
            // assume heaters and houses are sorted
            int maxMin = Integer.MIN_VALUE;
            for (int h : houses) {
                int houseMin = Integer.MAX_VALUE;
                for (int heater : heaters) {
                    houseMin = Math.min(Math.abs(heater - h), houseMin);
                }
                if (houseMin > maxMin) maxMin = houseMin;
            }
            return maxMin;
        }
    }


    /**
     * TC: nlogn
     *
     * @author partha
     * sort + 2 pointer approach
     * referrence video: https://www.youtube.com/watch?v=xR2SzAmiUpM
     */
    private static class Solution2 {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int m = houses.length;
            int n = heaters.length;
            int i = 0; //house index
            int j = 0; //heater index
            int result = 0;
            while (i < m && j < n) { // for each heaters[j],  compare to heaters[j + 1]
                int dist1 = Math.abs(houses[i] - heaters[j]);
                int dist2 = Integer.MAX_VALUE;
                if (j + 1 < n) {
                    dist2 = Math.abs(houses[i] - heaters[j + 1]);
                }

                if (dist1 < dist2) {
                    result = Math.max(result, dist1);
                    i++;
                } else {
                    j++;
                }
            }
            return result;
        }
    }


    /**
     * TC O(nlogm)
     *
     * @author partha
     * sort + binary search
     */
    private static class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int left = 0;
            int right = Integer.MAX_VALUE;
            int answer = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (canHeat(houses, heaters, mid)) {
                    answer = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return answer;
        }

        public boolean canHeat(int[] houses, int[] heaters, int distance) {
            int p1 = 0;
            int p2 = 0;
            while (p1 < houses.length && p2 < heaters.length) {
                if (houses[p1] >= heaters[p2] - distance && houses[p1] <= heaters[p2] + distance) {
                    p1++;
                } else {
                    p2++;
                }
            }
            return p1 >= houses.length;
        }
    }


}
