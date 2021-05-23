package com.partha.problemSolving.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveNthNodeFromEndOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}




	//execution time 1ms
	private static class Solution1 {
		
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if(head==null)
				return head;
			if(head.next==null && n==1)
				return null;

			ListNode current = head;
			Stack<ListNode> stack = new Stack();
			while(current!=null){
				stack.push(current);
				current = current.next;
			}

			int nodeCount = 1;
			ListNode temp = null;


			while(!stack.isEmpty() && nodeCount<=n){
				current = stack.pop();
				if(nodeCount==n){
					temp = current;
					break;
				}
				nodeCount++;
			}

			if(temp!=null){
				if(stack.isEmpty()) //when element to be removed is the head
					return temp.next;

				current = stack.pop();
				if(temp.next==null) // when element to be removed is the last element
					current.next = null;
				else
					current.next = temp.next;

			}
			return head;
		}
	}
	
	//using hashmap
	private static class Solution2 {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        Map<Integer, ListNode> nodes = new HashMap<>();
	        ListNode curr = head;
	        Integer count = 0;
	        
	        while(curr != null){
	            nodes.put(count, curr);
	            curr = curr.next;
	            count++;
	        }
	        
	        if(n == count){
	            //Delete first node
	            return head.next;
	        }
	        
	        ListNode beforeDeleted = nodes.get(count - n - 1);
	        ListNode toBeDeleted = nodes.get(count - n);
	        
	        beforeDeleted.next = toBeDeleted.next;
	            

	        return head;
	    }
	}
	
	
	//execution time 0ms
	private static class Solution3 {
	    
	    int size = 0;
	    int indexFromLast =0;       
	    ListNode targetNode = null;
	    ListNode previous = null;
	    
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(head==null || (head.next==null && n==1))
	            return null;
	        find(head,1,n);
	        if(n==1){
	            previous.next = null;
	        }else if(n==size){
	            head = head.next;
	        }else{
	            previous.next = targetNode.next;
	        }
	        return head;
	    }
	    
	    
	    private void find(ListNode node, int current, int target){
	       this.size ++;
	       if(node.next!=null) find(node.next,current+1,target);
	        this.indexFromLast++;
	        if(this.indexFromLast==target){
	            targetNode = node;
	        }
	        if(this.indexFromLast==target+1){
	            previous = node;
	        }
	    }
	}
	
	
	
	//even better performance with less memory
	private static class Solution4 {
	    
	    int size = 0;
	    
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(head==null || (head.next==null && n==1))
	            return null;
	        return remove(head,1,n);
	    }
	    
	    
	    private ListNode remove(ListNode node, int current, int target){
	        if(node==null)
	            return null;
	        this.size++;
	        ListNode returnedNode = remove(node.next,current+1,target);
	        if(size-current+1==target){
	            return returnedNode;
	        }
	        node.next = returnedNode;
	        return node;
	    }

	}
	
	
	
	
	

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

}
