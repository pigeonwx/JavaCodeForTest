package com.test.sxf;

import java.util.ArrayList;
import java.util.Scanner;

public class test_0818_3 {
    public static class Node {
        int m, n, x, y;

        public Node(int m, int n, int x, int y) {
            this.m = m;
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = in.nextInt();
        ArrayList<Node> list = new ArrayList<Node>();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            String xs = in.next();
            String xy = in.next();
            int x = Integer.parseInt(xs.substring(1));
            int y = Integer.parseInt(xy.substring(0, xy.length() - 1));
            list.add(new Node(n, m, x, y));
            System.out.printf("%d %d\n", x, y);
        }
    }
}
