package com.test.xhs;

import java.util.*;

public class test_0901_3_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String color = scanner.next();
        char[] colorArray = color.toCharArray();
        List<List<Integer>> G = new ArrayList<>();
        G.add(new ArrayList<>());
        for (int i = 1; i <= n + 1; i++) {
            G.add(new ArrayList<>());
        }
        for (int i = 1; i <= n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            G.get(u).add(v);
            G.get(v).add(u);
        }
        int maxSize = 0;
        boolean[] vis = new boolean[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (colorArray[i - 1] == 'R') {
                for (int j = 0; j < G.get(i).size(); j++) {
                    int cnt = 0;
                    Queue<Integer> q = new LinkedList<>();
                    Arrays.fill(vis, false);
                    vis[i] = true;
                    int v = G.get(i).get(j);
                    if (set.contains(i * 100000 + v) || (set.contains(v * 100000 + i))) {
                        continue;
                    } else {
                        set.add(i * 100000 + v);
                        set.add(v * 100000 + i);
                    }
                    q.offer(v);
                    while (!q.isEmpty()) {
                        int t = q.poll();
                        vis[t] = true;
                        if (colorArray[t - 1] == 'B') {
                            cnt++;
                        }
                        for (int k = 0; k < G.get(t).size(); k++) {
                            int temp = (G.get(t).get(k));
                            if (temp == i) {
                                continue;
                            }
                            if (!vis[temp]) {
                                q.offer(temp);
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, cnt);
                }
            }
        }

        System.out.println(maxSize);
    }
}

