package com.test.sxf;

import java.util.Scanner;
import java.util.Stack;

public class test_0818_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String str_reg = in.nextLine();
        int index = 0;
        char pre = ' ';
        for (int i = 0; i < str_reg.length(); i++) {
            char cur = str_reg.charAt(i);
            if (cur == '*') {
                int next = i + 1;
                while (next < str_reg.length() && str_reg.charAt(next) == pre) {
                    next++;
                }
                if (next > i + 1) {
                    int index_temp = index;
                    while (str.charAt(index_temp) == pre) {
                        index_temp++;
                    }

                } else {
                    while (str.charAt(index) == pre) {
                        index++;
                    }
                }
            } else {
                if (str.charAt(index) == cur) {
                    index++;
                    pre = cur;
                } else {
                    break;
                }
            }
        }
        System.out.println(index);
    }
}
