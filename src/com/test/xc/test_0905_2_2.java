package com.test.xc;

import java.util.Scanner;

public class test_0905_2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        char[] chars = new char[n + 1];
        chars[0] = '3';
        for (int i = 1; i <= n; i++) {
            chars[i] = str.charAt(i - 1);
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (chars[i] != chars[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int res = 0;

        int[] dp2 = new int[n + 1];
        dp2[1] = chars[1] == '1' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int l = 1; l <= i; l+=2) {
                int left = i - l + 1;
                if (compute(left, i, chars, dp) % 2 == 1) {
                    temp++;
                }
            }
            dp2[i] = dp2[i - 1] + temp;
        }
        System.out.println(dp2[n]);
    }

    public static int compute(int left, int right, char[] chars, int[] dp) {
        while (chars[right] == '1') {
            right--;
        }
        int l = left - 1;
        while (l >= 0 && chars[l] == chars[left]) {
            l--;
        }
        return dp[right] - dp[l];
    }
}
