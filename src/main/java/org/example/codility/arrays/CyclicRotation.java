package org.example.codility.arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class CyclicRotation {

    //Input:
    //A = [3, 8, 9, 7, 6], K = 3
    //
    //Explanation:
    //
    //1st rotation: [6, 3, 8, 9, 7]
    //
    //2nd rotation: [7, 6, 3, 8, 9]
    //
    //3rd rotation: [9, 7, 6, 3, 8]
    public static int[] rotationToRight(int[] A, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int n : A) {
            deque.add(n);
        }

        for (int i = 0; i < k; i++) {
            deque.addFirst(deque.removeLast());
        }

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = deque.removeFirst();
        }
        return res;
    }


    //Input:
    //A = [3, 8, 9, 7, 6], K = 3
    //
    //Explanation:
    //
    //1st rotation: [8, 9, 7, 6, 3]
    //
    //2nd rotation: [9, 7, 6, 3, 8]
    //
    //3rd rotation: [7, 6, 3, 8, 9]
    public static int[] rotationToLeft(int[] A, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i : A) {
            deque.add(i);
        }

        for (int i = 0; i < k; i++) {
            deque.addLast(deque.removeFirst());
        }

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = deque.removeFirst();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int[] toRight = rotationToRight(A, 3);
        System.out.println(Arrays.toString(toRight));

        int[] B = {3, 8, 9, 7, 6};
        int[] toLeft = rotationToLeft(B, 3);
        System.out.println(Arrays.toString(toLeft));
    }

    public static int[] rotationLeft(int[] A, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i : A) {
            deque.add(i);
        }

        for (int i = 0; i < k; i++) {
            deque.addFirst(deque.removeLast());
        }

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = deque.removeFirst();
        }
        return res;
    }
}
