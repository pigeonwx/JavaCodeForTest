package com.test.xc;

import java.util.Scanner;

public class test_0905_3_2 {
    public static int res;
    public static int n, m, k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        res = 0;
        boolean[] vis = new boolean[n + 1];
        dfs(1, 0, vis);
        System.out.println(res);
    }

    public static void dfs(int index, int sum, boolean[] vis) {
        if (index > m) {
            if (sum > k) {
                res++;
            }
            return;
        }
        if(index==1){
            for (int i = 1; i <= n; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    sum = sum * 10 + i;
                    dfs(index + 1, sum, vis);
                    sum = (sum - i) / 10;
                    vis[i] = false;
                }
            }
        }else{
            for (int i = 0; i <= n; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    sum = sum * 10 + i;
                    dfs(index + 1, sum, vis);
                    sum = (sum - i) / 10;
                    vis[i] = false;
                }
            }
        }
    }

}
