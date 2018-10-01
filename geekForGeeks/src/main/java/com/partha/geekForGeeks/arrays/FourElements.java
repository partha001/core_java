package com.partha.geekForGeeks.arrays;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FourElements {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int i=scanner.nextInt();
		for(int j=0;j<i;j++){
			int length=scanner.nextInt();

			int[] arr=new int[length];
			
			for(int k=0;k<length;k++){
				arr[k]=scanner.nextInt();
			}
			int sum=scanner.nextInt();
		
			Set<Integer> myset=new TreeSet<>();
			IntStream.range(0, length)
			.forEach(l -> {
				myset.add(arr[l]);
			});;
			
			List<Integer> mylist = myset.stream().collect(Collectors.toList());
			


			if(length<4){
				System.out.println(0);
			}
			else{
				if((mylist.get(0).intValue()+mylist.get(1).intValue()+mylist.get(2).intValue()+mylist.get(3).intValue())==sum){
					System.out.println(1);
				}else{
					System.out.println(0);
				}
				
			}


		}
	}

}
