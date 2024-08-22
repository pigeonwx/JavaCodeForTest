package com.test.elm;

import java.util.*;

public class eml_0817_3 {
    public static class edge {
        int a;
        int b;
        int c;

        edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] G = new int[n + 1][n + 1];
        ArrayList<edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            edge edge = new edge(a, b, c);
            edges.add(edge);
        }
        Collections.sort(edges, new Comparator<edge>() {
            public int compare(edge o1, edge o2) {
                return o2.c - o1.c;
            }
        });
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(edges.get(0).c);
        set.add(edges.get(0).a);
        set.add(edges.get(0).b);
        while (set.size() < n) {
            for (int i = 0; i < edges.size(); i++) {
                int a = edges.get(i).a;
                int b = edges.get(i).b;
                int c = edges.get(i).c;
                if (set.contains(a) && set.contains(b)) {
                    continue;
                } else if (set.contains(a)) {
                    list.add(c);
                    set.add(b);
                } else if (set.contains(b)) {
                    list.add(c);
                    set.add(a);
                } else {
                    list.add(c);
                    set.add(b);
                    set.add(a);
                }
                edges.remove(i);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            pq.add(list.get(i));
        }
        for (; k > 0; ) {
            int min_top1 = pq.poll();
            int min_top2 = pq.poll();
            int dis = min_top2 - min_top1;
            if (dis == 0) {
                min_top1++;
                k--;
            } else {
                min_top1 = min_top1 + dis;
                k = k - min_top1;
            }
            pq.add(min_top1);
            pq.add(min_top2);
        }
        System.out.println(pq.poll());
    }
}
