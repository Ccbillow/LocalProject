package org.example.auz.blind75.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * time : O(n)
 * space: O(n)
 */
public class Num_409 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else if (map.get(s.charAt(i)) == 0) {
                map.put(s.charAt(i), 1);
            } else if (map.get(s.charAt(i)) == 1){
                map.put(s.charAt(i), 0);
                res = res + 2;
            }
        }

        boolean flag = false;
        for (Integer value : map.values()) {
            if (value == 1) {
                flag = true;
            }
        }
        if (flag) {
            res++;
        }

        return res;
    }

    public int longestPalindrome2(String s) {
        Map<Character, Integer> char2Nums = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char Char = s.charAt(i);
            if (char2Nums.get(Char) == null) {
                char2Nums.put(Char, 1);
            } else if (char2Nums.get(Char) == 0) {
                char2Nums.put(Char, 1);
            } else if (char2Nums.get(Char) == 1) {
                char2Nums.put(Char, 0);
                res = res + 2;
            }
        }

        boolean flag = false;
        for (Integer value : char2Nums.values()) {
            if (value == 1) {
                flag = true;
            }
        }
        if (flag) {
            res++;
        }
        return res;
    }
}
