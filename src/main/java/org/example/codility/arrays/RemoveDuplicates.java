package org.example.codility.arrays;

/**
 * Input:  A = [2, 2, 3, 3, 3, 4, 5, 5]
 * Output: 4
 * Explanation: Your function should return length = 4, and the first four elements of A should be [2, 3, 4, 5].
 */
public class RemoveDuplicates {

    public static int solution(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 3, 4, 5, 5};

        solution(arr);
    }
    public static int solution(int[] arr, int n) {
        if (arr.length <= n) {
            return arr.length;
        }

        int count = n;
        for (int i = n; i < arr.length; i++) {
            if (arr[i] != arr[i - n]) {
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }
}
