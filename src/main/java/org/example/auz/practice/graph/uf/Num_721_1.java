package org.example.auz.practice.graph.uf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Num_721_1 {


    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<Integer>> email2Index = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);

            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                email2Index.computeIfAbsent(email, k -> new ArrayList<>()).add(i);
            }
        }

        UF uf = new UF(accounts.size());
        for (List<Integer> indexes : email2Index.values()) {
            if (indexes.size() > 1) {
                for (int i = 1; i < indexes.size(); i++) {
                    uf.union(indexes.get(i), indexes.get(i - 1));
                }
            }
        }

        Map<Integer, Set<String>> rootIndex2Emails = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : email2Index.entrySet()) {
            String email = entry.getKey();
            int root = uf.find(entry.getValue().get(0));
            rootIndex2Emails.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : rootIndex2Emails.entrySet()) {
            Integer rootIndex = entry.getKey();
            Set<String> emails = entry.getValue();

            List<String> list = new ArrayList<>();
            String name = accounts.get(rootIndex).get(0);
            list.add(name);
            list.addAll(emails);
            res.add(list);
        }
        return res;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                parent[rootx] = rooty;
                count--;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("John", "johnnybravo@mail.com"),
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("Mary", "mary@mail.com"));

        Num_721_1 test = new Num_721_1();
        List<List<String>> lists = test.accountsMerge(accounts);
        lists.forEach(System.out::println);
    }

}
