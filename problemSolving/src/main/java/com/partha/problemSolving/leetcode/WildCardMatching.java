package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * @author biswaspa
 *
 */
public class WildCardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution {
		
	    public boolean isMatch(String s, String p) {
	        int sLen = s.length();
	        int pLen = p.length();
	        return isMatching(s, p, 0, 0, new Boolean[sLen+1][pLen]);
	    }
	    
	    // i -> index of s
	    // j -> index of p    
	    boolean isMatching(String s, String p, int i, int j, Boolean[][] cache){
	        // Both i and j have reached the end of the respective strings, then definitely we have found a match
	        if(i >= s.length() && j >= p.length())
	            return true;

	        // If we have reached the end of p, but we haven't reached end of s, then we have a mismatch
	        //    The vice-versa is however not always true. In the scenario when s is exhausted then 
	        //    there maybe some chars in p having * which can be ignored for matching s & p.
			//    This scenario is handled separately below.
	        if(j >= p.length())
	            return false;    
	        
	        if(cache[i][j] == null){
	            // If char of p and char of s are matching or p is having '?', then
	            // we explore the next set of chars in s and p
	            if(i < s.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)))
	                cache[i][j] = isMatching(s,p,i+1,j+1, cache);              
	            
	            // If j is pointing to * and i is still in range of length of s, then
	            // we explore both options of *, either ignore * or use it for a sequence in s
	            else if(i < s.length() && p.charAt(j) == '*')
	                cache[i][j] = isMatching(s,p,i+1,j, cache) ||  // Use * of p for matching a sequence in s
	                              isMatching(s,p,i,j+1, cache);    // Ignore * of p and explore next char of p
	            
	            // If all chars in s is exhausted but j is pointing to * in p, then 
	            // we continue to explore the option of ignoring *
	            else if(i >= s.length() && p.charAt(j) == '*')
	                cache[i][j] = isMatching(s,p,i,j+1, cache);
	            
	            // We haven't found a match
	            else
	                cache[i][j] = false;            
	        }
	        return cache[i][j];
	    }
	}

}
