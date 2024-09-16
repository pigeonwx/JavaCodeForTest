package com.test.zj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test_0908_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long m = sc.nextLong();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            ans += arr[i] / k;
            arr[i] = arr[i] % k;
            pq.add(arr[i]);
        }
        Arrays.sort(arr);
        while (!pq.isEmpty()&&m > 0) {
            if (pq.peek() + m > k) {
                int t = pq.poll();
                ans++;
                m = m - (k - t);
            } else {
                break;
            }
        }
        ans += m / k;
        System.out.println(ans);
    }
}
