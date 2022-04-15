package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0);
        return result;
    }

    public void backTracing(int[] nums, int startIndex){
        if (path.size() >= 2){
            result.add(new ArrayList<>(path));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (path.size() != 0 && nums[i] < path.getLast()){
                continue;
            }
            if (map.getOrDefault(nums[i], 0) != 0){
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.removeLast();
        }
    }
}