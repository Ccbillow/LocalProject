package org.example.auz.practice.arr;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Num_14_1 {
    public static String longestCommonPrefix(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();

        String base = strs[0];
        int min = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != base.charAt(j)) {
                    return base.substring(0, min);
                }
            }
            min++;
        }
        return base;
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        longestCommonPrefix(strs);
    }
}
