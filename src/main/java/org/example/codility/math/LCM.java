package org.example.codility.math;

public class LCM {

    public static int lcm(int a, int b) {
        int gcd = gcd(a, b);

        return a / gcd * b;
    }

    // 16 12
    // 8 6
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
