package com.partha.problemSolving.strings;

/**
 * comment : this program has got better space complexity
 * @author parbiswa
 *
 */
public class ReversingString02 {

	public static void main(String[] args) {
		String s="indiay";
		System.out.println(reverse(s));

	}
	
	public static String reverse(String s){
		char[] arr= s.toCharArray();
		if(arr.length<=1)
			return s;
		else{
			for(int i=0;i<arr.length/2;i++){
				char temp = arr[i];
				arr[i]=arr[arr.length-i-1];
				arr[arr.length-i-1]= temp;
			}
			return new String(arr);
		}
	}

}
