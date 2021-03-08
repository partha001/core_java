package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 * @author biswaspa
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {

	}
	
	class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> result = new ArrayList<>();
	        if(strs.length==0)
	            return result;
	        
	        Map<String,List<String>> map = new HashMap<String,List<String>>();
	        List<String> sublist = new ArrayList();;
	        for(String s:strs){
	            boolean found = false;
	            for(String key: map.keySet()){
	                if(checkAnagram(key,s)){
	                    found = true;
	                    sublist = map.get(key);
	                    sublist.add(s);
	                    break;
	                }
	            }
	            if(!found){
	                sublist = new ArrayList();
	                sublist.add(s);
	                map.put(s,sublist);
	            }
	        }
	        
	        
	        for(String s: map.keySet()){
	            result.add(map.get(s));
	        }
	        
	        return result;
	    }
	    
	    
	    private boolean checkAnagram(String s1,String s2){
	        boolean result = true;
	        if(s1==null && s2==null ){
	            return true;
	        }
	        if((s1==null && s2!=null) || (s1!=null && s2==null)){
	            return false;
	        }
	        if(s1.length()!=s2.length()){
	            return false;
	        }
	        int[] arr = new int[256];
	        for(int i=0;i<s1.length();i++){
	            arr[s1.charAt(i)]++;
	            arr[s2.charAt(i)]--;
	        }
	        for(int a=0;a<arr.length;a++){
	            if(arr[a]!=0){
	                result=false;
	                break;
	            }
	        }	        
	        return result;
	    }
	}

}
