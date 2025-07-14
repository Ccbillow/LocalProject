package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Anagram
 *
 * desc: https://leetcode.com/problems/valid-anagram/description/
 */
public class Num7 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer value : charMap.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
