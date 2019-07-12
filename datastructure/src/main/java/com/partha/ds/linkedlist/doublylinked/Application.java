package com.partha.ds.linkedlist.doublylinked;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList dll= new DoublyLinkedList();
		//inserting the first node
		Node node = new Node(10);
		dll.addFirst(node);
		System.out.println(dll.toString());  //10
		//adding another node at first 
		node = new Node(5);
		dll.addFirst(node);
		System.out.println(dll.toString()); // 5,10
		//checking if the length() is working properly or not
		System.out.println(dll.length());   //2
		
	}
	
	public static class DoublyLinkedList{
		
		public Node head ;
		
		
		/** utility methods start here **/
		
		public void addFirst(Node node){
			if(this.head!=null){
				this.head.previousNode=node;
				node.nextNode=this.head;
				this.head=node;
			}else{
				this.head=node;
			}
		}
		
		public void addLast(Node node){
			//to be completed
		}
		
		public void removefirst(){
		//to be completed	
		}
		
		public void removeLast(){
			//to be completed
		}
		
		
		public int length(){
			int count=0;
			Node current = this.head;
			while(current!=null){
				count++;
				current = current.nextNode;
			}
			return count;
		}
		
		/** utility methods end here  **/
		
		
		
		
		public void setHead(Node head) {
			this.head = head;
		}

		
		@Override
		public String toString() {
			String result = "[ ";
			Node current = this.head;
			while(current != null) {
				result += current.data + " ";
				current = current.nextNode;
			}
			return result + " ]";
		}
		
	}
	
	public static class Node{
		
		 int data;
		 Node nextNode;
		 Node previousNode;
		
		public Node(int data) {
			super();
			this.data = data;
		}
	}

}
