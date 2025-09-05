package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Num_721_2 {


    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> email2Indexes = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                List<Integer> indexes = email2Indexes.getOrDefault(email, new ArrayList<>());
                indexes.add(i);
                email2Indexes.put(email, indexes);
            }
        }

        List<List<String>> res = new ArrayList<>();
        HashSet<String> visitedEmails = new HashSet<>();
        for (String email : email2Indexes.keySet()) {
            if (visitedEmails.contains(email)) {
                continue;
            }

            LinkedList<String> mergedEmail = new LinkedList<>();
            LinkedList<String> q = new LinkedList<>();
            q.addLast(email);
            visitedEmails.add(email);
            while (!q.isEmpty()) {
                String cur = q.removeFirst();
                mergedEmail.addLast(cur);
                List<Integer> indexes = email2Indexes.get(cur);
                for (Integer index : indexes) {
                    List<String> account = accounts.get(index);
                    for (int i = 1; i < account.size(); i++) {
                        String nxt = account.get(i);
                        if (!visitedEmails.contains(nxt)) {
                            q.addLast(nxt);
                            visitedEmails.add(nxt);
                        }
                    }
                }
            }
            String username = accounts.get(email2Indexes.get(email).get(0)).get(0);
            Collections.sort(mergedEmail);
            mergedEmail.addFirst(username);
            res.add(mergedEmail);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("John", "johnnybravo@mail.com"),
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("Mary", "mary@mail.com"));

        List<List<String>> lists = accountsMerge(accounts);
        lists.forEach(System.out::println);
    }
}
