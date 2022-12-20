package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/group-anagrams/
 * @author biswaspa
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
//		int a = 'a'
//		String s ="partha";
//		char[] ca = new char[26];
//		for (char c : s.toCharArray()) {
//			ca[c - 'a']++;
//			System.out.println(c - 'a');
//		}
//		
//		//IntStream.range(0, ca.length).forEach(i -> System.out.println(ca[i]));
	}
	
	/**
	 * naive approach
	 * @author partha
	 *
	 */
	private static class Solution1 {
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
	    
	    
	    private boolean checkAnagram(String s,String t){
	    	if(s.length()==t.length()){

				int[] countArr=new int[256];
				for(int i=0;i<s.length();i++){
					countArr[s.charAt(i)]++;
					countArr[t.charAt(i)]--;
				}

				for(int i=0;i<256;i++){
					if(countArr[i]!=0){
						return false;
					}
				}
				return true;

			}else{
				return false;
			}    
	    }
	}
	
	
	/**
	 * here we are generating the key by sorting characters within a string element.
	 * this takes care of grouping the anagrams
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	if(strs == null || strs.length == 0) return Collections.emptyList();
	    	
	        List<List<String>> result = new ArrayList();
	        Map<String,List<String>> map = new HashMap();
	        for(String s: strs){
	            char[] arr = s.toCharArray();
	            Arrays.sort(arr);
	            String key = String.valueOf(arr);
	            if(!map.containsKey(key)){
	                map.put(key, new ArrayList());   //first adding empty arrayList for this key i.e. key becomes available
	            }
	            map.get(key).add(s);	//finally adding value for key in the sublist
	        }
	        return new ArrayList(map.values());
	    }

	}
	
	/**
	 * in the above case we were generating the key by sorting. 
	 * here rather we are creating a frquency array for the character [which will be unique for a group of anagrams]
	 * thus we will be using the frequency array as key
	 * @author partha
	 *
	 */
	private static class Solution3 {
		public List<List<String>> groupAnagrams(String[] strs) {
			if (strs == null || strs.length == 0) return new ArrayList<>();
	        Map<String, List<String>> map = new HashMap<>();
	        for (String s : strs) {
	            char[] ca = new char[26];
	            for (char c : s.toCharArray()) 
	                ca[c - 'a']++;
	            String keyStr = String.valueOf(ca);
	            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
	            map.get(keyStr).add(s);
	        }
	        return new ArrayList<>(map.values());
		}
	}
	
	

}
