package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 
 * @author partha
 *
 */
public class GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * https://www.youtube.com/watch?v=bXsUuownnoQ
	 * @author partha
	 * solution to be tested. since premium problem so not tested yet
	 *
	 */
	public class Solution {
	    /**
	     * @param n: An integer . denotes total node count
	     * @param edges: a list of undirected edges
	     * @return: true if it's a valid tree, or false
	     */
	    public boolean validTree(int n, int[][] edges) {
	    	if(n==0)
	    		return true; //since empty graph is an empty valid tree
	        
	    	//this map will contain the adjacency list for each node;
	    	Map<Integer,List<Integer>> map =new HashMap<>();
	    	IntStream.range(0,n+1).forEach(i -> map.put(i, new ArrayList<Integer>())); //filling map with empty list for each node
	    	
	    	//populating adjacency list within the map reading the edges[]
	    	for(int[] edge: edges) {
	    		int node1 = edge[0]; // these are the 2 nodes that the edge conects
	    		int node2 = edge[1];
	    		
	    		map.get(node1).add(node2); 
	    		map.get(node2).add(node1);
	    	}
	    	
	    	Set<Integer> visited = new HashSet<Integer>();
	    	boolean flag = dfs(-1,0, visited, map);
	    	if(flag==true && visited.size()==n+1) { //since 0 is the root node
	    		return true;
	    	}
	    	
	    	return false;
	    }
	    
	    
	    private boolean dfs(int previous, int node, Set<Integer> visited ,Map<Integer,List<Integer>> map) {
	    	if(visited.contains(node))
	    		return false;
	    	
	    	visited.add(node);
	    	for(int neighbour: map.get(node)) {
	    		if(neighbour==previous) //parent node is always adjacent so skipping for parent node.
	    			continue;
	    		if( !dfs(node, neighbour, visited, map))
	    			return false;
	    			
	    	}
	    	return true;
	    }
	    
	    
	    
	    
	}

}
