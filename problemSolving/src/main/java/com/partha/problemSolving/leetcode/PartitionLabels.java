package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 * @author biswaspa
 *
 */
public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * 
	 * @author biswaspa
	 *
	 */
	class Solution {
		   public List<Integer> partitionLabels(String S) {
		       List<Integer> list = new ArrayList<>();
		        
		       if(S == null || S.length() == 0){ // case 1
		           return list;
		       }
		        
		       if(S.length() == 1){ // case 2
		           list.add(1);
		           return list;
		       }
		        
		      HashMap<Character, Integer> map = new HashMap<>(); // HashMap filled 
		      for(int i = 0;i<S.length();i++){
		          map.put(S.charAt(i), i);
		      }
		        int count = 0; int max = 0;
		        
		        for(int i = 0;i<S.length();i++){
		            
		            if(i > max){
		                list.add(count);
		                count = 0;
		            }
		            
		            if(map.get(S.charAt(i))>=max){
		                max  = map.get(S.charAt(i));
		            }
		            
		            count = count + 1;
		        }
		        list.add(count);
		        return list;
		    }
		}

}
