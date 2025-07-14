package org.example.interview.arr;

import java.util.Arrays;

public class ReverseArry {

    public static void main(String[] args) {
        String[] originalArray = {"Java", "Python", "C++", "Ruby", "JavaScript"};

        int left = 0;
        int right = originalArray.length - 1;

        while (left < right) {
            String tmp = originalArray[left];
            originalArray[left] = originalArray[right];
            originalArray[right] = tmp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(originalArray));
    }


}
