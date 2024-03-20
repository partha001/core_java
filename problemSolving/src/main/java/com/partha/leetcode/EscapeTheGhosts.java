package com.partha.leetcode;

/**
 * https://leetcode.com/problems/escape-the-ghosts/
 */
public class EscapeTheGhosts {


    public static void main(String args[]){

    }


    /**
     * https://www.youtube.com/watch?v=W36Kd71Y4vs
     */
    private static class Solution {
        public boolean escapeGhosts(int[][] ghosts, int[] target) {
            int myDistance = Math.abs(target[0]) + Math.abs(target[1]); //finding manhattan distance. since its against origin to only target values are taken
            for(int i=0;i<ghosts.length;i++){
                int[] ghost = ghosts[i];
                int ghostDistance = Math.abs(target[0] - ghost[0] ) + Math.abs( target[1] - ghost[1]);
                if(ghostDistance<=myDistance) //if ghost can reach the destination before me then return false
                    return false;
            }
            return true;
        }
    }


}
