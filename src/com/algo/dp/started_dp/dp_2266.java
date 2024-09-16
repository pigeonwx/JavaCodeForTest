package com.algo.dp.started_dp;

//为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
//比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
//注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
//但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
//比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
//给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
//由于答案可能很大，将它对 109 + 7 取余 后返回。
public class dp_2266 {
    public int countTexts(String pressedKeys) {
        int[] nums = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        int MOD = 1000000007;
        int len = pressedKeys.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] % MOD;
            char c = pressedKeys.charAt(i - 1);
            for (int j = 2; j <= nums[c - '0']; j++) {
                if (i - j + 1 >= 1) {
                    if (pressedKeys.charAt(i - j + 1 - 1) == c) {
                        dp[i] = (dp[i - j] + dp[i]) % MOD;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return dp[len];
    }
}
