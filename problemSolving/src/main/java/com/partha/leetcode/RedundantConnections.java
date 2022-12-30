package com.partha.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * @author partha
 *
 */
public class RedundantConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * explanation : https://www.youtube.com/watch?v=FXWRE67PLL0
	 * @author partha
	 *
	 */
	class Solution {
	    public int[] findRedundantConnection(int[][] edges) {
	        int numberOfNodes = edges.length;
	        int[] parents = new int[numberOfNodes+1];
	        IntStream.range(0,numberOfNodes+1).forEach(i-> parents[i]=i);
	        int[] ranks = new int[numberOfNodes+1];
	        Arrays.fill(ranks,1); //by default rank is 1 since it connect to only one other node i.e itself


	        for(int[] edge : edges){
	            if(!union(edge[0],edge[1], parents, ranks)) //if an edge return false then that is th redundant one
	                return edge;
	        }
	        return new int[2];

	    }


	    private int find(int n,int[] parents){
	        int p = parents[n];
	        while(p!= parents[p]){ //i.e. parent is not the same as the same node itself
	            parents[p] = parents[parents[p]] ;//path-compression.this is optional and can be commented as well
	            //the above line is used to increase effeciency
	            p = parents[p];
	        }
	        return p;
	    }

	    //perfoms union
	    private boolean union(int node1, int node2 , int[] parents, int[] ranks){
	        int parent1 = find(node1, parents);
	        int parent2 = find(node2, parents);

	        if(parent1 == parent2) //i.e they are already connected to the same parent.
	            return false;
	        
	        if(ranks[parent1] > ranks[parent2]){
	            parents[parent2] = parent1;
	            ranks[parent1] = ranks[parent1]+ ranks[parent2]; //increasing the rank by 1 since were are adding one children
	        }else{
	            parents[parent1] = parent2;
	            ranks[parent2] = ranks[parent2] + ranks[parent1];
	        }

	        return true;

	    }
	}

}
