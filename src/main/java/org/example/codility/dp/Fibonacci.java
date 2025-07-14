package org.example.codility.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static int solution(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return solution(n - 1) + solution(n - 2);
    }

    public static Map<Integer, Integer> map = new HashMap<>();

    public static int solution2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = solution2(n - 1) + solution2(n - 2);
        map.put(n, result);
        return result;
    }

    public static int solu(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return solu(n - 1) + solu(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(solu(3));
    }
}
