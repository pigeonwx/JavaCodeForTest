package com.algo;

public class KMP {
    public static void getNext(char[] s, int[] next) {
        int len = s.length;
        int j = -1;
        next[0] = -1;
        for (int i = 1; i < len; i++) {
            while (j != -1 && s[j + 1] != s[i]) {
                j = next[j];
            }
            if (s[i] == s[j + 1]) {
                j++;
            }
            next[i] = j;
        }
    }

    public static boolean kmp(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        int[] next = new int[n];
        getNext(text, next);
        int j = -1;
        for (int i = 0; i < n; i++) {
            while (j != -1 && pattern[j + 1] != text[i]) {
                j = next[j];
            }
            if (pattern[j + 1] == text[i]) {
                j++;
            }
            if (j == m - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[] text = "ababababc".toCharArray();
        char[] pattern = "ababc".toCharArray();
        System.out.println(kmp(text, pattern));
    }

}
