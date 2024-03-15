package com.partha.leetcode;

/**
 * https://leetcode.com/problems/valid-palindrome
 *
 * @author partha
 */
public class ValidPalindrome {

    public static void main() {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(new Solution2().isPalindrome(input));
    }

    private static class Solution1 {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return true;
            }

            String input = s.toLowerCase();
            char[] arr = input.toCharArray();
            int start = 0;
            int end = input.length() - 1;
            //System.out.println(arr.length-1);
            while (start < end) {
                boolean startValid = isValidCharacter(arr[start]);
                boolean endValid = isValidCharacter(arr[end]);
                if (startValid && endValid) {
                    if (arr[start] == arr[end]) {
                        start++;
                        end--;
                    } else {
                        return false;
                    }
                }

                if (!startValid) {
                    start++;
                }
                if (!endValid) {
                    end--;
                }
            }
            return true;
        }


        private boolean isValidCharacter(char c) {
            int startAscii = 'a';
            int endAscii = 'z';
            int currentAscii = c;
            if ((startAscii <= currentAscii && currentAscii <= endAscii) //condition for characters
                    || (48 <= currentAscii && currentAscii <= 57)   //condition for numbers
            ) {
                return true;
            } else {
                return false;
            }
        }
    }


    private static class Solution2 {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            //System.out.println(s);
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                char charLeft = s.charAt(left);
                char charRight = s.charAt(right);
                if (!Character.isAlphabetic(charLeft)) {
                    left++;
                    continue;
                }

                if (!Character.isAlphabetic(charLeft)) {
                    right--;
                    continue;
                }

                if (charLeft != charRight) {
                    return false;
                }
                left++;
                right--;


            }
            return true;
        }
    }

}
