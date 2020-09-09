package com.partha.ds.graph;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * if vertex 6 is commented then there is no cycle in the graph
 * @author biswaspa
 *
 */
public class G05CycleDetectionWithDFS {

	public static void main(String[] args) {
		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");
		Vertex vertex6 = new Vertex("6");
		
		vertex1.addNeighbour(vertex2);
		
		vertex1.addNeighbour(vertex3);
		//vertex3.addNeighbour(vertex1);
		//comment line 26 and uncomment 27 to introduct two cycles in the graph
		
		vertex2.addNeighbour(vertex3);
		vertex4.addNeighbour(vertex1);
		vertex4.addNeighbour(vertex5);
		vertex5.addNeighbour(vertex6);
		vertex6.addNeighbour(vertex4);
		
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		vertexList.add(vertex3);
		vertexList.add(vertex4);
		vertexList.add(vertex5);
		vertexList.add(vertex6);

		CycleDetection cycleDetection = new CycleDetection();
		cycleDetection.detectCycle(vertexList);
		
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
	
	
	static class CycleDetection {
		
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
