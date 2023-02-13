package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * @author partha
 *
 */
public class NumberOfConnectedComponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = new int[][] {{0,1},{1,2},{3,4}};
		System.out.println(new NumberOfConnectedComponent.Solution().findRedundantConnection(edges,4));
	}
	
	
	/**
	 * explanation : https://www.youtube.com/watch?v=FXWRE67PLL0
	 * @author partha
	 *	this code is absolutely same as RedundantConnectonProblem . since both use UnionFind algorith.
	 *	just that the return type of the union() method has been changed from boolean to int as per requiment
	 */
	 static class Solution {
	    public int findRedundantConnection(int[][] edges, int numberOfNodes) {
	        //int numberOfNodes = edges.length;
	        int[] parents = new int[numberOfNodes+1];
	        IntStream.range(0,numberOfNodes+1).forEach(i-> parents[i]=i);
	        int[] ranks = new int[numberOfNodes+1];
	        Arrays.fill(ranks,1);


	        int result = numberOfNodes;
	        for(int[] edge : edges){
	 
	            if(union(edge[0],edge[1], parents, ranks)==1) result--;
	        	//result -= union(edge[0],edge[1], parents, ranks);  // since it return zero or one
	        }
	        return result;

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
	    private int union(int node1, int node2 , int[] parents, int[] ranks){
	        int parent1 = find(node1, parents);
	        int parent2 = find(node2, parents);

	        if(parent1 == parent2) //i.e they are already connected to the same parent.
	            return 0;
	        
	        if(ranks[parent1] > ranks[parent2]){
	            parents[parent2] = parent1;
	            ranks[parent1] = ranks[parent1]+ ranks[parent2]; //increasing the rank by 1 since were are adding one children
	        }else{
	            parents[parent1] = parent2;
	            ranks[parent2] = ranks[parent2] + ranks[parent1];
	        }

	        return 1;

	    }
	}
	
	
	//dfs soluion
	static class Solution2 {
	    private static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int src,int v){
	        visited[src]=true;
	        for(int i=0;i<v;i++){
	            if(adj.get(src).get(i)==1 && !visited[i]){
	                dfs(adj,visited,i,v);
	            }
	        }
	    }
	    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
	        // code here
	        
	        // crete graph
	        int count=0;
	       boolean[] visited=new boolean[V];
	       for(int i=0;i<V;i++){
	           if(!visited[i]){
	               count++;
	               dfs(adj,visited,i,V);
	           }
	       }
	       return count;
	    }
	};


}
