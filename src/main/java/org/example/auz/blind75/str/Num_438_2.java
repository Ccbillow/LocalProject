package org.example.auz.blind75.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_438_2 {

    public static List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        List<Integer> res = new ArrayList();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= len) {
                sCount[s.charAt(i - len) - 'a']--;
            }

            if (Arrays.equals(pCount, sCount)) {
                res.add(i - len + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(findAnagrams("cbaebabacd", "abc"));
//        System.out.println(findAnagrams("baa", "aa"));
        System.out.println(findAnagrams("aaabb", "bb"));
    }
}
