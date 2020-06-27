package com.partha.problemSolving.arrays;

/**
 * @problem : given two sorted arrays . merge two sorted arrays
 * @timecomplexity : O(m + n)
 * @author parbiswa
 *
 */
public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] arrA=new int[]{10,12,14,16};
		int[] arrB=new int[]{11,23};
		int[] result= mergeSortedArrays(arrA,arrB);
		
		//printing the result
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}

	public static int[] mergeSortedArrays(int[] arra,int[] arrb){
		int[] resultArr = new int[arra.length+arrb.length];
		int a=0;
		int b=0;
		int c=0;
		while(a<arra.length && b<arrb.length) {
			if(arra[a]<=arrb[b]) {
				resultArr[c]= arra[a];
				a++;
			}else {
				resultArr[c] = arrb[b];
				b++;
			}
			c++;
		}
		
		while(a<arra.length) {
			resultArr[c]= arra[a];
			c++;
			a++;
		}
		
		while(b<arrb.length) {
			resultArr[c] = arrb[b];
			c++;
			b++;
		}
		
		return resultArr;
	}
	
}
