package com.partha.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindingTheNumbers {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int i=scanner.nextInt();
		for(int j=0;j<i;j++){
			int n=scanner.nextInt();
			int length=2*n+2;

			int[] arr=new int[length];
			
			for(int k=0;k<length;k++){
				arr[k]=scanner.nextInt();
			}
			
			
			Map<Integer, Integer> map=new HashMap<>();
			for(int p=0;p<arr.length;p++) {
				if(map.containsKey(arr[p])) {
					map.put(arr[p], map.get(arr[p]).intValue()+1);
				}else {
					map.put(arr[p], 1);
				}
			}
			
			for(Integer r: map.keySet()) {
				if(map.get(r).intValue()==1)
					System.out.print(r+ " ");
			}		
		}

	}

}
