package org.example.codility.str;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    public static Character solution(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return null;
    }
}
