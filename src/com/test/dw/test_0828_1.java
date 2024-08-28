package com.test.dw;

import java.util.Scanner;

public class test_0828_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1= in.next();
        String s2 = in.next();
        int cnt=0;
        for (int i=0; i<s1.length(); i++) {
            cnt+=(s1.charAt(i)-s2.charAt(i)+10)%10;
        }
        System.out.println(cnt);
    }
}
