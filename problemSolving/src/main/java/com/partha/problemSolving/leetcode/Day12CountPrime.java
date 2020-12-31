package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/count-primes/
 * @author biswaspa
 *
 */
public class Day12CountPrime {

	public static void main(String[] args) {
		System.out.println(new Solution1().countPrimes(10));
	}
	

	static class Solution1 {
		
		/**
		 * https://www.youtube.com/watch?v=UMVa5fRKC8I
		 * @param n
		 * @return
		 */
		public int countPrimes(int n) {
			boolean[] arr = new boolean[n]; //array to store the results			
			for(int i=0;i<n;i++) {//populating the array
				arr[i] = true;
			}
			
			for(int i=2; i*i <n ;i++) {
				if(arr[i]) {
					for(int j=i ; j*i <n ;j++ ) { //setting all multiples of arr[i] to false
						arr[j*i] = false;
					}
				}
			}
			
			int primeCount = 0;
			for(int i=2;i<n;i++) { //since prime number starts from 2
				if(arr[i])
					primeCount++;
			}
			
			return primeCount;
		}
	}
	
	/**
	 * same solution as above . just optimising the code i.e. here we will do the reverse. i.e. for primeCount we will count the number of false.
	 * this will reduce the first loop where we are filling it up.
	 * @author biswaspa
	 *
	 */
	static class Solution2{
		
		public int countPrimes(int n) {
			boolean[] arr = new boolean[n]; //by default all elements will have false.
			
			for(int i=2; i*i <n ;i++) {
				if(!arr[i]) {
					for(int j=i ; j*i <n ;j++ ) { 
						arr[j*i] = true;
					}
				}
			}
			
			int primeCount = 0;
			for(int i=2;i<n;i++) { //since prime number starts from 2
				if(!arr[i])
					primeCount++;
			}
			
			return primeCount;
		}
	}

}
