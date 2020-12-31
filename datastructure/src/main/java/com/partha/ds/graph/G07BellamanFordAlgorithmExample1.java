package com.partha.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class G07BellamanFordAlgorithmExample1 {

	public static void main(String[] args) {
		
		List<Vertex> vertexList = new ArrayList<>();
		List<Edge> edgeList = new ArrayList<>();
		

		
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		
		vertexList.add(vertex0);
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		
		edgeList.add(new Edge(1,vertex0, vertex1));
		edgeList.add(new Edge(1,vertex0, vertex2));
		edgeList.add(new Edge(1,vertex1, vertex2));
		
		BellmanFordAlgorithm solution1 = new BellmanFordAlgorithm(edgeList,vertexList);
		solution1.bellmanFord(vertex0);
		//printing the result
		solution1.shortestPathToVertex(vertex2);
	}


	static class BellmanFordAlgorithm {

		List<Edge> edgeList;
		List<Vertex> vertexList;

		public BellmanFordAlgorithm(List<Edge> edgeList, List<Vertex> vertexList) {
			super();
			this.edgeList = edgeList;
			this.vertexList = vertexList;
		}

		public void bellmanFord(Vertex sourceVertex) {
			sourceVertex.distance=0; //since we are standing at source only

			for(int i=0;i<this.vertexList.size()-1;i++) { //V-1 iterations --> we relax all the edges
				for(Edge edge: edgeList) {

					Vertex u = edge.fromVertex;
					Vertex v = edge.toVertex;
					if(u.distance==Double.MAX_VALUE)
						continue;
					double newDistance = u.distance + edge.weight ;
					if(newDistance < v.distance) {
						v.distance = newDistance;
						v.previousVertex = u;
					}
				}
			}
			
			
			for(Edge edge: edgeList) { //V-th iteration
				if(edge.fromVertex.distance != Double.MAX_VALUE) {
					if(hasCycle(edge)) {
						System.out.println("There has been a negative cycle detected");
						return ;
					}
				}
			}
		}
		
		boolean hasCycle(Edge edge) {
			return edge.fromVertex.distance + edge.weight < edge.toVertex.distance ;
		}
		
		
		//this is to basically backtract and print the path
		void shortestPathToVertex(Vertex targetVertex){
			if(targetVertex.distance == Double.MAX_VALUE)
				System.out.println("there is no path from the source to the target");
			Vertex actualVertex = targetVertex;
			while(actualVertex!=null ) {
				System.out.print(actualVertex.name + " - ");
				actualVertex = actualVertex.previousVertex;
			}
		}


	}


	static class Vertex {
		String name;
		boolean visited;
		double distance= Double.MAX_VALUE;
		Vertex previousVertex;
		List<Edge> edgeList;

		public Vertex(String name) {
			super();
			this.name = name;
			this.edgeList = new ArrayList<>();
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

}
