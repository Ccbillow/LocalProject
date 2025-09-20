package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1125. smallest-sufficient-team
 * https://leetcode.cn/problems/smallest-sufficient-team/description/
 */
public class Num_1125_2 {


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Set<String> allSkills = new HashSet<>(Arrays.asList(req_skills));
        Deque<Pair> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.addLast(new Pair(new HashSet<>(), new ArrayList<>()));
        visited.add("");

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();
            Set<String> curSkills = cur.skills;
            List<Integer> curTeams = cur.teams;

            if (curSkills.containsAll(allSkills)) {
                return curTeams.stream().mapToInt(Integer::intValue).toArray();
            }

            for (int i = 0; i < people.size(); i++) {
                Set<String> newSkills = new HashSet<>(curSkills);
                newSkills.addAll(people.get(i));

                if (newSkills.size() == curSkills.size()) {
                    continue;
                }

                List<String> skillList = new ArrayList<>(newSkills);
                Collections.sort(skillList);
                String key = String.join(",", skillList);

                if (!visited.contains(key)) {
                    visited.add(key);
                    List<Integer> newTeam = new ArrayList<>(curTeams);
                    newTeam.add(i);
                    q.addLast(new Pair(newSkills, newTeam));
                }
            }
        }
        return new int[0];
    }

    class Pair {
        Set<String> skills;
        List<Integer> teams;

        public Pair(Set<String> skills, List<Integer> teams) {
            this.skills = skills;
            this.teams = teams;
        }
    }
}
