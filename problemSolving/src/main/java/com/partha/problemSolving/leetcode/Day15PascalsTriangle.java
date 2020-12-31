package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/pascals-triangle/solution/
 * @author biswaspa
 *
 */
public class Day15PascalsTriangle {

	public static void main(String[] args) {
		new Solution1().generate(4);
	}
	
	
	/**
	 * my solution
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
	    public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        for(int i=1;i<=numRows;i++){
	            //List<Integer> sublist = new ArrayList(i);
	        	int[] subarr = new int[i];
	        	subarr[0] = 1;
	            for(int j=2;j<=subarr.length;j++){
	                if(j==subarr.length){
	                	subarr[j-1]=1;
	                }else{
	                	subarr[j-1]= result.get(i-2).get(j-2) + result.get(i-2).get(j-1);
	                    
	                }
	            }
	            
	            List<Integer> sublist = new ArrayList<>();
	            IntStream.range(0, subarr.length).forEach( m -> sublist.add(subarr[m]));
	            result.add(sublist);
	        }
	        return result;
	    }
	}

}
