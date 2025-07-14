package org.example.codility.math;

public class GreatestCommonDivisorAndLeastCommonMultiple {

    public static int[] solution(int a, int b) {
        int gcd = computeGCD(a, b);
        int lcm = a / gcd * b;
        return new int[]{gcd, lcm};
    }

    private static int computeGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    private static int gcd(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(computeGCD(48, 18));
        System.out.println(gcd(48, 18));
    }
}
