package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 267. Palindrome Permutation II
 *
 */
public class Num_267 {

    List<String> res = new ArrayList<>();

    StringBuilder stack = new StringBuilder();

    boolean[] visited;

    public List<String> generatePalindromes(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        visited = new boolean[arr.length];

        dfs(arr);
        return res;
    }

    private void dfs(char[] arr) {
        if (stack.length() == arr.length) {
            if (palindromes(stack, 0, stack.length() - 1)) {
                res.add(stack.toString());
                return;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            stack.append(arr[i]);

            dfs(arr);

            stack.deleteCharAt(stack.length() - 1);
            visited[i] = false;
        }
    }

    private boolean palindromes(StringBuilder stack, int left, int right) {
        while (left < right) {
            if (stack.charAt(left) != stack.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Num_267 test = new Num_267();
        test.generatePalindromes("aabb");
    }


}
