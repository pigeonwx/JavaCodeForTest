package com.test.sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test_0828_2 {
    public static int res = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        boolean[] vis = new boolean[n + 2];
        Arrays.fill(vis, false);
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> l = new ArrayList<Integer>();
        dfs(0, arr, vis, n, l);
        System.out.println(res);
    }

    public static void dfs(int cnt, int[] arr, boolean[] vis, int n, List<Integer> l) {
        if (cnt == n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                int t = arr[i];
                if (cnt == 0 || l.get(cnt - 1) % t == 0 || t % l.get(cnt - 1) == 0) {
                    vis[i] = true;
                    l.add(t);
                    dfs(cnt + 1, arr, vis, n, l);
                    vis[i] = false;
                    l.remove(l.size() - 1);
                }
            }
        }
    }
}
