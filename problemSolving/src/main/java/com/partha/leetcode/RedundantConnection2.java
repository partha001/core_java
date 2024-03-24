package com.partha.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/redundant-connection-ii/
 *
 * @author partha
 */
public class RedundantConnection2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * union and find remains same as redundant connection1.  here only 3 things are introduced newly
     * 1. indegree array 2.potential1 3.potential2
     *
     * @author partha
     */
    class Solution {

        public int[] findRedundantDirectedConnection(int[][] edges) {
            int numberOfNodes = edges.length + 1;
            int[] parents = new int[numberOfNodes];
            int[] ranks = new int[numberOfNodes];
            IntStream.range(0, numberOfNodes).forEach(i -> parents[i] = i);
            Arrays.fill(ranks, 1); //by default rank is 1 since it connect to only one other node i.e itself

            int[] inDegree = new int[numberOfNodes];
            Arrays.fill(inDegree, -1);
            int potential1 = -1;
            int potential2 = -1;

            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                if (inDegree[v] == -1) {
                    inDegree[v] = i;   //note that in indegree array we keep a track of the edge index
                } else {
                    potential1 = i;    //latest edge cycle index is present in potential1
                    potential2 = inDegree[v];
                    break;
                }
            }

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                if (i == potential1)
                    continue;
                if (!union(edge[0], edge[1], parents, ranks)) { //if an edge return false then that is th redundant one
                    if (potential1 == -1)
                        return edge;
                    else
                        return edges[potential2];
                }
            }
            return edges[potential1];

        }


        private int find(int n, int[] parents) {
            int p = parents[n];
            while (p != parents[p]) { //i.e. parent is not the same as the same node itself
                parents[p] = parents[parents[p]];//path-compression.this is optional and can be commented as well
                //the above line is used to increase effeciency
                p = parents[p];
            }
            return p;
        }

        //perfoms union
        private boolean union(int node1, int node2, int[] parents, int[] ranks) {
            int parent1 = find(node1, parents);
            int parent2 = find(node2, parents);

            if (parent1 == parent2) //i.e they are already connected to the same parent.
                return false;

            if (ranks[parent1] > ranks[parent2]) {
                parents[parent2] = parent1;
                ranks[parent1] = ranks[parent1] + ranks[parent2]; //increasing the rank by 1 since were are adding one children
            } else {
                parents[parent1] = parent2;
                ranks[parent2] = ranks[parent2] + ranks[parent1];
            }

            return true;

        }


    }

}
