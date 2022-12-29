package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * https://leetcode.com/problems/clone-graph
 * @author partha
 *
 */
public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	


	
	
	/**
	 * https://www.youtube.com/watch?v=mQeF6bN8hMk
	 * @author partha
	 *
	 */
	private static class Solution1 {
		
	    public Node cloneGraph(Node node) {
	        if(node==null)
	            return null;
	        
	        Node clone = clone(node,new HashMap<Integer,Node>());
	        return clone;
	    }


	    public Node clone(Node node, HashMap<Integer,Node> map){
	        if(node==null) //the first two if actually take care of visited.
	            return null;
	        if(map.containsKey(node.val))
	            return map.get(node.val);
	        
	        Node clone = new Node(node.val,new ArrayList<Node>());
	        map.put(node.val, clone);
	        for(Node neigh: node.neighbors){
	            clone.neighbors.add(clone(neigh,map));
	        }
	        return clone;
	    }
	}
	
	
	
	private static class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	

}
