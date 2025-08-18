package org.example.auz.practice.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class Num_76 {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (min > right - left) {
                    min = right - left;
                    res = s.substring(left, right);
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {

                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }


    public String min(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int flag = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            // add right
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    flag++;
                }
            }

            // remove left
            while (flag == need.size()) {
                if (min > right - left) {
                    min = right - left;
                    res = s.substring(left, right);
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        flag--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
