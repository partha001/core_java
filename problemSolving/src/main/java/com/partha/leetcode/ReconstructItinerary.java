package com.partha.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * @author partha
 *
 */
public class ReconstructItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new ReconstructItinerary.Solution1().findItinerary(null)
	}


	/**
	 * https://www.youtube.com/watch?v=ZyB_gQ8vqGA
	 * @author partha
	 * TC: O(E^2)
	 * MC: O(E)
	 */
	private static class Solution1 {
		public List<String> findItinerary(List<List<String>> tickets) {
			if (tickets == null) return new ArrayList<>();
			Map<String, Queue<String>> graph = constructGraph(tickets);
			LinkedList<String> res = new LinkedList<>();
			dfs("JFK", graph, res);
			return res;
		}

		private Map<String, Queue<String>> constructGraph(List<List<String>> tickets) {
			Map<String, Queue<String>> graph = new HashMap<>();

			for (List<String> ticket : tickets) {
				String departure = ticket.get(0);
				String arrival = ticket.get(1);
				if (!graph.containsKey(departure)) {
					Queue<String> queue = new PriorityQueue<>((a, b) -> a.compareTo(b)); //also note that its priority queue and the comparison goes like this
					graph.put(departure, queue);
				}

				graph.get(departure).add(arrival);
			}
			return graph;
		}

		private void dfs(String departure, Map<String, Queue<String>> graph, LinkedList<String> res) {
			Queue<String> arrivals = graph.get(departure);
			while (arrivals != null && !arrivals.isEmpty()) {
				String arrival = arrivals.poll();
				dfs(arrival, graph, res);
			}
			res.addFirst(departure); //the trick is here that elements are added to result list at the front while backtracking
		}
	}






	/**
	 * @Approach:backtracking + greedy  [leetcode official solution]
	 * @author partha
	 * @Time Complexity: O(|E|^d) where E is the number of total flights and d is the maximum number of flights from an airport.
	 * @SpaceComplexity: O(∣V∣+∣E∣)
	 */
	//backtracking or greedy approach.
	private static class LeetcodeOfficialSolution1 {
		// origin -> list of destinations
		HashMap<String, List<String>> flightMap = new HashMap<>();
		HashMap<String, boolean[]> visitBitmap = new HashMap<>();
		int flights = 0;
		List<String> result = null;


		public List<String> findItinerary(List<List<String>> tickets) {
			// Step 1). build the graph first
			for (List<String> ticket : tickets) {
				String origin = ticket.get(0);
				String dest = ticket.get(1);
				if (this.flightMap.containsKey(origin)) {
					List<String> destList = this.flightMap.get(origin);
					destList.add(dest);
				} else {
					List<String> destList = new LinkedList<String>();
					destList.add(dest);
					this.flightMap.put(origin, destList);
				}
			}

			// Step 2). order the destinations and init the visit bitmap
			for (Map.Entry<String, List<String>> entry : this.flightMap.entrySet()) {
				Collections.sort(entry.getValue());
				this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
			}

			this.flights = tickets.size();
			LinkedList<String> route = new LinkedList<String>();
			route.add("JFK");

			// Step 3). backtracking
			this.backtracking("JFK", route);
			return this.result;
		}

		protected boolean backtracking(String origin, LinkedList<String> route) {
			if (route.size() == this.flights + 1) {
				this.result = (List<String>) route.clone();
				return true;
			}

			if (!this.flightMap.containsKey(origin))
				return false;

			int i = 0;
			boolean[] bitmap = this.visitBitmap.get(origin);

			for (String dest : this.flightMap.get(origin)) {
				if (!bitmap[i]) {
					bitmap[i] = true;
					route.add(dest);
					boolean ret = this.backtracking(dest, route);
					route.pollLast();
					bitmap[i] = false;

					if (ret)
						return true;
				}
				++i;
			}

			return false;
		}
	}




	/**
	 * @approach: Hierholzer's Algorithm
	 * @author partha
	 * @TimeComplexity: 
	 *
	 */
	private static class SLeetcodeOfficialolution2 {
		// origin -> list of destinations
		HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
		LinkedList<String> result = null;

		public List<String> findItinerary(List<List<String>> tickets) {
			// Step 1). build the graph first
			for(List<String> ticket : tickets) {
				String origin = ticket.get(0);
				String dest = ticket.get(1);
				if (this.flightMap.containsKey(origin)) {
					LinkedList<String> destList = this.flightMap.get(origin);
					destList.add(dest);
				} else {
					LinkedList<String> destList = new LinkedList<String>();
					destList.add(dest);
					this.flightMap.put(origin, destList);
				}
			}

			// Step 2). order the destinations
			this.flightMap.forEach((key, value) -> Collections.sort(value));

			this.result = new LinkedList<String>();
			// Step 3). post-order DFS
			this.DFS("JFK");
			return this.result;
		}

		protected void DFS(String origin) {
			// Visit all the outgoing edges first.
			if (this.flightMap.containsKey(origin)) {
				LinkedList<String> destList = this.flightMap.get(origin);
				while (!destList.isEmpty()) {
					// while we visit the edge, we trim it off from graph.
					String dest = destList.pollFirst();
					DFS(dest);
				}
			}
			// add the airport to the head of the itinerary
			this.result.offerFirst(origin);
		}
	}

}
