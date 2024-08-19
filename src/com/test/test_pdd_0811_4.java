package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class test_pdd_0811_4 {
    public static ArrayList<Integer> res = new ArrayList<>();
    public static int[] temp;
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                list.add(arr[i]);
            }
        }
        Collections.sort(list);
        boolean[] vis = new boolean[list.size()];
        temp = new int[n];
        Arrays.fill(temp, -1);
        Arrays.fill(vis, false);
        for (int i = 0; i < list.size(); i++) {
            if (dfs(temp, vis, arr, list.get(i), list)) {
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

    public static boolean dfs(int[] temp, boolean[] vis, int[] arr, int x, ArrayList<Integer> list) {
        // 找到x元素应该存放的位置t
        x=list.get(x);
        int t = x;
        t = t % n;
        while (temp[t] != -1) {
            t = (t + 1) % n;
        }
        if (arr[t] != x) {
            return false;
        }
        // 放x
        temp[t] = x;
        res.add(t);
        for (int i = 0; i < list.size(); i++) {
            int xt = i;
            if (!vis[xt]) {
                vis[xt] = true;
                if (dfs(temp, vis, arr, xt, list)) {
                    return true;
                }
                vis[xt] = false;
            }
        }
        if (res.size() == n) {
            return true;
        }
        res.remove(res.size() - 1);
        temp[t] = -1;
        return true;
    }
}
