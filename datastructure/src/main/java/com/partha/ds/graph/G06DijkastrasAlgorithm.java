package com.partha.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * problem features : undirected graph , have used edge-list representation
 * @author biswaspa
 *
 */
public class G06DijkastrasAlgorithm {

	public static void main(String[] args) {
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		vertex0.addNeighbour(new Edge(1,vertex0, vertex1));
		//vertex0.addNeighbour(new Edge(1,vertex0, vertex2));
		vertex0.addNeighbour(new Edge(3,vertex0, vertex2));
		vertex1.addNeighbour(new Edge(1,vertex1, vertex2));
		
		DijkastrasAlgorithm solution1 = new DijkastrasAlgorithm();
		solution1.computePath(vertex0);
		System.out.println( solution1.getShortestPathTo(vertex2));
		
	}
	
	
		
	
	
	static class DijkastrasAlgorithm {
		
		public void computePath(Vertex sourceVertex) {
			sourceVertex.distance = 0;
			PriorityQueue<Vertex> queue = new PriorityQueue<>();
			queue.add(sourceVertex);
			
			while(!queue.isEmpty()) {
				Vertex actualVertex = queue.poll();
				for(Edge edge : actualVertex.adjacentList) {
					Vertex v = edge.toVertex;
					double newDistance = actualVertex.distance + edge.weight;
					if( newDistance < v.distance) {
						queue.remove(v);
						v.distance = newDistance;
						v.predecessor = actualVertex;
						queue.add(v);
					}
				}
			}
		}
		
		
		public List<Vertex>  getShortestPathTo(Vertex targetVertex){
			List<Vertex> shortestPathToTarget = new ArrayList<>();
			
			//backtracking
			for(Vertex v= targetVertex; v!=null ; v = v.predecessor) {
				shortestPathToTarget.add(v);
			}
			
			//reversing since we have started from target
			Collections.reverse(shortestPathToTarget);
			return shortestPathToTarget;
		}
		
	}
	
	static class Edge {
		double weight;
		Vertex fromVertex;
		Vertex toVertex;
		
		public Edge(double weight, Vertex fromVertex, Vertex toVertex) {
			super();
			this.weight = weight;
			this.fromVertex = fromVertex;
			this.toVertex = toVertex;
		}
		
		
	}
	
	static class Vertex implements Comparable<Vertex>{
		String name;
		List<Edge> adjacentList;
		Vertex predecessor;
		double distance = Double.MAX_VALUE;
		
		public Vertex(String name) {
			super();
			this.name = name;
			this.adjacentList = new ArrayList<Edge>();
		}
		
	
		public void addNeighbour(Edge edge) {
			this.adjacentList.add(edge);
		}


		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.distance,o.distance);
		}
		
	}


}
