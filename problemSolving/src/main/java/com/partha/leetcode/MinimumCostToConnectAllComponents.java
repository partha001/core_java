package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * @author biswaspa
 *
 */
public class MinimumCostToConnectAllComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * approach: prims algorithm 
	 * @author partha . same as LeetcodeOfficialSolution2 with little code refactoring to improve readability
	 * @TC: O(N^2⋅log⁡(N))
	 * @SC: O(N^2)
	 *
	 */
	private static class Solution1 {
	    public int minCostConnectPoints(int[][] points) {
	        int n = points.length;
	        
	        // Min-heap to store minimum weight edge at top.
	        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey())); //PairKey=distance PairValue=pointIndex
	        
	        // Track nodes which are included in MST.
	        boolean[] visited = new boolean[n];
	        
	        queue.add(new Pair(0, 0));
	        int mstCost = 0;
	        int visitCount = 0;
	        
	        while (visitCount < n) {
	            Pair<Integer, Integer> topElement = queue.poll();
	            
	            int weight = topElement.getKey();
	            int currNode = topElement.getValue();
	            
	            if (visited[currNode]) { //if already visited
	                continue;
	            }
	            
	            visited[currNode] = true;
	            mstCost += weight;
	            visitCount++;
	            
	            for (int nextNode = 0; nextNode < n; ++nextNode) {
	                if (!visited[nextNode]) { //this condition also takes care of not visiting itself or other visited nodes
	                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) + Math.abs(points[currNode][1] - points[nextNode][1]);
	                    queue.add(new Pair(nextWeight, nextNode));
	                }
	            }
	        }
	        
	        return mstCost;
	    }
	}
	

	/**
	 * approach: kruskals algorithm [this is a greedy algorithm for building minimum spanning tree]
	 * @source: leetcode official solution
	 * @link https://leetcode.com/problems/min-cost-to-connect-all-points/solutions/1839597/min-cost-to-connect-all-points/
	 * @author partha
	 * @TC: O(N2⋅log(N))
	 * @SC: O(N2)
	 *
	 */
	private static class LeetcodeOfficialSolution1 {
	    public int minCostConnectPoints(int[][] points) {
	        int n = points.length;
	        ArrayList<int[]> allEdges = new ArrayList<>();
	        
	        // Storing all edges of our complete graph.
	        for (int currNext = 0; currNext < n; ++currNext) {
	            for (int nextNext = currNext + 1; nextNext < n; ++nextNext) {
	                int weight = Math.abs(points[currNext][0] - points[nextNext][0]) + 
	                             Math.abs(points[currNext][1] - points[nextNext][1]);
	                
	                int[] currEdge = {weight, currNext, nextNext};
	                allEdges.add(currEdge);
	            }
	        }
	        
	        // Sort all edges in increasing order.
	        Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));   
	        
	        UnionFind uf = new UnionFind(n);
	        int mstCost = 0;
	        int edgesUsed = 0;
	        
	        for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; ++i) {
	            int node1 = allEdges.get(i)[1];
	            int node2 = allEdges.get(i)[2];
	            int weight = allEdges.get(i)[0];
	            
	            if (uf.union(node1, node2)) {
	                mstCost += weight;
	                edgesUsed++;
	            }
	        }
	        
	        return mstCost;
	    }
	}
	
	
	private static class UnionFind {
	    public int[] group;
	    public int[] rank;

	    public UnionFind(int size) {
	        group = new int[size];
	        rank = new int[size];
	        for (int i = 0; i < size; ++i) {
	            group[i] = i;
	        }
	    }

	    public int find(int node) {
	        if (group[node] != node) {
	            group[node] = find(group[node]);
	        }
	        return group[node];
	    }

	    public boolean union(int node1, int node2) {
	        int group1 = find(node1);
	        int group2 = find(node2);
	        
	        // node1 and node2 already belong to same group.
	        if (group1 == group2) {
	            return false;
	        }

	        if (rank[group1] > rank[group2]) {
	            group[group2] = group1;
	        } else if (rank[group1] < rank[group2]) {
	            group[group1] = group2;
	        } else {
	            group[group1] = group2;
	            rank[group2] += 1;
	        }

	        return true;
	    }
	}
	
	
	
	/**
	 * approach: prims algorithm 
	 * @source: leetcode official solution
	 * @link https://leetcode.com/problems/min-cost-to-connect-all-points/solutions/1839597/min-cost-to-connect-all-points/
	 * @author partha
	 * @TC: O(N^2⋅log⁡(N))
	 * @SC: O(N^2)
	 *
	 */
	private static class LeetcodeOfficialSolution2 {
	    public int minCostConnectPoints(int[][] points) {
	        int n = points.length;
	        
	        // Min-heap to store minimum weight edge at top.
	        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;
	        
	        // Track nodes which are included in MST.
	        boolean[] inMST = new boolean[n];
	        
	        heap.add(new Pair(0, 0));
	        int mstCost = 0;
	        int edgesUsed = 0;
	        
	        while (edgesUsed < n) {
	            Pair<Integer, Integer> topElement = heap.poll();
	            
	            int weight = topElement.getKey();
	            int currNode = topElement.getValue();
	            
	            // If node was already included in MST we will discard this edge.
	            if (inMST[currNode]) {
	                continue;
	            }
	            
	            inMST[currNode] = true;
	            mstCost += weight;
	            edgesUsed++;
	            
	            for (int nextNode = 0; nextNode < n; ++nextNode) {
	                // If next node is not in MST, then edge from curr node
	                // to next node can be pushed in the priority queue.
	                if (!inMST[nextNode]) {
	                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
	                                     Math.abs(points[currNode][1] - points[nextNode][1]);
	        
	                    heap.add(new Pair(nextWeight, nextNode));
	                }
	            }
	        }
	        
	        return mstCost;
	    }
	}
	
	
	/**
	 * Prim's Algorithm (Optimized)
	 * @source: leetcode official solution
	 * @link https://leetcode.com/problems/min-cost-to-connect-all-points/solutions/1839597/min-cost-to-connect-all-points/
	 * @author partha
	 * @TC: O(N^2)
	 * @SC: O(N)
	 */
	private static class LeetcodeOfficialSolution3 {
	    public int minCostConnectPoints(int[][] points) {
	        int n = points.length;
	        int mstCost = 0;
	        int edgesUsed = 0;
	        
	        // Track nodes which are visited.
	        boolean[] inMST = new boolean[n];
	        
	        int[] minDist = new int[n];
	        minDist[0] = 0;
	        
	        for (int i = 1; i < n; ++i) {
	            minDist[i] = Integer.MAX_VALUE;
	        }
	        
	        while (edgesUsed < n) {
	            int currMinEdge = Integer.MAX_VALUE;
	            int currNode = -1;
	            
	            // Pick least weight node which is not in MST.
	            for (int node = 0; node < n; ++node) {
	                if (!inMST[node] && currMinEdge > minDist[node]) {
	                    currMinEdge = minDist[node];
	                    currNode = node;
	                }
	            }
	            
	            mstCost += currMinEdge;
	            edgesUsed++;
	            inMST[currNode] = true;
	            
	            // Update adjacent nodes of current node.
	            for (int nextNode = 0; nextNode < n; ++nextNode) {
	                int weight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
	                             Math.abs(points[currNode][1] - points[nextNode][1]);
	                
	                if (!inMST[nextNode] && minDist[nextNode] > weight) {
	                    minDist[nextNode] = weight;
	                }
	            }
	        }
	        
	        return mstCost;
	    }
	}
	


}
