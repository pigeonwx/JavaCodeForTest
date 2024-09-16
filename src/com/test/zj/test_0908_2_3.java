package com.test.zj;

import java.util.Arrays;
import java.util.Scanner;

public class test_0908_2_3 {

    public static int n;
    public static long max_ans = 0;
    public static long sum=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            arr[i] = in.nextInt();
            sum+=arr[i];
        }
        boolean[] vis = new boolean[2 * n - 1];
        Arrays.fill(vis, false);

//        dfs(arr, 0, 0);
    }

    public static void dfs(int[] arr, int index, int sum, boolean[] vis) {
        if (index > n) {
            if (sum > max_ans) {
                max_ans = sum;
                return;
            }
        }
        for (int i = 0; i < 2 * n - 1; i++) {

//            dfs(arr, index + 1, sum - arr[i]);
        }
    }
}
