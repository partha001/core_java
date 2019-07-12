package com.partha.ds.linkedlist.singlylinked01;

public class LinkedList {
	
	private Node head;
	
	/** utility methods start here **/
	public void addFirst(Node node){
		node.setNextNode(this.head);
		this.head= node;
	}
	
	public void addLast(Node node){
		if(this.head==null)
			this.addFirst(node);
		else{
			Node current=this.head;
			while(current!=null){
				if(current.getNextNode()==null){
					current.setNextNode(node);
					break;
				}
				current=current.getNextNode();
			}
		}
			
	}
	
	public void deleteFromHead(){
		this.head=this.getHead().getNextNode();
	}
	
	/**
	 * 
	 * @param data
	 * @return will return the node if it find the data otherwise will return null
	 */
	public Node find(int data){
		Node current = this.head;
		while(current!=null){
			if(current.getData()==data)
				return current;
			current = current.getNextNode();
		}
		return null;
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
	
	
	/** utility methods end here **/
	
	

	public Node getHead() {
		return head;
	}

	@Override
	public String toString() {
		String result = "[";
		Node current= this.head;
		
		while (current!=null){
			result += current.getData() +" ";
			current=current.getNextNode();
		}
		return result+="]";
		
	}
	
	
	
	
	

}
