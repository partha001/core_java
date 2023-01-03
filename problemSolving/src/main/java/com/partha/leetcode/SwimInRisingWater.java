package com.partha.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/swim-in-rising-water/
 * @author partha
 *
 */
public class SwimInRisingWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	/**
	 * https://www.youtube.com/watch?v=amvrKlMLuGY
	 * Dijkstras algorithm
	 */
	private static class Solution1{
		public int swimInWater(int[][] grid) {
			int n = grid.length;
			int[][] visited = new int[grid.length][grid[0].length];
			int[][] dirs = new int[][] {{0,-1},{0,1},{1,0},{-1,0}};
			PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);//in this queue: arr[0] = time or height    a[1]=row a[2]=col
			queue.add(new int[] {grid[0][0], 0,0});
			visited[0][0]=1;
			while(!queue.isEmpty()) {
				int[] arr= queue.remove();
				int height=arr[0], row=arr[1] , col=arr[2];

				if(row==n-1 && col==n-1) //condition when it reaches the bottom right corner
					return height;

				for(int[] dir: dirs) {
					int neighR = row+ dir[0];
					int neighC = col+ dir[1];

					if(neighR <0 || neighC<0 || neighR==grid.length || neighC==grid[0].length  //outOfRange or visited
							|| visited[neighR][neighC]==1)
						continue;

					visited[neighR][neighC] = 1;
					queue.add(new int[] {Math.max(height, grid[neighR][neighC]),neighR, neighC});		

				}			

			}
			return 0;
		}
	}


	/**
	 * @approach: using Heap
	 * @Source leetcode official solution
	 * @TC O(N^2 log N)
	 * SC O(N^2)
	 * @author partha
	 *
	 */
	private static class LeetcodeOfficialSolution1 {
		public int swimInWater(int[][] grid) {
			int N = grid.length;
			Set<Integer> seen = new HashSet();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) ->
			grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);
			pq.offer(0);
			int ans = 0;

			int[] dr = new int[]{1, -1, 0, 0};
			int[] dc = new int[]{0, 0, 1, -1};

			while (!pq.isEmpty()) {
				int k = pq.poll();
				int r = k / N, c = k % N;
				ans = Math.max(ans, grid[r][c]);
				if (r == N-1 && c == N-1) return ans;

				for (int i = 0; i < 4; ++i) {
					int cr = r + dr[i], cc = c + dc[i];
					int ck = cr * N + cc;
					if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck)) {
						pq.offer(ck);
						seen.add(ck);
					}
				}
			}

			throw null;
		}
	}

	/**
	 * @approach: binary search and dfs
	 * @Source leetcode official solution
	 * @TC O(N^2 log N)
	 * SC O(N^2)
	 * @author partha
	 *
	 */	
	private static class LeetcodeOfficialSolution2 {
		public int swimInWater(int[][] grid) {
			int N = grid.length;
			int lo = grid[0][0], hi = N * N;
			while (lo < hi) {
				int mi = lo + (hi - lo) / 2;
				if (!possible(mi, grid)) {
					lo = mi + 1;
				} else {
					hi = mi;
				}
			}
			return lo;
		}

		public boolean possible(int T, int[][] grid) {
			int N = grid.length;
			Set<Integer> seen = new HashSet();
			seen.add(0);
			int[] dr = new int[]{1, -1, 0, 0};
			int[] dc = new int[]{0, 0, 1, -1};

			Stack<Integer> stack = new Stack();
			stack.add(0);

			while (!stack.empty()) {
				int k = stack.pop();
				int r = k / N, c = k % N;
				if (r == N-1 && c == N-1) return true;

				for (int i = 0; i < 4; ++i) {
					int cr = r + dr[i], cc = c + dc[i];
					int ck = cr * N + cc;
					if (0 <= cr && cr < N && 0 <= cc && cc < N
							&& !seen.contains(ck) && grid[cr][cc] <= T) {
						stack.add(ck);
						seen.add(ck);
					}
				}
			}

			return false;
		}
	}

}
