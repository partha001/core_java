package com.partha.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 * @author partha
 *
 */
public class KeysAndRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution1 {
	    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	        Set<Integer> vis = new HashSet();
	        dfs(rooms,0, vis);
	        return vis.size()== rooms.size();
	    }

	    public void dfs(List<List<Integer>> rooms, int index, Set<Integer> vis){
	        if(vis.contains(index))
	            return;
	        vis.add(index);
	        for(Integer i: rooms.get(index))
	            dfs(rooms, i, vis);
	    }
	}

}
