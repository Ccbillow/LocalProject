package org.example.auz.practice.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 737. Sentence Similarity II
 *
 */
public class Num_737 {

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        UF uf = new UF();
        for (List<String> pair : similarPairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        for (int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i];
            String w2 = sentence2[i];
            if (w1.equals(w2)) {
                continue;
            }
            if (!uf.connected(w1, w2)) {
                return false;
            }
        }
        return true;
    }


    class UF {
        Map<String, String> parent = new HashMap<>();

        public String find(String x) {
            parent.putIfAbsent(x, x);
            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(String p, String q) {
            String rootP = find(p);
            String rootQ = find(q);
            if (!rootP.equals(rootQ)) {
                parent.put(rootP, rootQ);
            }
        }

        public boolean connected(String p, String q) {
            if (!parent.containsKey(p) || !parent.containsKey(q)) {
                return false;
            }
            return find(p).equals(find(q));
        }
    }
}
