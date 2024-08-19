package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test_lxhy_0817_3 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 2, 3, 3};
        System.out.println(splitArray(arr));
    }

    public static Map<Integer, Set<Integer>> map = new HashMap<>();

    public static int splitArray(int[] nums) {
        // write code here
        int len = nums.length;
        int cnt = 0;
        int i = 0;
        int j = len - 1;
        for (; i < len; ) {
            for (j = len - 1; j >= i; j--) {
                if (isOK(nums[i], nums[j])) {
                    cnt++;
                    i = j + 1;
                    break;
                }
            }
            if (j == i) {
                i++;
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isOK(int x, int y) {
        if (x > y) {
            return isOK(y, x);
        }
        if (map.containsKey(x)) {
            if (map.get(x).contains(y)) {
                return true;
            } else {
                map.put(x, new HashSet<Integer>());
            }
        }
        if (map.containsKey(y)) {
            if (map.get(y).contains(x)) {
                return true;
            } else {
                map.put(y, new HashSet<Integer>());
            }
        }
        int t = y % x;
        while (t != 0) {
            y = x;
            x = t;
            t = y % x;
        }
        if (x > 1) {
            if (map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                map.put(x, new HashSet<Integer>());
                map.get(x).add(y);
            }
            if (map.containsKey(y)) {
                map.get(y).add(x);
            } else {
                map.put(y, new HashSet<Integer>());
                map.get(y).add(x);
            }
        }
        return x > 1;
    }
}
