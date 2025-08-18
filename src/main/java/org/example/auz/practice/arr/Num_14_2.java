package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * time: O(N log N)
 * space: O(1)
 */
public class Num_14_2 {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return s1.substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        longestCommonPrefix(strs);
    }
}
