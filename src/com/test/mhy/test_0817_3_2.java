package com.test.mhy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test_0817_3_2 {
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
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = l; j <= r; j++) {
                if (arr[j] == x) {
                    list.add(j);
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < list.size(); j++) {
                int index = list.get(j);
                for (int k = l; k <= index; k++) {
                    for (int h = index; h <= r; h++) {
                        set.add(k * 10000 + h);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}
