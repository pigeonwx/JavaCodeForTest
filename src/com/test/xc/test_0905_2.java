package com.test.xc;

import java.util.Scanner;

public class test_0905_2 {
    public static void main(String[] args) {
        while(true) {
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
                }else{
                    dp[i] = dp[i - 1];
                }
            }
            int res = 0;
            for (int l = 1; l <= n; l += 2) {
                int left = 1;
                for (; left + l-1 <= n; left++) {
                    int right = left + l - 1;
                    if (compute(left, right, chars, dp) % 2 == 1) {
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }

    public static int compute(int left, int right, char[] chars, int[] dp) {
        while (chars[right] == '1') {
            right--;
        }
        int l=left-1;
        while(l>=0&&chars[l]==chars[left]){
            l--;
        }
        return dp[right]-dp[l];
    }
}
