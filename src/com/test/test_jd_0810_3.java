package com.test;

import java.util.Scanner;

public class test_jd_0810_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] b = new int[n];
            int[] c = new int[n];
            for (int j = 0; j < n; j++) {
                b[j] = in.nextInt();
                c[j] = calc(b[j]);
            }
            int cnt = 0;
            cnt += c[0];
            for (int j = 1; j < n; j++) {
                if (c[j] > c[j - 1]) {
                    cnt += c[j] - c[j - 1];
                }
            }
            System.out.println(cnt);
        }
    }

    public static int calc(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n = n / 2;
                cnt++;
            } else {
                n = n - 1;
                cnt++;
            }
        }
        return cnt;
    }
}
