package com.partha.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 * @author partha
 *
 */
public class CourseSchedule {
	
	public static void main(String[] args) {
		
	}

	
	private static class Solution1 {
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	         if(numCourses == 0){   // case when course size is 0
	            return false;
	        }
	        
	        //acyclic directed graph [DAG]
	        
	        List<List<Integer>> list = new ArrayList<>();  // list of list
	        
	        int Indegree[] = new int[numCourses];  // Indegree array
	        
	        int course[] = new int[numCourses];  int index = 0; // order array of courses
	        
	        Queue<Integer> queue = new LinkedList<>(); // queue 
	        
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
	        
	        
	        
	        for(int i = 0;i<Indegree.length;i++){
	          //  System.out.println(i+":  "+Indegree[i]); 
	            if(Indegree[i] == 0){  // added 0 dependency's node to queue
	                queue.add(i);
	            }
	      }
	    
	     int count_course = 0;
	        
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
	        
	        System.out.println(count_course);
	        
	        if(count_course == numCourses){  // condition of returning the order
	            return true;
	        }
	        else
	            
	            return false;	        
	    }
	}
}
