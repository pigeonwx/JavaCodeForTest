package com.test.mt;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test_mt_0810_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int[] num = new int[n];
            int[] znum = new int[n + 1];// 记录未出现的最小非负自然数
            znum[n] = 0;
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            Set<Integer> st = new HashSet<>();
            for (int i = n - 1; i >= 0; i--) {
                int res = znum[i + 1];
                if (!st.contains(res)) {
                    znum[i] = znum[i + 1];
                    st.add(num[i]);
                } else {
                    while (st.contains(res)) {
                        res++;
                    }
                    znum[i] = res;
                    st.add(num[i]);
                }
            }
            int temp = znum[0];
            while (st.contains(temp)) {
                temp++;
            }
            int minSum = Math.min(k * temp, n * x);
            int sumt = 0;
            for (int i = 0; i < n; i++) {
                sumt = (i + 1) * x;
                minSum = Math.min(minSum, sumt + k * znum[i]);
            }
            System.out.println(minSum);
        }
    }
}
