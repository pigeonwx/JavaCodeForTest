package com.test.zj;

import java.util.Arrays;
import java.util.Scanner;

public class test_0908_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 1; i <= 2 * n - 1; i++) {
            arr[i] = in.nextInt();
        }
        long[][] dp = new long[2 * n][n + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i < 2 * n; i++) {
            Arrays.fill(dp[i], 0);
            dp[i][0] = dp[i - 1][0] + arr[i];
        }
        long max_ans = 0;
        for (int i = 1; i <= 2 * n - 1; i++) {
            //dp[i][n]
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] - arr[i], dp[i - 1][j] + arr[i]);
//                for (int k = 1; k <= i - 1; k++) {
//                    dp[i][j] = Math.max(Math.max(dp[k][j - 1] - arr[i], dp[k][j] + arr[i]), dp[i][j]);
//                }
            }
            max_ans = Math.max(max_ans, dp[i][n]);
            max_ans = Math.max(max_ans, dp[i][0]);
        }
        System.out.println(max_ans);
    }
}

