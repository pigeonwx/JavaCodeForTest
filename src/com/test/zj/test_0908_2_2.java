package com.test.zj;

import java.util.Arrays;
import java.util.Scanner;

public class test_0908_2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[2 * n-1];
        for (int i = 0; i < 2 * n-1; i++) {
            arr[i] = in.nextInt();
        }
        while (true) {
            Arrays.sort(arr);
            long sum = 0;
            long sum_f = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                sum_f -= arr[i];
            }
            if (sum_f < sum) {
                break;
            } else {
                for (int i = 0; i < n; i++) {
                    arr[i] = -arr[i];
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < 2 * n-1; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
