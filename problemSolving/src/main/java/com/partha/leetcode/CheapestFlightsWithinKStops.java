package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @approach1: BFS approach.
	 * @source : leetcode official solution
	 * @TC: Time complexity: O(N+E⋅K)
	 * @SC:  O(N+E⋅K)
	 * Depending on improvements in the shortest distance for each node, we may process each edge multiple times. 
	 * However, the maximum number of times an edge can be processed is limited by K 
	 */
	private static class LeetcodeOfficialSolution1 {
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	        Map<Integer, List<int[]>> adj = new HashMap<>();
	        for (int[] i : flights)
	            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

	        int[] dist = new int[n];
	        Arrays.fill(dist, Integer.MAX_VALUE);

	        Queue<int[]> q = new LinkedList<>();
	        q.offer(new int[] { src, 0 });
	        int stops = 0;

	        while (stops <= k && !q.isEmpty()) {
	            int sz = q.size();
	            // Iterate on current level.
	            while (sz-- > 0) {
	                int[] temp = q.poll();
	                int node = temp[0];
	                int distance = temp[1];

	                if (!adj.containsKey(node))
	                    continue;
	                // Loop over neighbors of popped node.
	                for (int[] e : adj.get(node)) {
	                    int neighbour = e[0];
	                    int price = e[1];
	                    if (price + distance >= dist[neighbour])
	                        continue;
	                    dist[neighbour] = price + distance;
	                    q.offer(new int[] { neighbour, dist[neighbour] });
	                }
	            }
	            stops++;
	        }
	        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	    }
	}
	
	
	
	/**
	 * @approach2: Bellman-ford algorithm
	 * @source : leetcode official solution
	 * https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/2825208/cheapest-flights-within-k-stops/
	 * @TC O((N+E)*K)
	 * @SC O(N)
	 */
	private static class LeetcodeOfficialSolution2 {
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	        // Distance from source to all other nodes.
	        int[] dist = new int[n];
	        Arrays.fill(dist, Integer.MAX_VALUE);
	        dist[src] = 0;

	        // Run only K+1 times since we want shortest distance in K hops
	        for (int i = 0; i <= k; i++) {
	            // Create a copy of dist vector.
	            int[] temp = Arrays.copyOf(dist, n);
	            for (int[] flight : flights) {
	                if (dist[flight[0]] != Integer.MAX_VALUE) {
	                    temp[flight[1]] = Math.min(temp[flight[1]], dist[flight[0]] + flight[2]);
	                }
	            }
	            // Copy the temp vector into dist.
	            dist = temp;
	        }
	        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	    }
	};
	
	
	
	/**
	 * approach3: Dijkstras algorithm
	 * @source leetcode official solution
	 * @TC: 
	 * @SC: 
	 */
	private static class LeetcodeOfficialSolution3 {
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	        Map<Integer, List<int[]>> adj = new HashMap<>();
	        for (int[] i : flights)
	            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

	        int[] stops = new int[n];
	        Arrays.fill(stops, Integer.MAX_VALUE);
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	        // {dist_from_src_node, node, number_of_stops_from_src_node}
	        pq.offer(new int[] { 0, src, 0 });

	        while (!pq.isEmpty()) {
	            int[] temp = pq.poll();
	            int dist = temp[0];
	            int node = temp[1];
	            int steps = temp[2];
	            // We have already encountered a path with a lower cost and fewer stops,
	            // or the number of stops exceeds the limit.
	            if (steps > stops[node] || steps > k + 1)
	                continue;
	            stops[node] = steps;
	            if (node == dst)
	                return dist;
	            if (!adj.containsKey(node))
	                continue;
	            for (int[] a : adj.get(node)) {
	                pq.offer(new int[] { dist + a[1], a[0], steps + 1 });
	            }
	        }
	        return -1;
	    }
	}

}
