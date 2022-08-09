package com;

import java.text.DecimalFormat;
import java.util.*;

public class ts {
    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String x = scanner.next();
            if (x.length() % 2 == 0){
                String[] strings = new String[x.length() / 2];
                int index = 0;
                for (int i = 0; i < strings.length; i = i + 2) {
                    strings[index] = x.substring(i, i + 2);
                }
                int sum = 0;
                for (int i = 0; i < strings.length; i++) {
                    sum += Integer.parseInt(strings[i]);
                }
            }
        }
    }

    class Main {
        public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                int[] nums = new int[n];
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    nums[i] = scanner.nextInt();
                    sum += nums[i];
                }
                int bagWeight = sum / m;
                int[] dp = new int[bagWeight];
                for (int i = 0; i < n; i++) {
                    for (int j = bagWeight; j >= nums[i]; j--) {
                        dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                    }
                }
                System.out.println(2 * bagWeight - dp[bagWeight - 1]);
            }
        }
    }
}