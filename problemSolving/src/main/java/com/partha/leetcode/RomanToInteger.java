package com.partha.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * @author biswaspa
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(new Solution1().romanToInt("MCMXCIV"));
    }


    private static class Solution1 {
        public int romanToInt(String s) {
            int result = 0;
            int lastInteger = 0;
            char[] arr = s.toCharArray();
            int arrLength = arr.length;

            for (int i = arrLength - 1; i >= 0; i--) {
                char currentChar = arr[i];
                int currentCharToInt = romanCharToInteger(currentChar);
                if (i == (arrLength - 1)) {
                    result = result + currentCharToInt;
                } else {
                    if (currentCharToInt >= lastInteger) {
                        result = result + currentCharToInt;
                    } else {
                        result = result - currentCharToInt;
                    }
                }
                lastInteger = currentCharToInt;
            }
            return result;
        }

        public int romanCharToInteger(Character c) {
            switch (c) {
                case ('I'):
                    return 1;
                case ('V'):
                    return 5;
                case ('X'):
                    return 10;
                case ('L'):
                    return 50;
                case ('C'):
                    return 100;
                case ('D'):
                    return 500;
                case ('M'):
                    return 1000;
                default:
                    throw new RuntimeException();
            }
        }
    }
}


