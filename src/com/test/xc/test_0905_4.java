package com.test.xc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test_0905_4 {
    public static int n, k, sum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        sum = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int res = 0;
        int ts = 0;
        for (int i = 0; i < n; i++) {
            ts += arr[i];
            if (i - k >= 0) {
                ts -= arr[i - k];
            }
            int diff = ts - sum;
            res+=(Math.max(diff, 0));
            ts-=(Math.max(diff, 0));
            arr[i]-=(Math.max(diff, 0));
        }
        System.out.println(res);
    }


}
