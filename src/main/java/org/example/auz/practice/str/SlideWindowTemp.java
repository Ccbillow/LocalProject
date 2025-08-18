package org.example.auz.practice.str;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlideWindowTemp {

    public void slideWindowTemp(String str) {

        Deque<Character> window = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        
        while (right < str.length()) {

            char c = str.charAt(right);
            window.addLast(c);
            right++;

            //todo...
            System.out.println("window: ... left:... right:..." + window + left + right);

            // todo while (real condition) {
            while (left < right) {
                Character r = window.removeFirst();
                left++;

                //todo...
            }
        }
    }
}
