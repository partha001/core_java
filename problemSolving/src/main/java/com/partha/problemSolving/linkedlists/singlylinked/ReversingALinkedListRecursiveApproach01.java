package com.partha.problemSolving.linkedlists.singlylinked;

/**
   1) Divide the list in two parts - first node and rest of the linked list.
   2) Call reverse for the rest of the linked list.
   3) Link rest to first.
   4) Fix head pointer
 * @author parbiswa
 *
 */
public class ReversingALinkedListRecursiveApproach01 {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(); 
        list.head = new Node(1); 
        list.head.next = new Node(2); 
        list.head.next.next = new Node(3); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(5); 
        list.head.next.next.next.next.next = new Node(6); 
        list.head.next.next.next.next.next.next = new Node(7); 
        list.head.next.next.next.next.next.next.next = new Node(8); 
        
        System.out.println("initial linkedlist");
        printList(list);
        Node node = reverse(list.head);
        LinkedList reversedList = new LinkedList(node);
        System.out.println("\nreversed linkedlist");
        printList(reversedList);
	}
	
	// Complete the reverse function below. 
    static Node reverse(Node head) { 
        if(head == null) { 
            return head; 
        } 
  
        // last node or only one node 
        if(head.next == null) { 
            return head; 
        } 
  
        Node newHeadNode = reverse(head.next); 
  
        // change references for middle chain 
        head.next.next = head; 
        head.next = null; 
  
        // send back new head node in every recursion 
        return newHeadNode; 
    } 
  
	// prints content of double linked list 
    static void printList(LinkedList list) { 
    	Node node = list.head;
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  

	
	static class LinkedList{

		Node head;

		LinkedList(){
			super();
		}
		
		LinkedList(Node node){
			super();
			this.head = node;
		}

	}



	static class Node{

		int data;
		Node next;

		Node(int data){
			super();
			this.data = data;
		}

	}

}
