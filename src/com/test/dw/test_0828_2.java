package com.test.dw;

import java.util.Arrays;
import java.util.Scanner;

public class test_0828_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = in.nextInt();
        }
        // dp[x]=以x为最后一位时最长连续不嘲笑的数量
        int[] dp = new int[n + 1];
        int maxn = 1;
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            if (a[i] - a[i - 1] == b[i] - b[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                maxn = Math.max(maxn, dp[i]);
            } else {
                dp[i] = 1;
                maxn = Math.max(maxn, dp[i]);
            }
        }
        System.out.println(maxn);
    }
}
