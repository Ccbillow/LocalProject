package org.example.auz.blind75.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/
 *
 *  time: O(n)
 *  space: O(n)
 */
public class Num_242 {


    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer i : map.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
