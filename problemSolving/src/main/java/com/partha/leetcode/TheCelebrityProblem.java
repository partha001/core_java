package com.partha.leetcode;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 * @author partha
 */
public class TheCelebrityProblem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] input = new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
        new TheCelebrityProblem.Solution1().findCelebrity(input);
    }


    /**
     * https://www.youtube.com/watch?v=CiiXBvrX-5A
     *
     * @author partha
     */
    private static class Solution1 {

        public static void findCelebrity(int[][] input) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < input.length; i++) {
                stack.push(i);
            }

            while (stack.size() >= 2) {
                int i = stack.pop();
                int j = stack.pop();
                if (input[i][j] == 1) { // i knows j . then i not a celebrity
                    stack.push(j);
                } else { // if i doesnt know j then j is not a celebrity
                    stack.push(i);
                }
            }

            int potential = stack.pop();
            for (int i = 0; i < input.length; i++) {
                if (i != potential) { // to skip checking whether potential knows itself or not . but only to check for others
                    if (input[i][potential] == 0 || input[potential][i] == 1) {
                        System.out.println("none");
                        return;
                    }
                }
            }
            System.out.println(potential);

        }
    }


    /**
     * https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
     * same code as above written for geekForGeeks practice link in mind
     */
    private static class Solution2 {

        int celebrity(int input[][], int n) {

            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < n; i++) {
                stack.push(i);
            }

            while (stack.size() >= 2) {
                int i = stack.pop();
                int j = stack.pop();
                if (input[i][j] == 1) { // i knows j . then i not a celebrity
                    stack.push(j);
                } else { // if i doesnt know j then j is not a celebrity
                    stack.push(i);
                }
            }

            int potential = stack.pop();
            for (int i = 0; i < input.length; i++) {
                if (i != potential) { // to skip checking whether potential knows itself or not . but only to check for others
                    if (input[i][potential] == 0 || input[potential][i] == 1) {
                        return -1; //no celebrity present
                    }
                }
            }
            return potential;
        }
    }

}
