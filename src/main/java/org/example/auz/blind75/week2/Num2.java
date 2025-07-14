package org.example.auz.blind75.week2;

import java.util.HashMap;
import java.util.Map;

/**
 *  Ransom Note
 *
 *  desc: https://leetcode.com/problems/ransom-note/description/
 */
public class Num2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) - 1);
        }

        for (Integer value : map.values()) {
            if (value < 0) {
                return false;
            }
        }
        return true;
    }
}
