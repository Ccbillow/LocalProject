package org.example.auz.blind75.str;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        while (left != right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
