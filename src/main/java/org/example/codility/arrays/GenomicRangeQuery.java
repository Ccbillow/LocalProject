package org.example.codility.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A = 1
 * C = 2
 * G = 3
 * T = 4
 *
 * S = "CAGCCTA"
 * P = [2, 5, 0]
 * Q = [4, 5, 6]
 *
 * 查询解释：
 * 1. S[2..4] = "GCC" → 最小 impact 是 C = 2
 * 2. S[5..5] = "T"   → impact = 4
 * 3. S[0..6] = "CAGCCTA" → 最小 impact 是 A = 1
 *
 * 输出应为：[2, 4, 1]
 */
public class GenomicRangeQuery {

    public static int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        for (int i = 0; i < P.length; i++) {
            int from = P[i];
            int to = Q[i];

            int min = 4;

            for (int j = from; j <= to; j++) {
                char c = S.charAt(j);
                Integer value = map.get(c);
                min = Math.min(min, value);

                if (min == 1) {
                    break;
                }
            }
            result[i] = min;
        }

        return result;
    }

    public static int[] query(String S, int[] P, int[] Q) {
        int[] res = new int[P.length];
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);

        for (int i = 0; i < P.length; i++) {
            int min = 4;
            int from = P[i];
            int to = Q[i];

            for (int j = from; j <= to; j++) {
                char c = S.charAt(j);
                Integer val = map.get(c);
                min = Math.min(min, val);

                if (min == 1) {
                    break;
                }
            }
            res[i] = min;
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        System.out.println(Arrays.toString(solution(S, P, Q)));
        System.out.println(Arrays.toString(query(S, P, Q)));
    }


}
