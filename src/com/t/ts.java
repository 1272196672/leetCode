package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int res = 0;
        int maxLen = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp[j] + 1 > dp[i]){
                        count[i] = count[j];
                    }
                    else if (dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == maxLen){
                res += count[i];
            }
        }
        return res;
    }
}
