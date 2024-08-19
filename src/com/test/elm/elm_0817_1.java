package com.test.elm;

import java.util.Scanner;

public class elm_0817_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            int cnt = 0;
            for (int i = 0; i <= n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - 1 - i)) {
                    cnt++;
                }
            }
            if (k - cnt >= 0) {
                if (n % 2 == 0 && (k - cnt) % 2 == 0) {
                    System.out.println("YES");
                } else if (n % 2 == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
