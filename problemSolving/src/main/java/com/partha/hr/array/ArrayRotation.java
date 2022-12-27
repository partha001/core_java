package com.partha.hr.array;

import java.util.stream.IntStream;

/**
 * source: https://www.hackerrank.com/challenges/array-left-rotation/problem
 * @author partha
 *
 */
public class ArrayRotation {

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,5};
		int n = a.length;
		int d=1;

		if(d<n){
			int[] temp = new int[d];

			for(int i=0;i<d;i++){
				temp[i]=a[i];
			}

			int j = 0;
			for(int i=d;i<n;i++){
				a[j++]=a[i];
			}

			for(int i=0;i<temp.length;i++){
				a[j++]=temp[i];
			}


			IntStream.range(0,a.length)
			.forEach(i->{ System.out.print(a[i]+" "); 
			});

		}
	}

}


