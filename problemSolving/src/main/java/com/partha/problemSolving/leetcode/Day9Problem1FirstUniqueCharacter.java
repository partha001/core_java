package com.partha.problemSolving.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * link : https://leetcode.com/problems/first-unique-character-in-a-string
 * @author biswaspa
 *
 */
public class Day9Problem1FirstUniqueCharacter {

	public static void main(String[] args) {
		System.out.println(new Solution1().firstUniqChar("leetcode"));
	}
	
	
	/**
	 * O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
	    public int firstUniqChar(String s) {
	        Map<Character,Result> map = new LinkedHashMap<>();
	        for(int i=0;i<s.length();i++){
	            Result result = null ;
	            Character c = s.charAt(i);
	            if(map.get(c)==null){
	               result = new Result(i,1);
	            }else {
	               result  = map.get(c) ;
	               result.index = i ;
	               result.occurance +=1;
	               
	            }
	            map.put(c,result);
	        }
	        
	        
	        for(Character c: map.keySet()){
	            if(map.get(c).occurance==1){
	                return map.get(c).index;
	            }
	        }
	        return -1;
	        
	    }
	    
	    class Result{
	        int index;
	        int occurance;
	        
	        public Result(int index,int occurance){
	            super();
	            this.index=index;
	            this.occurance=occurance;
	        }
	    }

	}
	
	
	

}
