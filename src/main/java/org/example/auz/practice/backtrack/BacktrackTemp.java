package org.example.auz.practice.backtrack;

import org.example.interview.map.TransferTest;

import java.util.ArrayList;
import java.util.List;

public class BacktrackTemp {

    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();

    public List<String> temp(int n) {
        backtrack(n, 0);
        return res;
    }

    private void backtrack(int n, int i) {
        if (i == n) {
            res.add(track.toString());
            return;
        }

        for (int val : new int[]{0, 1}) {
            track.append(val);

            backtrack(n, i + 1);

            track.deleteCharAt(track.length() - 1);
        }


    }
}
