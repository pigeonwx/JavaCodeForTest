package com.algo.dp.FullPackage;

import java.util.Arrays;
//给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
//给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
//总成本必须恰好等于 target 。
//添加的数位中没有数字 0 。
//由于答案可能会很大，请你以字符串形式返回。
//如果按照上述要求无法得到任何整数，请你返回 "0" 。

public class dp_1499 {
    public String largestNumber(int[] cost, int target) {
        String[][] dp = new String[10][target + 1];
        Arrays.fill(dp[0], "#");
        dp[0][0] = "";
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - cost[i - 1] >= 0 && !dp[i][j - cost[i - 1]].equals("#")) {
                    dp[i][j] = strMax(dp[i][j], i + dp[i][j - cost[i - 1]]);
                }
            }
        }
        return dp[9][target].equals("#") ? "0" : dp[9][target];
    }

    private String strMax(String a, String b) {
        if (a.length() > b.length())
            return a;
        if (a.length() < b.length())
            return b;
        return a.compareTo(b) > 0 ? a : b;
    }
}
