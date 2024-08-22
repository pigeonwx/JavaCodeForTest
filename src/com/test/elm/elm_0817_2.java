package com.test.elm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class elm_0817_2 {
    public static int hash(int x,int y){
        return x*501+y;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int x1 = in.nextInt() - 1;
            int y1 = in.nextInt() - 1;
            int x2 = in.nextInt() - 1;
            int y2 = in.nextInt() - 1;
            while (x1 <= x2 && y1 <= y2) {
                if (arr[x1][y1] == 1) {
                    y1++;
                    if (y1 > y2) {
                        System.out.printf("%d %d\n", x1 + 1, y1);
                    }
                } else {
                    x1++;
                    if (x1 > x2) {
                        System.out.printf("%d %d\n", x1, y1 + 1);
                    }
                }
            }
        }
    }
}
