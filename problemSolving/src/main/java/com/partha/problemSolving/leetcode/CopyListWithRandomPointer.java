package com.partha.problemSolving.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * @author biswaspa
 *
 */
public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	private static class Solution {
		public Node copyRandomList(Node head) {
			if(head==null)
				return head;
			Map<Node,Node> map = new HashMap();
			Node current = head;
			while(current!=null){
				Node temp = new Node(current.val);
				map.put(current,temp);
				current = current.next;
			}

			current = head;
			Node clone = null;
			while(current!=null){
				Node dummy = map.get(current); 
				dummy.next = map.get(current.next);
				dummy.random = map.get(current.random);

				if(clone == null){
					clone = dummy;
				}

				current = current.next;

			}
			return clone;

		}
	}


	private static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}

	}
	
}
