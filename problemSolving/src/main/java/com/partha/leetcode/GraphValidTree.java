package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
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
	 * approach1: Iterative DFS
	 * @author partha
	 * @source: leetcode premium
	 */
	private static class LeetcodeOfficialSolution1{
		public boolean validTree(int n, int[][] edges) {

			List<List<Integer>> adjacencyList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				adjacencyList.add(new ArrayList<>());
			}
			for (int[] edge : edges) {
				adjacencyList.get(edge[0]).add(edge[1]);
				adjacencyList.get(edge[1]).add(edge[0]);
			}

			Map<Integer, Integer> parent = new HashMap<>();
			parent.put(0, -1);
			Stack<Integer> stack = new Stack<>();
			stack.push(0);

			while (!stack.isEmpty()) {
				int node = stack.pop();
				for (int neighbour : adjacencyList.get(node)) {
					if (parent.get(node) == neighbour) {
						continue;
					}
					if (parent.containsKey(neighbour)) {
						return false;
					}
					stack.push(neighbour);
					parent.put(neighbour, node);
				}
			}

			return parent.size() == n;   
		}
	}


	/**
	 * @approach2: recursive dfs
	 * @author partha
	 * @source: leetcode official solution
	 * @link : https://leetcode.com/problems/graph-valid-tree/solutions/539585/graph-valid-tree/
	 */
	private static class LeetcodeOfficialSolution2 {

		private List<List<Integer>> adjacencyList = new ArrayList<>();
		private Set<Integer> seen = new HashSet<>();


		public boolean validTree(int n, int[][] edges) {

			if (edges.length != n - 1) return false;

			for (int i = 0; i < n; i++) {
				adjacencyList.add(new ArrayList<>());
			}
			for (int[] edge : edges) {
				adjacencyList.get(edge[0]).add(edge[1]);
				adjacencyList.get(edge[1]).add(edge[0]);
			}

			// We return true iff no cycles were detected,
			// AND the entire graph has been reached.
			return dfs(0, -1) && seen.size() == n;   
		}

		public boolean dfs(int node, int parent) {
			if (seen.contains(node)) return false;
			seen.add(node);
			for (int neighbour : adjacencyList.get(node)) {
				if (parent != neighbour) {
					boolean result = dfs(neighbour, node);
					if (!result) return false;
				}
			}
			return true;
		}
	}



	/**
	 * approach: iterative bfs
	 * @source : leetcode official solution
	 * @link: https://leetcode.com/problems/graph-valid-tree/solutions/539585/graph-valid-tree/
	 * @TimeComplexity: O(N) where n is the number of nodes
	 * @spaceComplexity: O(N) 
	 * 
	 */
	private static class LeetcodeOfficialSolution3 {
		public boolean validTree(int n, int[][] edges) {

			if (edges.length != n - 1) return false;

			// Make the adjacency list.
			List<List<Integer>> adjacencyList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				adjacencyList.add(new ArrayList<>());
			}
			for (int[] edge : edges) {
				adjacencyList.get(edge[0]).add(edge[1]);
				adjacencyList.get(edge[1]).add(edge[0]);
			}

			Queue<Integer> queue = new LinkedList<>();
			Set<Integer> seen = new HashSet<>();
			queue.offer(0);
			seen.add(0);

			while (!queue.isEmpty()) {
				int node = queue.poll();
				for (int neighbour : adjacencyList.get(node)) {
					if (seen.contains(neighbour)) continue;
					seen.add(neighbour);
					queue.offer(neighbour);
				}
			}

			return seen.size() == n;   
		}

	}


	/**
	 * @approach: using union and find algorithm
	 * @author partha
	 * @source: leetcode official solution page
	 * @link : https://leetcode.com/problems/graph-valid-tree/solutions/539585/graph-valid-tree/	 
	 * @timeComplexity: Time Complexity : O(N⋅α(N)) .  where α(N) is Inverse Ackerman Function 
	 * @spaceComplexity: O(N).
	 */
	private static class LeetcodeOfficialSolution4 {

		public boolean validTree(int n, int[][] edges) {

			// Condition 1: The graph must contain n - 1 edges.
			if (edges.length != n - 1) return false;

			// Condition 2: The graph must contain a single connected component.
			// Create a new UnionFind object with n nodes. 
			UnionFind unionFind = new UnionFind(n);
			// Add each edge. Check if a merge happened, because if it 
			// didn't, there must be a cycle.
			for (int[] edge : edges) {
				int A = edge[0];
				int B = edge[1];
				if (!unionFind.union(A, B)) {
					return false;
				}
			}

			// If we got this far, there's no cycles!
			return true;
		}

	}


	private static class UnionFind {

		private int[] parent;
		private int[] size; // We use this to keep track of the size of each set.

		// For efficiency, we aren't using makeset, but instead initialising
		// all the sets at the same time in the constructor.
		public UnionFind(int n) {
			parent = new int[n];
			size = new int[n];
			for (int node = 0; node < n; node++) {
				parent[node] = node;
				size[node] = 1;
			}
		}

		// The find method, with path compression. There are ways of implementing
		// this elegantly with recursion, but the iterative version is easier for
		// most people to understand!
		public int find(int A) {
			// Step 1: Find the root.
			int root = A;
			while (parent[root] != root) {
				root = parent[root];
			}
			// Step 2: Do a second traversal, this time setting each node to point
			// directly at A as we go.
			while (A != root) {
				int oldRoot = parent[A];
				parent[A] = root;
				A = oldRoot;
			}
			return root;
		}

		// The union method, with optimization union by size. It returns True if a
		// merge happened, False if otherwise.
		public boolean union(int A, int B) {
			// Find the roots for A and B.
			int rootA = find(A);
			int rootB = find(B);
			// Check if A and B are already in the same set.
			if (rootA == rootB) {
				return false;
			}
			// We want to ensure the larger set remains the root.
			if (size[rootA] < size[rootB]) {
				// Make rootB the overall root.
				parent[rootA] = rootB;
				// The size of the set rooted at B is the sum of the 2.
				size[rootB] += size[rootA];
			}
			else {
				// Make rootA the overall root.
				parent[rootB] = rootA;
				// The size of the set rooted at A is the sum of the 2.
				size[rootA] += size[rootB];
			}
			return true;
		} 
	}


	/**
	 * https://www.youtube.com/watch?v=bXsUuownnoQ
	 * @author partha
	 * failed when executed in leetcode . need to be looked into
	 *
	 */
	public class Solution5 {
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
