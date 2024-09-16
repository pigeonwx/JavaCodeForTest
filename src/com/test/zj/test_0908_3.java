package com.test.zj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test_0908_3 {
    public static class Node {
        int data;
        List<Node> children;
        long weight;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<Node>();
        }

    }

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
        long ans = postorder(nodes[1]);
        System.out.println(ans);
    }

    public static long postorder(Node root) {
        if (root == null) {
            return 0;
        }
        if(root.children.isEmpty()){
            return 0;
        }
        long sum = 0;
        for (Node child : root.children) {
            sum+=postorder(child);
        }
        for (Node child : root.children) {
            root.weight += child.weight+child.data;
        }
        return sum + Math.max(root.weight-root.data , 0);
    }
}
