package test;

import java.util.*;

public class test_0821_3 {
    public static int maxRes = 0;
    public static int minSum = Integer.MAX_VALUE;
    public static int n = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int[] arr = new int[n + 1];

        int[][] G = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            G[i][i] = 1;
            arr[i] = s.nextInt();
        }
        int m = s.nextInt();
        for (int i = 1; i <= m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            G[a][b] = G[b][a] = 1;
        }
        boolean[] vis = new boolean[n + 1];
        Set<Integer> visSet = new HashSet<Integer>();
        for (int i = 1; i <= n; i++) {
            dfs(i, vis, G, arr, 0, 0, visSet);
        }
        System.out.printf("%d", minSum);
    }

    public static void dfs(int start, boolean[] vis, int[][] G, int[] arr, int cnt, int sum, Set<Integer> s) {
        cnt = cnt + 1;
        sum = sum + arr[start];
        vis[start] = true;
        s.add(start);
        if (cnt > maxRes) {
            maxRes = cnt;
            minSum = sum;
        } else if (cnt == maxRes) {
            minSum = Math.min(minSum, sum);
        }
        for (int i = 1; i <= n; i++) {
            if (G[start][i] != 1 && vis[i] == false) {
                boolean flag = true;
                for (Integer num : s) {
                    if (G[i][num] == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    dfs(i, vis, G, arr, cnt, sum, s);
                }
            }
        }
        vis[start] = false;
        s.remove(start);
    }
}
