package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k == 0) {
            return 0;
        }
        //第k次持有（1）不持有（0）股票
        int[][] dp = new int[k + 1][2];
        //赋初值，第一个股票完成k次交易
        for (int i = 1; i <= k; i++) {
            dp[i][1] = -prices[0];
        }
        //遍历所有股票
        for (int i = 1; i < prices.length; i++) {
            //将第1~k次交易情况全部列出
            for (int j = 1; j <= k; j++) {
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
            }
        }
        return dp[k][0];
    }
}