package org.example.auz.practice.str;

import javax.cache.configuration.Factory;
import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Most Two Distinct Characters
 */
public class Num_159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;

        Map<Character, Integer> window = new HashMap<>();
        int res = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            window.put(rChar, window.getOrDefault(rChar, 0) + 1);
            right++;

            while (window.size() > 2) {
                char lChar = s.charAt(left);
                window.put(lChar, window.get(lChar) - 1);
                if (window.get(lChar) == 0) {
                    window.remove(lChar);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
