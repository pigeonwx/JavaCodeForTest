package com.algo.dp.started_dp;

import java.util.Arrays;

//给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
//将 '0' 在字符串末尾添加 zero  次。
//将 '1' 在字符串末尾添加 one 次。
//以上操作可以执行任意次。
//如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
//请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
public class dp_2466 {
    public static int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, 0);
        //dp[i]= i-zero || i-one
        dp[0] = 1;
        int MOD = 1000000007;
        int res = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
            if (i >= low) {
                res = (res + dp[i]) % MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = countGoodStrings(3, 3, 1, 1);
        System.out.println(res);
    }
}
