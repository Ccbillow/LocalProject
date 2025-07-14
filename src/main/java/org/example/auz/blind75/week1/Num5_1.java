package org.example.auz.blind75.week1;

/**
 * Valid Palindrome
 *
 * desc: https://leetcode.com/problems/valid-palindrome/description/
 */
public class Num5_1 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
