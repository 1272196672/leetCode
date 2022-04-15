package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, target, 0);
        return result;
    }

    public void backTracing(int[] candidates, int target, int startIndex){
        if (sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTracing(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}