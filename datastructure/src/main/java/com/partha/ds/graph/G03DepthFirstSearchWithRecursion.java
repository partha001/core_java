package com.partha.ds.graph;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class G03DepthFirstSearchWithRecursion {

	public static void main(String[] args) {
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		//Vertex v6 = new Vertex(6);
		
		ArrayList<Vertex> list = new ArrayList<>();
		
		v1.addNeighbour(v2);
		v1.addNeighbour(v3);
		v3.addNeighbour(v4);
		v3.addNeighbour(v5);
		
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		
		dfs(list);

	}


	public static void dfs(List<Vertex> vertexList) {

		//if its a single connected graph i.e. there is only one cluster 
		//then the below for loop is not required
		for(Vertex v: vertexList) {
			if(!v.visited) {
				v.setVisited(true);
				dfsWithRecursion(v);
			}
		}

	}

	public static void dfsWithRecursion(Vertex v) {

		System.out.print(v.getData() + " ");
		
		for(Vertex neighbour: v.getNeighbours()) {
			if(!neighbour.visited) {
				neighbour.visited = true;
				dfsWithRecursion(neighbour);
			}
		}
	}




	@Getter
	@Setter
	public static class Vertex {

		private int data;
		private boolean visited;
		private List<Vertex> neighbours;

		public Vertex(int data) {
			super();
			this.data = data;
			this.neighbours = new ArrayList<G03DepthFirstSearchWithRecursion.Vertex>();
		}	

		public void addNeighbour(Vertex v) {
			this.neighbours.add(v);
		}

	}

}
