package com.partha.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lombok.Getter;
import lombok.Setter;

public class G04TopologicalOrderingExample {
	
	public static void main(String[] args) {
		TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
		
		List<Vertex> graph = new ArrayList<>();
		graph.add(new Vertex("0"));
		graph.add(new Vertex("1"));
		graph.add(new Vertex("2"));
		graph.add(new Vertex("3"));
		graph.add(new Vertex("4"));
		graph.add(new Vertex("5"));
		
		graph.get(2).addNeighbour(graph.get(3));
		
		graph.get(3).addNeighbour(graph.get(1));
		
		graph.get(4).addNeighbour(graph.get(0));
		graph.get(4).addNeighbour(graph.get(1));
		
		graph.get(5).addNeighbour(graph.get(0));
		graph.get(5).addNeighbour(graph.get(2));
		
		
		//this for loop is not required if there is only one cluster
		//however is better not to assume that and have the loop
		//this loop ensures that all the elements are visited even if there are 
		//multiple clusters in the graph
		for(Vertex v: graph) {
			if(!v.visited) {
				topologicalOrdering.dfs(v);
			}
		}
		
		
		Stack<Vertex> stack = topologicalOrdering.stack;
		
		while(!stack.empty()) {
			System.out.print( stack.pop().data +" -> ");
		}
		
		
		
		
	}
	
	public static class TopologicalOrdering {
		private Stack<Vertex> stack;
		
		public TopologicalOrdering() {
			this.stack = new Stack<>();
		}
		
		
		public void dfs(Vertex vertex) {
			vertex.setVisited(true);
			
			for(Vertex v: vertex.neighbours) {
				if(!v.visited) {
					dfs(v);
				}
			}
			
			stack.push(vertex);
		}
	}
	
	@Getter
	@Setter
	public static class Vertex {
		
		private String data;
		private boolean visited;
		private List<Vertex> neighbours;
		
		public Vertex(String data) {
			super();
			this.data = data;
			this.neighbours  = new ArrayList<G04TopologicalOrderingExample.Vertex>();
			
		}
		
		
		public void addNeighbour(Vertex neighbour) {
			this.neighbours.add(neighbour);
		}
				
	}
	
	
	

}
