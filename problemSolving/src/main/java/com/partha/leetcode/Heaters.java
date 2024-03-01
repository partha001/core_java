package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/heaters/
 * @author partha
 *
 */
public class Heaters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * naive solution
	 * TC: O(n * m)
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    public int findRadius(int[] houses, int[] heaters) {    
	        // calculate the minimum distance to each heater for each house.
	        // get the maximum of the minimum
	        // assume heaters and houses are sorted
	        int maxMin = Integer.MIN_VALUE;
	        for(int h : houses){
	            int houseMin = Integer.MAX_VALUE;
	            for(int heater : heaters){
	                houseMin = Math.min(Math.abs(heater - h), houseMin);
	            }
	            if(houseMin > maxMin) maxMin = houseMin;
	        }
	        return maxMin;
	    }
	}
	
	
	/**
	 * TC: nlogn
	 * @author partha
	 * sort + 2 pointer approach
	 * referrence video: https://www.youtube.com/watch?v=xR2SzAmiUpM
	 *
	 */
	private static class Solution2 {
	    public int findRadius(int[] houses, int[] heaters) {
	        if(houses == null || houses.length == 0 || heaters == null || heaters.length == 0){
	            return 0;
	        }
	        
	        Arrays.sort(houses);
	        Arrays.sort(heaters);
	        
	        int n = houses.length;
	        int m = heaters.length; 
	        
	        int i = 0;
	        int j = 0;
	        
	        int res = 0;
	        while(i < n && j < m){
	            // for each heaters[j],  compare to heaters[j + 1]
	            int dist1 = Math.abs(heaters[j] - houses[i]);
	            int dist2 = Integer.MAX_VALUE;
	            if(j + 1 < m){
	                dist2 = Math.abs(heaters[j + 1] - houses[i]);
	            }
	            // if j closer to i than j + 1, settle and i ++;
	            if(dist1 < dist2){
	                res = Math.max(res, dist1);
	                i++;
	            // else j++;
	            }else{
	                j++;
	            }
	        }
	        
	        return res;
	        
	    }
	}
	
	
	/**
	 * TC O(nlogm)
	 * @author partha
	 * sort + binary search
	 *
	 */
	private static class Solution {
	    public int findRadius(int[] houses, int[] heaters) {
	        Arrays.sort(houses);
	        Arrays.sort(heaters);
	        int left = 0;
	        int right = Integer.MAX_VALUE;
	        int answer = 0;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
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
