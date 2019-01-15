package com.partha.ds01.sorting;

public class BubbleSortUsingGenerics {
	
	public static void main(String[] args){
		
	}
	
//	public static <T extends Comparable<T>> genericBubbleSort(<T extends Comparable>[] arr){
//		
//		for(int i=0;i<arr.length-2;i++){
//			for(int j=0;j<arr.length-2-i;j++){
//				if(){
//					Comparable temp=arr[j+1];
//					arr[j+1]=arr[j];
//					arr[j]=temp;
//				}
//			}
//		}
//		
//		
//	}

}




class Circle implements Comparable {
	
	public int radius;

	public int compareTo(Object o) {
	Circle obj= (Circle)o;
	if(this.radius > obj.radius)
		return 1;
	else if (this.radius < obj.radius)
		return -1;
	else 
		return 0;
	}

	public Circle(int radius) {
		super();
		this.radius = radius;
	}
	
}
