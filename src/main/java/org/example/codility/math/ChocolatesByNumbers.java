package org.example.codility.math;

import java.util.HashSet;
import java.util.Set;

public class ChocolatesByNumbers {

    public static int solution(int N, int M) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int curr = 0;

        while (!set.contains(curr)) {
            set.add(curr);
            res++;
            curr = (curr + M) % N;

        }
        return res;
    }

    public static int A(int N, int M) {
        return N / gcd(N, M);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

       return gcd(b, a % b);
    }

    public static int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd2(b, a % b);
    }
}
