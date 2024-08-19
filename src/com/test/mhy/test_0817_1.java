package com.test.mhy;

import java.util.Scanner;

public class test_0817_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int res = 0;
        int cnt = m;
        int buy_cnt = 0;
        int max_value = 0;
        while (buy_cnt <= cnt) {
            if (n - max_value < 300) {
                break;
            }
            buy_cnt++;
            int validdays = (buy_cnt * 30) >= m ? m : buy_cnt * 30;
            max_value = buy_cnt * 300 + validdays * 90;
        }
        n = n - max_value;
        if (n > 0) {
            res += (n + 9) / 10;
        }
        res += buy_cnt * 30;
        System.out.println(res);
    }
}
