package com.test.mhy;

import java.util.Scanner;

public class mhy_0817_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int x = in.nextInt();
            int cnt = 0;
            for (int j = l; j <= r; j++) {
                if (arr[j] == x) {
                    cnt = cnt + (j - l + 1) * (r - j + 1);
                }
            }
            System.out.println(cnt);
        }

    }
}
