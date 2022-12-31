package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/network-delay-time/
 * @author partha
 *
 */
public class NetworkDelayTime {

	public static void main(String[] args) {

	}
	

	/**
	 *  Dijkstra's algorithm
	 *  https://www.youtube.com/watch?v=EaphyqKU4PQ&t=293s
	 */
	class Solution {
	    public int networkDelayTime(int[][] times, int n, int k) {
	        Map<Integer,List<int[]>> map = new HashMap(); //building a map of adjacency list 
	        for(int i=1;i<=n;i++)
	            map.put(i, new ArrayList()); //putting keys in map with empty adjacency list;
	        
	        for(int i=0;i<times.length;i++) {
	            int[] record = times[i]; // source=0 destination=1 and delay=2
	            map.get(record[0]).add(new int[] {record[1],record[2]});
	        }

	        //now doing bfs
	        PriorityQueue<int[]> queue = new PriorityQueue<int[]>( (a,b) -> a[1] - b[1]);  
	        queue.add(new int[]{k,0}); //since k=start of traversal and 0 set the cost to reach itself
	        Set<Integer> visited = new HashSet(); //to keep track of visits
	        int totalTime = 0;
	        while(!queue.isEmpty()){
	            int[] current = queue.remove();
	            if(visited.contains(current[0])) //baseCase1
	                continue; //note i have not used return since this bfs is not a separate method. just want the look to continue and exit
	            
	            visited.add(current[0]);
	            totalTime = Math.max(totalTime, current[1]); //note we are not summing since there are timeoverlaps between different paths
	            for(int[] neighbour: map.get(current[0])){
	                if(!visited.contains(neighbour[0]))
	                    queue.add(new int[] {neighbour[0], current[1]+ neighbour[1]}); 
	                //progressive time is take care here.i.e. latencyNeighbour=  latency(parent) + edge(parent,neighbour)
	            }
	        }

	        if(visited.size()==n)
	            return totalTime;
	        return -1;


	    }
	}
	

}
