package com.partha.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



import lombok.Getter;
import lombok.Setter;

public class G01BreadthFirstSearchExample {

	public static void main(String[] args) {
		Vertex vertex1 = new Vertex(1);
		Vertex vertex2 = new Vertex(2);
		Vertex vertex3 = new Vertex(3);
		Vertex vertex4 = new Vertex(4);
		Vertex vertex5 = new Vertex(5);
	
		vertex1.neighbours.add(vertex2);
		vertex1.neighbours.add(vertex4);
		vertex4.neighbours.add(vertex5);
		vertex2.neighbours.add(vertex3);
		
		bfs(vertex1);

	}
	
	
	public static void bfs(Vertex v) {
		Queue<Vertex> queue =  new LinkedList();
		queue.add(v);
		while(!queue.isEmpty()) {
			Vertex current =queue.poll();
			System.out.print(current.value+ " ");
			current.visited = true;
			
			for(Vertex neighbour: current.getNeighbours()) {
				if(!neighbour.visited) {
					neighbour.visited = true;
					queue.add(neighbour); 
				}
			}
			
		}
	}
	
	
	@Getter
	@Setter
	public static class Vertex {
		
		private int value;
		private boolean visited;
		private List<Vertex> neighbours;
		
		public Vertex(int value) {
			super();
			this.value = value;
			this.neighbours = new ArrayList<>();
		}
		
		public void addNeighbour(Vertex v) {
			this.neighbours.add(v);
		}
		
	}

}
