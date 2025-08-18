package org.example.auz.practice.arr;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        s = sb.toString();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
