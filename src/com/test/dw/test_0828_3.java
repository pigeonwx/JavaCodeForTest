package com.test.dw;

import java.util.Scanner;
import java.util.Stack;

public class test_0828_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        char[] carr = str.toCharArray();
        Stack<Integer> st = new Stack<>();
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = carr[i];
            if (c == '(') {
                st.push(i);
            } else {
                if (st.isEmpty()) {
                    break;
                } else {
                    if (st.size() == 1) {
                        temp += i - st.peek() + 1;
                    }
                    st.pop();
                }
            }
        }
        System.out.println(temp);
    }

    public static void test() {
        String[] testList = {
                "(((",
                "))((",
                "()(()",
                "(((()",
                "(()(()))",
                "(()())()",
        };
        for (int k = 0; k < testList.length; k++) {
            String str = testList[k];
            char[] carr = str.toCharArray();
            Stack<Integer> st = new Stack<>();
            int maxn = 0;
            int temp = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = carr[i];
                if (c == '(') {
                    st.push(i);
                } else {
                    if (st.isEmpty()) {
                        break;
                    } else {
                        if (st.size() == 1) {
                            temp += i - st.peek() + 1;
                        }
                        st.pop();
                    }
                }
            }
            System.out.println(str + "  ===> " + temp);
        }
    }
}
