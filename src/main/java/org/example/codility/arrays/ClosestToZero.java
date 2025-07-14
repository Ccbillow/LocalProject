package org.example.codility.arrays;

/**
 * Input:  [7, -10, 13, 8, 4, -7, -2, -3]
 * Output: -2
 *
 * Input:  [-5, 5, -4, 4]
 * Output: 4  (因为 +4 和 -4 等距，返回正的)
 *
 * Input:  [0, -1, 2, -3]
 * Output: 0
 */
public class ClosestToZero {

    public static int solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i : arr) {
            if (min > Math.abs(i)) {
                min = Math.min(min, Math.abs(i));
                res = i;
            } else if (min == Math.abs(i)) {
                res = Math.abs(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, -10, 13, 8, 4, -7, -2, -3};
        int[] arr2 = {-5, 5, -4, 4};
        int[] arr3 = {0, -1, 2, -3};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
    }
}
