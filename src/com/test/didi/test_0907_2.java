package com.test.didi;

import java.util.Arrays;
import java.util.Scanner;

public class test_0907_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] C = new int[k + 1][k + 1];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                C[i][j] = scanner.nextInt();
            }
        }
        String str = scanner.next();
        char[] chars = str.toCharArray();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n-1; i++) {
            dp[i][i] = 0;
            char l = chars[i];
            char r = chars[i + 1];
            dp[i][i + 1] = C[l - 'a'][r - 'a'];
        }
        for (int l = 2; l <= n; l +=2) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                //dp[i][j]= i....t....j
                // ->i+1,t-1
                for (int t = i + 1; t <= j; t += 2) {
                    int t1 = dp[i + 1][t - 1];
                    int t2 = dp[t + 1][j];
                    int t3 = C[chars[i]-'a'][chars[t]-'a'];
                    dp[i][j] = Math.max(dp[i][j], t1 + t2 + t3);
                }

            }
        }
        System.out.println(dp[0][n-1]);
    }
}
