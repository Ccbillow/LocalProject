package org.example.auz.blind75.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 */
public class Num_567 {

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();

        for (char c:s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left =0 ;
        int right = 0;
        int valid = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            if (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char rmChar = s2.charAt(left);
                if (need.containsKey(rmChar)) {
                    if (window.get(rmChar).equals(need.get(rmChar))) {
                        valid--;
                    }
                    window.put(rmChar, window.get(rmChar) - 1);
                }
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
