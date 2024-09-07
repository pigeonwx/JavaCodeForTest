package com.test.xc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test_0905_1 {
    public static int n, k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        boolean[] vis = new boolean[n + 1];
        Arrays.fill(vis, false);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dfs(0, vis, list, dp);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", list.get(i));
        }
    }

    public static boolean dfs(int index, boolean[] vis, List<Integer> list, int[] dp) {
        if (index >= n) {
            return true;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                list.add(i);
                vis[i] = true;
                if (judge(list, index, dp, k)) {
                    if (dfs(index + 1, vis, list, dp)) {
                        return true;
                    }
                }
                dp[index]=1;
                list.remove(index);
                vis[i] = false;
            }
        }
        return false;
    }

    public static boolean judge(List<Integer> list, int last, int[] dp, int k) {
        int maxt = list.get(last);
        for (int i = last - 1; i >= 0; i--) {
            if (list.get(i) < maxt) {
                dp[last] = Math.max(dp[last], dp[i] + 1);
            }
        }
        return dp[last] <= k;
    }
}
