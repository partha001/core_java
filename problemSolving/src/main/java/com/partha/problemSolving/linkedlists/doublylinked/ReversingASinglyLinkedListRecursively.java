package com.partha.problemSolving.linkedlists.doublylinked;

/**
 * @status : wip
 * @author parbiswa
 *
 */
public class ReversingASinglyLinkedListRecursively {

	public static void main(String[] args) {
		LinkedList list = new ReversingASinglyLinkedListRecursively().new LinkedList();
		list.addFirst(10);
		list.addFirst(5);
		list.addLast(20);
//		list.addLast(30);
//		list.addLast(40);
		printList(list);
		System.out.println(list.size);
		printList(reverseRecursively(list));
	}
	
	public static LinkedList reverseRecursively(LinkedList list){
		LinkedList reverselist = new ReversingASinglyLinkedListRecursively().new LinkedList();		
		return reverseRecursively(reverselist, list);
	}
	
	
	public static LinkedList reverseRecursively(LinkedList reverseList, LinkedList list){
		if(list.head.next==null)
			return list;
		else{
			Node current = list.head;
			while(current.next!=null){
				current = current.next;
			}
			reverseList.addLast(current.data);
			//list.head = list.head.next ;
			current.previous.next= null;
			return reverseRecursively(reverseList,list);
		}
			
	}
	
	public static void printList(LinkedList list){
		System.out.println("printing list");
		Node current = list.head;
		while(current!=null){
			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}
	
	class  LinkedList{
		
		Node head;
		int size = 0; 
		
		LinkedList(){
			this.head = null;
		}
		
		public void addFirst(int data){
			Node node = new Node(data);
			if(this.head == null){
				this.head = node;
				size++;
			}else{
				node.next = this.head;
				this.head.previous = node ;
				this.head = node;
				size++;
			}
		}
		
		public void addLast(int data){
			Node node = new Node(data);
			if(this.head == null){
				this.head = node;
				size++;
			}else {
				Node current = this.head;
				while(current.next!=null){
					current = current.next;
				}
				current.next = node;
				node.previous = current;
				size++;
			}
		}
	}
	
	class Node{
		int data;
		Node previous;
		Node next;
		
		Node(int data){
			super();
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}

}
