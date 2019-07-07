package com.partha.problemSolving.arrays;

/**
 * source: https://www.geeksforgeeks.org/trapping-rain-water/
 * timecomplexity :O(n) .
 * this is the efficient solution
 * @author partha
 *
 */
public class TrappingRainWater2 {

	public static void main(String[] args) {
		 int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		 System.out.println("Maximum water that can be accumulated is " +  
                 findWater(arr)); 
	}
	
	
	// Method for maximum amount of water 
    static int findWater(int[] arr) 
    { 
    	int n = arr.length;
    	
    	// initialize output 
        int result = 0; 
           
        // maximum element on left and right 
        int left_max = 0, right_max = 0; 
           
        // indices to traverse the array 
        int lo = 0, hi = n-1; 
           
        while(lo <= hi)  
        { 
            if(arr[lo] < arr[hi]) 
            { 
                if(arr[lo] > left_max) 
      
                // update max in left 
                left_max = arr[lo]; 
                else
      
                // water on curr element =  
                // max - curr 
                result += left_max - arr[lo]; 
                lo++; 
            } 
            else
            { 
                if(arr[hi] > right_max) 
                  
                // update right maximum 
                right_max = arr[hi]; 
                  
                else
                result += right_max - arr[hi]; 
                hi--; 
            } 
        } 
           
        return result; 
    } 

}
