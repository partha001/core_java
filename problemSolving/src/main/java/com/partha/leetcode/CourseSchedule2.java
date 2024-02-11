package com.partha.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * @author partha
 *
 */
public class CourseSchedule2 {

	public static void main(String[] args) {
		int[] findOrder = new Solution1().findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}});
		IntStream.range(0, findOrder.length).forEach(System.out::println);;
	}

	private static class Solution1 {
		public int[] findOrder(int numCourses, int[][] prerequisites) {

			if(numCourses == 0){   // case when course size is 0
				return new int[0];
			}

			//acyclic directed graph [DAG]

			List<List<Integer>> list = new ArrayList<>();  // list of list
			int Indegree[] = new int[numCourses];  // Indegree array
			int course[] = new int[numCourses];  ; // order array of courses



			for(int i = 0;i<numCourses;i++){ // bilding a new array List for each Node
				list.add(new ArrayList<>());
			}


			for(int i = 0;i<prerequisites.length;i++){   //Graph builded
				int node1 = prerequisites[i][0];
				int node2 = prerequisites[i][1];

				list.get(node2).add(node1);
			}


			for(int i = 0;i<list.size();i++){  // Indegree array
				for(int j = 0;j<list.get(i).size();j++){
					int node = list.get(i).get(j);
					Indegree[node]++;
				}
			}


			Queue<Integer> queue = new LinkedList<>(); // queue 
			for(int i = 0;i<Indegree.length;i++){
				//  System.out.println(i+":  "+Indegree[i]); 
				if(Indegree[i] == 0){  // added 0 dependency's node to queue
					queue.add(i);
				}
			}

			int count_course = 0;
			int index = 0;   
			while(!queue.isEmpty()){   //BFS algorithm
				int node = queue.poll();
				count_course++;
				course[index++] = node; // added node to the list of course
				for(int j = 0;j<list.get(node).size();j++){
					int val = list.get(node).get(j);
					Indegree[val]--;
					if(Indegree[val] == 0){
						queue.add(val);
					}
				}
			}

			return count_course == numCourses ? course : new int[0];
		}



	}

}
