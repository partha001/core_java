package com.partha.problemSolving.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 * @author biswaspa
 *
 */
public class Anagram {

	public static void main(String[] args) {

	}
	
	/**
	 * method : one pass
	 * timecomplexity : O(nlogn)
	 * spacecomplexity : O(2n) or O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
	    public boolean isAnagram(String s, String t) {
			if(s.length()==t.length()){
				char[] sarr = s.toCharArray();
				char[] tarr = t.toCharArray();
				Arrays.sort(sarr);
				Arrays.sort(tarr);		
				return Arrays.equals(sarr, tarr);
			}else{
				return false;
			}

	    }
	}

	
	
	

	/**
	 * method : one pass
	 * timecomplexity : O(n)
	 * spacecomplexity : O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution2 {
	    public boolean isAnagram(String s, String t) {
			if(s.length()==t.length()){

				int[] countArr=new int[256];
				for(int i=0;i<s.length();i++){
					countArr[s.charAt(i)]++;
					countArr[t.charAt(i)]--;
				}


				boolean flag=true;
				for(int i=0;i<256;i++){
					if(countArr[i]!=0){
						flag=false;
						break;
					}
				}

				if(flag){
					return true;
				}else{
					return false;
				}


			}else{
				return false;
			}

	    }
	}


	 
}
