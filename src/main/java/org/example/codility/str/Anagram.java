package org.example.codility.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：s = "anagram", t = "nagaram" → 输出：true
 *
 * 输入：s = "rat", t = "car" → 输出：false
 */
public class Anagram {

    public static boolean solution(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("anagram", "nagaram"));   // true
        System.out.println(solution("rat", "car"));           // false
        System.out.println(solution("夜空中最亮的星", "亮的星最夜空中")); // true
        System.out.println(solution("🌟⭐", "⭐🌟"));             // true
    }
}
