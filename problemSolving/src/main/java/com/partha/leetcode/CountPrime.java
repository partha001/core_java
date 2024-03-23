package com.partha.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-primes/
 *
 * @author biswaspa
 */
public class CountPrime {

    public static void main(String[] args) {
        System.out.println(new Solution1().countPrimes(10));
    }


    static class Solution1 {

        /**
         * https://www.youtube.com/watch?v=UMVa5fRKC8I
         *
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            boolean[] arr = new boolean[n]; //array to store the results
            Arrays.fill(arr, true); //populating the array


            for (int i = 2; i * i < n; i++) {
                if (arr[i]) {
                    for (int j = i; j * i < n; j++) { //setting all multiples of arr[i] to false
                        arr[j * i] = false;
                    }
                }
            }

            int primeCount = 0;
            for (int i = 2; i < n; i++) { //since prime number starts from 2
                if (arr[i])
                    primeCount++;
            }

            return primeCount;
        }
    }

    /**
     * same solution as above . just optimising the code i.e. here we will do the reverse. i.e. for primeCount we will count the number of false.
     * this will reduce the first loop where we are filling it up.
     *
     * @author biswaspa
     */
    static class Solution2 {

        public int countPrimes(int n) {
            boolean[] arr = new boolean[n]; //by default all elements will have false.

            for (int i = 2; i * i < n; i++) {
                if (!arr[i]) {
                    for (int j = i; j * i < n; j++) {
                        arr[j * i] = true;
                    }
                }
            }

            int primeCount = 0;
            for (int i = 2; i < n; i++) { //since prime number starts from 2
                if (!arr[i])
                    primeCount++;
            }

            return primeCount;
        }
    }

}
/**
 *To test whether a number is prime or not, why do we have to test whether it is divisible only up to the square root of that number?
 *
 *
 * If a number n is not a prime, it can be factored into two factors a and b:
 * n = a * b
 * Now a and b can't be both greater than the square root of n, since then the
 * product a * b would be greater than sqrt(n) * sqrt(n) = n. So in any factorization of n,
 * at least one of the factors must be less than or equal to the square root of n, and if
 * we can't find any factors less than or equal to the square root, n must be a prime
 */
