package org.example.codility.greedy;

import java.util.Arrays;

public class MaxProductOfThree {

    public static int solution(int[] A) {
        Arrays.sort(A);

        int num1 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int num2 = A[0] * A[1] * A[A.length - 1];

        return Math.max(num1, num2);
    }

    public static int max(int[] A) {
        Arrays.sort(A);

        int a = A[A.length - 3] + A[A.length - 2] + A[A.length - 1];
        int b = A[0] + A[1] + A[A.length - 1];
        return Math.max(a, b);
    }
}
