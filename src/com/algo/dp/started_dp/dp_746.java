package com.algo.dp.started_dp;

//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
//你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
//请你计算并返回达到楼梯顶部的最低花费。

public class dp_746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length +2];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for (int i = 3; i <= cost.length+1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1 - 1], dp[i - 2] + cost[i - 2-1]);
        }
        return dp[cost.length+1];
    }
}
