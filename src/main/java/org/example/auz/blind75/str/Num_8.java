package org.example.auz.blind75.str;

/**
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * time: O(n)
 * space: O(1)
 *
 */
public class Num_8 {

    public static int myAtoi(String s) {
        s = s.trim();

        int left = 0;
        long res = 0;
        boolean negative = false;

        if (s.isEmpty()) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            negative = true;
            left++;
        }
        if (s.charAt(0) == '+') {
            left++;
        }

        while (left < s.length()) {
            if (s.charAt(left) < '0' || s.charAt(left) > '9') {
                break;
            }

            res = res * 10 + (s.charAt(left) - '0');
            if (negative && res >= Math.pow(2, 31)) {
                return Integer.MIN_VALUE;
            }
            if (res > Math.pow(2, 31) - 1) {
                return Integer.MAX_VALUE;
            }
            left++;
        }

        if (negative) {
            res = res * (-1);
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }
}
