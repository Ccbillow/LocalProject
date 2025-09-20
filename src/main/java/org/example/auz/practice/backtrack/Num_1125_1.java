package org.example.auz.practice.backtrack;

import org.example.auz.practice.graph.DfsTemp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1125. smallest-sufficient-team
 * https://leetcode.cn/problems/smallest-sufficient-team/description/
 */
public class Num_1125_1 {


    List<Integer> bestTeam = new ArrayList<>();
    int minSize = Integer.MAX_VALUE;


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
//        // 预处理：去掉技能完全被包含的人
//        List<Set<String>> peopleSkills = new ArrayList<>();
//        for (List<String> p : people) {
//            peopleSkills.add(new HashSet<>(p));
//        }
//        // 剪枝：去掉被包含的人
//        for (int i = 0; i < people.size(); i++) {
//            for (int j = 0; j < people.size(); j++) {
//                if (i != j && peopleSkills.get(j).containsAll(peopleSkills.get(i))) {
//                    peopleSkills.get(i).clear(); // i 是无用人
//                    break;
//                }
//            }
//        }

        Set<String> allSkills = new HashSet<>(Arrays.asList(req_skills));

        Set<String> skills = new HashSet<>();
        List<Integer> teams = new ArrayList<>();

        dfs(people, 0, skills, teams, allSkills);

        int[] res = new int[bestTeam.size()];
        for (int i = 0; i < bestTeam.size(); i++) {
            res[i] = bestTeam.get(i);
        }

        return res;
    }

    private void dfs(List<List<String>> people, int idx, Set<String> skills, List<Integer> teams, Set<String> allSkills) {
        if (teams.size() >= minSize) {
            return;
        }

        if (skills.containsAll(allSkills)) {
            minSize = teams.size();
            bestTeam = new ArrayList<>(teams);
            return;
        }

        if (idx == people.size()) {
            return;
        }

        // not choose people[i]
        dfs(people, idx + 1, skills, teams, allSkills);

        // choose people[i]
        Set<String> newSkills = new HashSet<>(skills);
        newSkills.addAll(people.get(idx));

        if (newSkills.size() > skills.size()) {
            teams.add(idx);

            dfs(people, idx + 1, newSkills, teams, allSkills);

            teams.remove(teams.size() - 1);
        }

    }
}
