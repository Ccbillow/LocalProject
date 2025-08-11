package org.example.auz.practice.map;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/description/
 */
public class Num_48 {

    /**
     * 90 degrees (clockwise)
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        // 1,3  3,1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int[] ints : matrix) {
            reverse(ints);
        }
    }

    /**
     * 90 degrees (anticlockwise)
     * @param matrix
     */
    public static void rotate3(int[][] matrix) {
        for (int[] ints : matrix) {
            reverse(ints);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    /**
     * 90 degrees (anticlockwise)
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        int length = matrix.length;

        // 0,1  3,4
        for (int i = 0; i < length; i++) {
            int length1 = matrix[i].length;
            for (int j = 0; j < length1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length1 - j - 1][length - i - 1];
                matrix[length1 - j - 1][length - i - 1] = tmp;
            }

        }

        for (int[] ints : matrix) {
            reverse(ints);
        }
    }

    private static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {7, 6, 5, 4},
                        {4, 1, 2, 3}};
        rotate2(arr);

    }
}
