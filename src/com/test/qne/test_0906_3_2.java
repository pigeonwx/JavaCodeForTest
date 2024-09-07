package com.test.qne;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test_0906_3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] carr = s.toCharArray();
        int res = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i]=0;
            for (int j = 1; j < i; j++) {
                if (judge(carr, j-1, i-1)) {
                    if(dp[j-1]!=0||j-1==0){
                        dp[i] = Math.max(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[n]);
    }

    public static boolean judge(char[] nums, int l, int r) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = l; i <= r; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int temp = 0;
        boolean flag = true;
        for (int value : map.values()) {
            if (temp == 0) {
                temp = value;
            } else {
                if (value != temp) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag && temp > 1) {
            return true;
        }
        return false;
    }
}
