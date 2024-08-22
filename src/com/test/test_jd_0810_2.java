package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test_jd_0810_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int tgt = x - arr[i];
            if (tgt == arr[i]) {
                cnt += map.get(tgt);
            } else {
                cnt += map.get(tgt);
            }
        }
        System.out.println(cnt);
    }
}
