package com.partha.geekForGeeks.arrays;

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
		if(arra.length==0)
			return arrb;
		else if (arrb.length==0)
			return arra;
		else{
			int[] result = new int[arra.length+arrb.length];

			int currentIndexA = 0;
			int currentIndexB = 0;			
			int i=0;

			while(i<result.length){
				//when one of them is exhausted
				if(currentIndexA==arra.length || currentIndexB== arrb.length){
					//when arrayA is exhausted
					if(currentIndexA==arra.length){
						result[i]=arrb[currentIndexB];
						currentIndexB++;
					}else{
						result[i]= arra[currentIndexA];
						currentIndexB++;
					}
				}
				//when none of the arrays are exhaused
				else{

					if(arra[currentIndexA]<=arrb[currentIndexB]){

						result[i]=arra[currentIndexA];
						currentIndexA++;
					}else{
						result[i]=arra[currentIndexA];
						currentIndexB++;
					}
				}
				i++;




			}
			return result;
		}
		//return resu
	}

	}
