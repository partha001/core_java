package com.partha.leetcode;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii
 * @author partha
 *
 */
public class BeautifulArragement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution1 {
	    public int[] constructArray(int n, int k) {
	        int diff = n - k;
	        int lo = 1;
	        int hi = n;
	        int[] out = new int[n];
	        int i = 0; 
			// we generate a difference of 1 between subsequent elements for the first n-k times.
	        while(i < diff){
	            out[i] = lo;
	            lo++;
	            i++;
	        }
	        boolean flag = true;
			//Now we go zig zag to generate k unique differences, the last one will be automatically taken care
			//as the difference between last two elements will be one which we have already generated above.
	        for( ; i < n ; i++){
				//flag to alternatively zig zag
	            if(flag){
	                out[i] = hi;
	                hi--;
	                flag = false;
	            }
	            else{
	                out[i] = lo;
	                lo++;
	                flag = true;
	            }
	        }
	        return out;
	    }
	}

}
