package com.test.mhy;

import java.util.Scanner;

public class test_0817_2 {
    public static class line {
        int l;
        int r;

        line(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n + 1];
        line[] lines = new line[m + 1];
        int[] larr = new int[m + 1];
        int[] rarr = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            larr[i] = l;
            rarr[i] = r;
            lines[i] = new line(l, r);
            for (int j = l; j <= r; j++) {
                arr[j]++;
            }
        }
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            boolean flag = true;
            for (int j = larr[i]; j <= rarr[i]; j++) {
                if (arr[j] <= 1) {
                    flag = false;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
