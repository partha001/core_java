package com.partha.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
 * @author partha
 *
 */
public class MergeTripletstoFormTargetTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//https://www.youtube.com/watch?v=amnrMCVd2YI
	private static class Solution1 {
	    public boolean mergeTriplets(int[][] triplets, int[] target) {
	       Set<Integer> good = new HashSet();

	       //filtering out eligible triplets
	       for(int i=0;i<triplets.length;i++){
	          int[] current = triplets[i];
	          if(current[0]<=target[0] && current[1]<=target[1] && current[2]<=target[2])
	            good.add(i);         
	       }

	        boolean first=false; 
	        boolean second=false;
	        boolean third = false;
	        for(int i:good){
	            if(triplets[i][0]== target[0]) first=true;
	            if(triplets[i][1]== target[1]) second=true;
	            if(triplets[i][2]== target[2]) third=true;
	       }
	       if(first && second && third)
	            return true;
	        return false;
	    }
	}
	
	
	
	//this is a better solution
	private static class Solution2 {
	    public boolean mergeTriplets(int[][] triplets, int[] target) {
	        Set<Integer> set = new HashSet(); //to hold the indice where a match is found within a good/eligible triplet
	        for(int i=0;i< triplets.length;i++){
	            if(triplets[i][0]> target[0] || triplets[i][1]> target[1] ||  triplets[i][2]> target[2] ) //discarding the non-eligible triplets
	                continue;
	            
	            //iterating each element within eligible triplet and adding to set the index where a match is found within a triplet
	            for(int j=0;j<3;j++){
	                if(triplets[i][j]== target[j])
	                    set.add(j);
	            }
	        }
	        
	        //for a full match to happen set should have 3 elements. 
	        // since we are condisering a triplet to max 3 elements can be there and using set insures no duplicates
	        if(set.size()==3)
	            return true;
	        return false;
	    }
	}
	
	
	

}
