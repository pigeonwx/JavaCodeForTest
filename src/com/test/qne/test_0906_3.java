package com.test.qne;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test_0906_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
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
                if (flag&&temp>1) {
                    map.clear();
                    res++;
                }
            } else {
                map.put(c, 1);
            }
        }
        System.out.println(res);
    }
}
