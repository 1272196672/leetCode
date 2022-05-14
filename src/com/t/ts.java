package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0){
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        used = new boolean[nums.length];
        return backtracking(nums, 0, k, target, nums.length - 1);
    }

    public boolean backtracking(int[] nums, int sum, int k, int target, int startIndex){
//        k个背包都装满了
        if (k == 0){
            return true;
        }
//        当前的背包满了，切换下一个背包，从头开始遍历物品，背包少一个
        if (sum == target){
            return backtracking(nums, 0, k - 1, target, nums.length - 1);
        }
//        从大到小遍历物品
        for (int i = startIndex; i >= 0; i--) {
//            树枝去重
            if (used[i]){
                continue;
            }
//            sum大于target，跳过
            if (sum + nums[i] > target){
                continue;
            }
//            数层去重
            if (i < nums.length - 2 && nums[i] == nums[i + 1] && !used[i + 1]){
                continue;
            }
            used[i] = true;
            if (backtracking(nums, sum + nums[i], k, target, i - 1)){
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}