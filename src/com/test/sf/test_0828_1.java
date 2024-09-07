package com.test.sf;

import java.util.Scanner;

public class test_0828_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            System.out.println(getName(str));
        }
        test();
    }

    public static void test() {
        String[] names = {
                ".", "12A", "abc_defA",
                "MyLastName",
                "sampleFunc",
                "inputSampleTestTwo",
                "indistinct_Sample",
                "another__sample",
                "another_sample_"
        };
        for (int i = 0; i < names.length; i++) {
            System.out.println(getName(names[i]));
        }
    }

    public static String getName(String name) {
        StringBuilder sb = new StringBuilder();
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                flag1 = true;
                sb.append('_');
                sb.append((char) (c + 'a' - 'A'));
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == '_') {
                flag2 = true;
                sb.append(c);
            } else {
                return "indistinct";
            }
        }
        if ((flag1 && flag2) || !isLower(sb.charAt(sb.length() - 1)) || !isLower(sb.charAt(0))) {
            return "indistinct";
        }
        for (int i = 1; i < sb.length() - 1; i++) {
            char pre = sb.charAt(i - 1);
            char now = sb.charAt(i);
            char next = sb.charAt(i + 1);
            if (now == '_' && (pre == '-' || next == '_')) {
                return "indistinct";
            }
        }
        return sb.toString();
    }

    public static boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }
}
