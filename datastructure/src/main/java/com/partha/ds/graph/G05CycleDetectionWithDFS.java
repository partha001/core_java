package com.partha.ds.graph;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class G05CycleDetectionWithDFS {

	public static void main(String[] args) {

	}
	
	@Getter
	@Setter
	public static class Vertex {
		
		private String data;
		private boolean visited;
		private boolean beingVisited;
		private List<Vertex> neighbours;
		
		public Vertex(String data) {
			super();
			this.data = data;
			this.neighbours = new ArrayList<>();
		}
		
		public void addNeighbour(Vertex v) {
			this.neighbours.add(v);
		}
		
	}
	
	
	public static class CycleDetection {
		
		public void detectCycle(List<Vertex> vertexList) {
			
			for(Vertex v:vertexList) {
				if(!v.visited) {
					dfs(v);
				}
			}
		}

		private void dfs(Vertex v) {
			
			System.out.println("vertex being visited is :"+ v.data);
			v.setBeingVisited(true);
			
			for(Vertex neighbour: v.getNeighbours()) {
				
				System.out.println("visiting the neighbour of :"+ v.data);
				
				if(neighbour.beingVisited) {
					System.out.println("There is a backward edge. Hence there is a cycle");
					return;
				}
				
				if(!neighbour.visited) {
					System.out.println("visting vertex :"+ neighbour.data +"  recursively");
					neighbour.setVisited(true);
					dfs(neighbour);
				}
			}
			
			//after for loop we have to set
			v.setBeingVisited(false);
			v.setVisited(true);
		}
	}
	
	

}
