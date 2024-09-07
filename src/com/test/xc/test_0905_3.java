package com.test.xc;

import java.util.Scanner;

public class test_0905_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] target = new int[10];
        int index = 0;
        do {
            target[index++] = k % 10;
            k=k/10;
        } while (k != 0);

    }
}
