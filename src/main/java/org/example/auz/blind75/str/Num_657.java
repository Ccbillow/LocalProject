package org.example.auz.blind75.str;

import java.util.HashMap;
import java.util.Map;

public class Num_657 {

    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 0);
        map.put('L', 0);
        map.put('R', 0);

        if (moves.isEmpty()) {
            return true;
        }

        for (char move : moves.toCharArray()) {
            map.put(move, map.get(move) + 1);
        }

        return map.get('L').equals(map.get('R'))
                && map.get('U').equals(map.get('D'));
    }
}
