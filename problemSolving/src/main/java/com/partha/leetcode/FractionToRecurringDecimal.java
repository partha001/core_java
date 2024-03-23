package com.partha.leetcode;


import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/fraction-to-recurring-decimal
 */
public class FractionToRecurringDecimal {

    public static void main(String[] args) {

    }

    private static class Solution1 {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder ans = new StringBuilder();
            if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) //cases1: when the result is negative
                ans.append("-");

            long num = (long) Math.abs((long) numerator);
            long den = (long) Math.abs((long) denominator);

            long quotient = num / den;
            long remainder = num % den;

            ans.append(String.valueOf(quotient)); //appending the value to the left of decimal

            if (remainder == 0) //if remainder is zero then return
                return ans.toString();

            ans.append(".");

            Map<Long, Integer> map = new HashMap<>(); //here the key=remainder and value= length of answer before doing division

            while (remainder != 0) { //keep dividing till remainder is not zero
                if (map.containsKey(remainder)) {  //if the remainder is already found means its recurring
                    int pos = map.get(remainder);  //hence we get the position and 1.add "(" at the position and then add ")" at the end
                    ans.insert(pos, "(");
                    ans.append(")");
                    return ans.toString();
                } else {
                    map.put(remainder, ans.length()); //first we put the remainder and answer length in the map.
                    remainder *= 10;  //making remainder greater than denominator by multiplying with 10
                    quotient = remainder / den; //now dividing the remainder with denominator
                    ans.append(String.valueOf(quotient)); //append quotiient to answer
                    remainder %= den; //updating remainder using moduler division
                }
            }
            return ans.toString();
        }
    }
}
