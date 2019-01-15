package com.partha.ds01.linkedlist.doublylinked01;

public class DoublyLinkedList {
	
	public Node head ;
	
	
	/** utility methods start here **/
	
	public void addFirst(Node node){
		if(this.head!=null){
			this.head.setPreviousNode(node);
			node.setNextNode(this.head);
			this.setHead(node);
		}else{
			this.setHead(node);
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
			current = current.getNextNode();
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
			result += current.getData() + " ";
			current = current.getNextNode();
		}
		return result + " ]";
	}
	
	
	
	
	
}
