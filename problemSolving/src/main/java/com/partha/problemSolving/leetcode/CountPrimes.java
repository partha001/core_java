package com.partha.problemSolving.leetcode;

/**
 * link : https://leetcode.com/problems/symmetric-tree/
 * @author biswaspa
 *
 */
public class CountPrimes {

	public static void main(String[] args) {
		System.out.println(new Solution1().countPrimes(5));

	}
	
	//2 => 0
	//3=>1
	//5=>2

	static class Solution1 {
//	    public int countPrimes(int n) {
//	        if(n<=1){
//	            return 0;
//	        }
//	        else if(n==2){
//	            return 1;
//	        }else if(n==3){
//	            return 2;
//	        }else {
//	            int primeCount=2;
//	            int i=1;
//	            String flag  = "case1";
//	            for(int j=4;j<=n;j++){
//	               if(flag.equals("case1") && 6*i-1==j){
//	                   primeCount++;
//	                   flag="case2";
//	               }
//	                else if(flag.equals("case2") && 6*i+1==j){
//	                    primeCount++;
//	                    flag="case1";
//	                    i++;
//	                }
//	            }
//	            return primeCount;
//	        }
//	    }
		
		
		 public int countPrimes(int n) {
		        if(n<=2) return 0;
		        boolean[] not_prime = new boolean[n];
		        for(int i=2;i*i<n;i++){
		            if(not_prime[i]) continue;
		            for(int j=i*i;j<n;j+=i){
		                not_prime[j] = true;
		            }
		        }
		        int count=1;
		        for(int i=3;i<n;i+=2) if(!not_prime[i]) count++;
		        return count;
		    }
	}
	
}
