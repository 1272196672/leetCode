package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {
        new Solution().canPartition();
    }
}

class Solution {
    public void canPartition() {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight+ 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
    }
}