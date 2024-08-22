package com.test.mhy;

import java.util.Scanner;

public class test_0817_1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int res = 0;
        int cur = 1;//某天
        int cur_last_day = 0;// 预期最后一天收益
        int cur_sum = 0; //已经收获的原石头
        while (cur <= m) {
            if (n - (cur_sum + (cur_last_day - cur + 1) * 90) >= 300) {
                // 买月卡
                res += 30;
                cur_sum += 300;
                cur_last_day = m > cur + 30 - 1 ? cur + 30 - 1 : m;
            } else {
                break;
            }
            cur++;
        }
        System.out.println(res);
    }
}
