package com.test.xhs;

import java.util.BitSet;
import java.util.Scanner;

public class test_0901_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 2];
        int[] moveable = new int[n + 2];
        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            moveable[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (moveable[i] == 1 && arr[i] == 1) {
                cnt[1]++;
            } else if (moveable[i] == 1 && arr[i] == 2) {
                cnt[2]++;
            }
        }
        int first = -1;
        for (int i = 0; i < n; ) {
            if (moveable[i] == 0) {
                if (first == -1) {
                    first = i;
                }
                int j = i + 1;
                int begin = arr[i];
                while (j < n && moveable[j] == 1 && cnt[begin] > 0) {
                    if (arr[j] == begin) {
                        j++;
                        continue;
                    } else {
                        cnt[begin]--;
                        arr[j] = begin;
                        if (begin == 1) {
                            cnt[2]++;
                        } else {
                            cnt[1]++;
                        }
                        j++;
                    }
                }
                i = j;
                continue;
            }
            i++;
        }
        for (int i = first - 1; i >= 0; i--) {
            if (cnt[arr[first]] > 0) {
                arr[i] = arr[first];
                cnt[arr[first]]--;
            } else {
                arr[i] = arr[first] == 1 ? 2 : 1;
            }
        }
        int res=0;
        for (int i = 1; i < n; i++) {
            if(arr[i]!=arr[i-1]){
                res++;
            }
        }
        System.out.println(res);
    }
}
