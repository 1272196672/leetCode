package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        //int[持有否][冻结否]
        int[][] dp = new int[2][2];
        dp[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //以下情况需按正常逻辑情况列出！！！
            //今天持有股票非冻结，昨天不持有不冻结不买入，或者，昨天不持有不冻结且买入股票
            dp[1][0] = Math.max(dp[1][0], dp[0][0] - prices[i]);
            //今天不持股不冻结，昨天可能不持股不冻结，还可能昨天不持股冻结
            dp[0][0] = Math.max(dp[0][0], dp[0][1]);
            //今天被冻结，昨天一定是持股非冻结且卖出了股票
            dp[0][1] = dp[1][0] + prices[i];
        }
        return Math.max(dp[0][0], dp[0][1]);
    }
}