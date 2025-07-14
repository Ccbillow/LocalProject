package org.example.auz.blind75.week2;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Num4 {
    public int longestPalindrome(String s) {
        int length = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                length = length + 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if (set.size() > 0) {
            length = length + 1;
        }
        return length;
    }

}
