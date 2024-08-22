package com.test.sxf;

import java.util.Scanner;

public class test_0818_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            dp[i] = arr[i];
        }
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - k; j++) {
                dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
