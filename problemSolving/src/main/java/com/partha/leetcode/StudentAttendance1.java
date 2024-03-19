package com.partha.leetcode;

/**
 * https://leetcode.com/problems/student-attendance-record-i
 *
 * @author biswaspa
 */
public class StudentAttendance1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


    private static class Solution1 {
        public boolean checkRecord(String s) {
            int absent = 0;
            int late = 0;
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == 'A') {
                    absent++;
                    late = 0; //resetting late count if not consecutively late
                } else if (c == 'L') {
                    late++;
                } else {
                    late = 0; //resetting late count if not consecutively late
                }

                if (absent == 2 || late == 3)
                    return false;

                i++;
            }
            return true;
        }
    }


    private static class Solution2 {
        public boolean checkRecord(String s) {
            int absent = 0;
            String temp = "";
            for (char c : s.toCharArray()) {
                if (c == 'A')
                    absent++;

                if (c == 'L') {
                    temp += 'L';
                } else {
                    temp = "";
                }

                if (absent >= 2 || temp.length() >= 3)
                    return false;
            }
            return true;
        }
    }


}
