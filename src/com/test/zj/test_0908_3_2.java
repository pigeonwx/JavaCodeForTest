package com.test.zj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test_0908_3_2 {
    public static class Node {
        long data;
        List<Node> children;
        long weight;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<Node>();
        }

    }

    public static long ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            int data = in.nextInt();
            nodes[i] = new Node(data);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u].children.add(nodes[v]);
        }
        ans = 0;
        postorder(nodes[1]);
        System.out.println(ans);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        long sum = 0;
        for (Node child : root.children) {
            sum += child.data;
        }
        if (root.data > sum) {
            return ;
        } else {
            ans = ans + (sum - root.data);
            root.data = sum;
        }
        return;
    }
}
