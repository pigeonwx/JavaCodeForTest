package com.test.pdd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test_pdd_0811_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        // arr0[i]表示 i位置之前有几个0
        int[] arr0 = new int[n + 1];
        int[] arr1 = new int[n + 1];
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            arr0[i] = cnt0;
            arr1[i] = cnt1;
            if (arr[i] == 0) {
                cnt0++;
            } else {
                cnt1++;
            }
        }
        arr0[n]=cnt0;
        arr1[n]=cnt1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // [i,i]位置反转
                int cnt_t_0 = arr0[j + 1] - arr0[i];
                int cnt_t_1 = arr1[j + 1] - arr1[i];
                int res_0 = cnt0 - cnt_t_0 + cnt_t_1;
                int res_1 = cnt1 - cnt_t_1 + cnt_t_0;
                set.add(Math.abs(res_0 - res_1));
            }
        }
        System.out.println(set.size());
    }
}
