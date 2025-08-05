package org.example.auz.blind75.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * time: O(n + m)
 * space: O(n)
 */
public class Num_76 {

    public String minWindow(String s, String t) {
        // target: char - times<>
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // source: char - times<>
        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int flag = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(c).intValue() == tMap.get(c).intValue()) {
                    flag++;
                }
            }

            //
            while (flag == tMap.size()) {
                if (right - left < min) {
                    index = left;
                    min = right - left;
                }

                // decrease window size
                char leftItem = s.charAt(left);
                left++;
                if (tMap.containsKey(leftItem)) {
                    if (sMap.get(leftItem).intValue() == tMap.get(leftItem).intValue()) {
                        flag--;
                    }
                    sMap.put(leftItem, sMap.get(leftItem) - 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(index, index + min);
    }
}
