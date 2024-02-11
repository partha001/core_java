package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/
 * @author partha
 *
 */
public class CourseSchedule {

	public static void main(String[] args) {
		new CourseSchedule.Solution2().canFinish(2, new int[][] {{1,0}});
	}



	/**
	 * https://www.youtube.com/watch?v=EgI5nU9etnU
	 * @author partha
	 *
	 */
	private static class Solution2 {
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			//this map will contain node value and its prereq list
			HashMap<Integer,List<Integer>> prereqMap = new HashMap();
			for(int i=0;i<numCourses;i++)
				prereqMap.put(i,new ArrayList());

			//now updating map depending upon prerequisites
			for(int[] arr: prerequisites){
				int course = arr[0];
				int pre = arr[1];
				prereqMap.get(course).add(pre);
			}

			//visitSet = all courses along the current bfs path
			Set<Integer> visitSet = new HashSet();

			//calling dfs on every node and return false if any return false;
			for(int i=0;i<numCourses;i++){
				if(!dfs(i, prereqMap, visitSet))
					return false;
			}

			return true;
		}


		private boolean dfs(int course, HashMap<Integer,List<Integer>> prereqMap,Set<Integer> visitSet ){
			if(visitSet.contains(course)) //base case1
				return false;
			if(prereqMap.get(course).isEmpty()) //baseCase2: ie. no dependency
				return true;
			visitSet.add(course);
			for(Integer pre : prereqMap.get(course)){
				if(!dfs(pre, prereqMap , visitSet)) //returning false immediately if the prerquite return false;
					return false;
			}
			visitSet.remove(course); //like typical dfs removing the course after coming back from a path
			prereqMap.put(course, new ArrayList<Integer>());
			return true;
		}
	}

	/**
	 * Abhisheks solution
	 * @author partha
	 * usues topological sorting [this approach can also be used in CourseSchedule2]
	 */
	private static class Solution1 {
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			if(numCourses == 0){   // case when course size is 0
				return false;
			}

			//acyclic directed graph [DAG]
			List<List<Integer>> list = new ArrayList<>();  // list of list
			int Indegree[] = new int[numCourses];  // Indegree array
			int course[] = new int[numCourses];  // order array of courses



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

			return count_course == numCourses;
		}
	}
}
