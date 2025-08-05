package org.example.auz.blind75.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * time: O(s * p)
 * space: O(n)
 */
public class Num_438_1 {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res= new ArrayList();
        int len = p.length();
        Map<Character, Integer> pmap = new HashMap<>();
        for (Character c : p.toCharArray()) {
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length() - len + 1; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < i + len; j++) {
                char c = s.charAt(j);
//                map.merge(c, 1, Integer::sum);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            if (isContains(pmap, map)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean isContains(Map<Character, Integer> pmap, Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (pmap.get(entry.getKey()) == null || !pmap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(findAnagrams("cbaebabacd", "abc"));
//        System.out.println(findAnagrams("baa", "aa"));
        System.out.println(findAnagrams("aaabb", "bb"));
    }
}
