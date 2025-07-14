package org.example.auz.blind75.week1;

/**
 * Valid Palindrome
 *
 * desc: https://leetcode.com/problems/valid-palindrome/description/
 */
public class Num5_2 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            while (start < end && Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
