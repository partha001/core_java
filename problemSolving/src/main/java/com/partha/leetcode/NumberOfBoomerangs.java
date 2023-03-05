package com.partha.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-boomerangs
 * @author partha
 *
 */
public class NumberOfBoomerangs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * 
	 * TC O(n^2)
	 * SC O(n^2)
	 * @author partha
	 * easy to read solution
	 */
	private static class Solution1 {
	    public long getDist(int i,int j,int arr[][]){
	        long a1=(long)arr[i][0];
	        long a2=(long)arr[j][0];
	        long b1=(long)arr[i][1];
	        long b2=(long)arr[j][1];
	        return (a1-a2)*(a1-a2)+(b1-b2)*(b1-b2);
	    }
	    public int numberOfBoomerangs(int[][] arr) {
	        int result=0;
	        for(int i=0;i<arr.length;i++){
	            Map<Long,Integer>map=new HashMap<>();
	            for(int j=0;j<arr.length;j++){
	                long dist=getDist(i,j,arr);
	                map.put(dist,map.getOrDefault(dist,0)+1);
	            }
	            for(int v:map.values())
	                result+=v*(v-1);
	        }
	        return result;
	    }
	}
	
	/**
	 * TC O(n^2)
	 * SC O(n^2)
	 * @author partha
	 * same as above written differently
	 *
	 */
	private static class Solution2 {
	    public int numberOfBoomerangs(int[][] points) {
	        int ans = 0;
	        for(int i = 0; i<points.length ; i++){
	            HashMap<Integer, Integer> mp=new HashMap();
	            for(int j = 0; j<points.length; j++){
	                if(i == j) continue;
	                int key = (int)Math.pow(points[i][1]-points[j][1],2) + (int)Math.pow(points[i][0]-points[j][0],2);
	                if(mp.containsKey(key)) mp.put(key, mp.get(key)+1);
	                else mp.put(key,1);
	            } 
	            for(int j:mp.keySet()){
	                ans += ((mp.get(j) - 1)*(mp.get(j)))/2;
	            }
	        }
	        return ans*2;
	    }
	}


}
