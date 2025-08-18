package org.example.auz.practice.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/description/
 */
public class Num_567 {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int flag = 0;

        Map<Character, Integer> window = new HashMap<>();

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    flag++;
                }
            }

            while (right - left >= s1.length()) {
                if (flag == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        flag--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
