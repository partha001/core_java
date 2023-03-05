package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shopping-offers/
 * @author partha
 *
 */
public class ShoppingOffers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * dfs + backtracking
	 * @author partha
	 *
	 */
	class Solution {
	    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	        return helper(price, special, needs, 0);
	    }
	    
	    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
	        int sum = 0, len = price.size();
	        for (int i = 0; i < len; i++) sum += needs.get(i)*price.get(i);
	        
	        for (int i = pos; i < special.size(); i++) {
	            List<Integer> list = special.get(i);
	            List<Integer> temp = new ArrayList<>();
	            for (int j= 0; j < needs.size(); j++) {
	        		if (needs.get(j) < list.get(j)) { // check if the current offer is valid
	        			temp =  null;
	        			break;
	        		}
	        		temp.add(needs.get(j) - list.get(j));
	        	}
	            if (temp != null) { // use the current offer and try next
	    			sum = Math.min(sum, list.get(list.size() - 1) + helper(price, special, temp, i)); 
	    		}
	        }
	        return sum;
	    }
	    
	}

}
