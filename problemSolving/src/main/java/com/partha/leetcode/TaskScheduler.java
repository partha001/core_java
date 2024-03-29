package com.partha.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/task-scheduler
 * @author partha
 *
 */
public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = new char[] {'A','A','A','B','B','B'};
		System.out.println(new TaskScheduler.Solution1().leastInterval(arr, 2));
	}
	
	
	/**
	 * @source: leetcode official solution
	 * @author partha
	 * @TC O(N) where N is the total number of tasks to be executed
	 * @SC O(1)
	 */
	private static class LeetcodeOfficialSolution1 {
	    public int leastInterval(char[] tasks, int n) {
	        // frequencies of the tasks
	        int[] frequencies = new int[26];
	        for (int t : tasks) {
	            frequencies[t - 'A']++;
	        }

	        Arrays.sort(frequencies);

	        // max frequency
	        int f_max = frequencies[25];
	        int idle_time = (f_max - 1) * n; //for k tasks there would be k-1 intervals . hence total interval (k-1) * n
	        
	        for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; i--) { //note the boundary condition here
	            idle_time -= Math.min(f_max - 1, frequencies[i]); 
	        }
	        idle_time = Math.max(0, idle_time);

	        return idle_time + tasks.length;
	    }
	}
	
	
	/**
	 * @approach mathematical solution
	 * @source: leetcode official solution
	 * @author partha
	 * @TC O(N) where N is the total number of tasks to be executed
	 * @SC O(1)
	 */
	private static class LeetcodeOfficialSolution2 {
	    public int leastInterval(char[] tasks, int n) {
	        // frequencies of the tasks
	        int[] frequencies = new int[26];
	        for (int t : tasks) {
	            frequencies[t - 'A']++;
	        }

	        // max frequency
	        int f_max = 0;
	        for (int f : frequencies) {
	            f_max = Math.max(f_max, f);
	        }
	        
	        // count the most frequent tasks
	        int n_max = 0;
	        for (int f : frequencies) {
	            if (f == f_max) n_max++;
	        }
	        
	        return Math.max(tasks.length, (f_max - 1) * (n + 1) + n_max);
	    }
	}
	
	


	private static class Solution1 {
		class Task {
			int freq, lastUsed = -1;
			public Task(int f) { freq = f; }
		}

		// Overall we always want to schedule the most repeated task that is available to schedule every time.
		// This greedy approach works because picking any other task will result in non optimal solution.
		public int leastInterval(char[] tasks, int n) {
			// if n == 0 there will be no idle periods, so return length of tasks
			if(n == 0) return tasks.length;

			Map<Character, Task> map = new HashMap<>();
			for(char c: tasks) {
				map.putIfAbsent(c, new Task(0));
				map.get(c).freq++;
			}

			PriorityQueue<Task> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);

			// Use a queue to add tasks that were scheduled at the end
			// Which means tasks that are at the top of the cooling are the ones first to go out of cooling and become available for scheduling.
			Queue<Task> cooling = new LinkedList<>();

			pq.addAll(map.values());
			int count = 0;

			while(!pq.isEmpty() || !cooling.isEmpty()) {
				// if no tasks are available to schedule at current time, go idle until the first cooling task becomes available
				if(pq.isEmpty()) count = cooling.peek().lastUsed + n + 1;

				// Add any tasks in cooling that just became available for scheduling
				while(!cooling.isEmpty() && count > cooling.peek().lastUsed + n) {
					pq.add(cooling.poll());
				}

				// Schedule the most frequent occurring task by polling priority queue.
				Task t = pq.poll();
				t.lastUsed = count++;
				t.freq--;

				// Add the task back into cooling if there are more instances of it to schedule.
				if(t.freq != 0) cooling.add(t);
			}

			return count;
		}
	}
}
