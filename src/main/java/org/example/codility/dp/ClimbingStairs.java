package org.example.codility.dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {


    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return solution(n - 1) + solution(n - 2);
    }


    private static Map<Integer, Integer> map = new HashMap<>();

    public static int climb(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = climb(n - 1) + climb(n - 2);
        map.put(n, result);
        return result;
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }

}
