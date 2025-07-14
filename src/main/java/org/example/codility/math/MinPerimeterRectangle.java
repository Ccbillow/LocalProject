package org.example.codility.math;

public class MinPerimeterRectangle {

    public static int solution(int A) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= A; i++) {
            if (A % i == 0) {
                int b = A / i;
                int res = 2 * (i + b);
                min = Math.min(min, res);
            }
        }

        return min;
    }

    public static int so(int A) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= A; i++) {
            if (A % i == 0) {
                int a = A / i;
                int tmp = 2 * (i + a);
                min = Math.min(min, tmp);
            }
        }
        return min;
    }
}
