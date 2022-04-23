package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0 || Math.abs(target) > sum){
            return 0;
        }
        int backWeight = (sum + target) / 2;
        int[] dp = new int[backWeight + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            //走下面的for则是能放进去，本身方法数量加上重量减去此num的数量
            for (int j = backWeight; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[backWeight];
    }
}