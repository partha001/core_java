package com.partha.importantUsecases.hashtables;

public class ImplementingHashTable {
	
	public static void main(String[] args){
		//MyhashTable hashTable = new MyhashTable();
	}
	
	class MyhashTable{
		double loadFactor =0.75; //default load factor
		int size=16; //default size
		
		private HashNode[] buckets;
		
		public MyhashTable(){
			buckets = new HashNode[size];
		}
		
		public MyhashTable(int loadFactor , int size){
			this.size = size;
			this.loadFactor = loadFactor;
			buckets = new HashNode[size];
		}
		
		
		
	}

	class HashNode<K,V>{
		K key;
		V value;
		
		public HashNode(K key , V value) {
			this.key= key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}	
		
	}
	
	class Employee{
		private Integer id;
		private String name;
			
		public Employee(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	

}
