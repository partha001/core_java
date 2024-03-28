package com.partha.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
 * @author biswaspa
 */
public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(new Solution1().shortestPathBinaryMatrix(grid));
    }

    /**
     * @author partha
     * @description
     */
    private static class Solution1 {
        public int shortestPathBinaryMatrix(int[][] grid) {

            int[][] dirs = new int[][]{{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

            if (grid.length == 0) {
                return 0;
            }

            int rows = grid.length;
            int cols = grid[0].length;

            boolean vis[][] = new boolean[rows][cols];

            if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1)
                return -1;


            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});

            vis[0][0] = true;
            int path = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                path++; //increasing the path for each layer
                for (int i = 0; i < size; i++) {
                    int[] pair = queue.poll();

                    if (pair[0] == rows - 1 && pair[1] == cols - 1)  // final case when user reach the target
                        return path;

                    for (int[] dir : dirs) {
                        int x = pair[0] + dir[0];
                        int y = pair[1] + dir[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 0 && vis[x][y] == false) {
                            vis[x][y] = true;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
            return -1;
        }
    }


    /*
    same solution as above : however here instead of making use of vis[][] to track cells visited we
    are marking the grid[][]=1 so that its not visited again since by problem statement we are suppossed
    to visit only cells=0 . so ones a cell is visited we make it 1.
     */
    private static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {

            int[][] dirs = new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};

            if(grid.length == 0){
                return 0;
            }

            int rows = grid.length;
            int cols = grid[0].length;

            if(grid[0][0] == 1 || grid[rows-1][cols-1] == 1)
                return -1;


            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});
            grid[0][0]=1; //this is to mark the cell as visited
            int path = 0;

            while(!queue.isEmpty()){
                int size = queue.size();
                path++; //increasing the path for each layer
                for(int i = 0;i<size;i++){
                    int [] pair = queue.poll();

                    if(pair[0] == rows-1 && pair[1] == cols-1)  // final case when user reach the target
                        return path ;

                    for(int[] dir:  dirs){
                        int x = pair[0] + dir[0];
                        int y = pair[1] + dir[1];
                        if(x>=0 && x<rows && y>=0 && y<cols && grid[x][y] == 0 ){
                            grid[x][y]=1; //this is to mark the cell as visited
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
            return -1;
        }
    }


}
