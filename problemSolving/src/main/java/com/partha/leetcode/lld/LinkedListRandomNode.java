package com.partha.leetcode.lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * problem statement: https://leetcode.com/problems/linked-list-random-node
 */
public class LinkedListRandomNode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    private static class Solution1 {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();

        public Solution1(ListNode head) {
            while(head!=null){
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            int randomIndex = random.nextInt(list.size());
            return list.get(randomIndex);
        }
    }

    private static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
