package com.test.pdd;

import java.util.*;

public class test_pdd_0811_1 {
    public static class Place {
        public int p;
        public int x;
        public int d;

        public Place(int p, int x, int d) {
            this.p = p;
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Place[] places = new Place[n];
        // (优先级，下标)映射关系
        Map<Integer, List<Place>> map = new HashMap<>();
        List<Integer> pList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int p = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            if (map.containsKey(p)) {
                map.get(p).add(new Place(p, x, d));
            } else {
                List<Place> list = new ArrayList<>();
                list.add(new Place(p, x, d));
                map.put(p, list);
                pList.add(p);
            }
        }
        // 先按优先级进行划分桶
        // 1. 按优先级从低到高访问
        // 2. 同优先级下若有多个可以访问，先访问d小的
        int cnt = 0;
        for (int i = 0; i < pList.size(); i++) {
            List<Place> list = map.get(pList.get(i));
            Collections.sort(list, new Comparator<Place>() {
                @Override
                public int compare(Place p1, Place p2) {
                    if (p1.x == p2.x) {
                        return p1.d - p2.d;
                    } else {
                        return p1.x - p2.x;
                    }
                }
            });
            int len = list.size();
            int sumCnt = len;
            boolean[] visited = new boolean[sumCnt];
            while (sumCnt > 0) {
                for (int j = 0; j < len; j++) {
                    if (!visited[j]) {
                        if (cnt < list.get(j).x) {
                            visited[j] = true;
                            sumCnt--;
                            cnt = list.get(j).x;
                        }
                    }
                }
                cnt++;
            }
            System.out.println(cnt);
        }
//        System.out.println(cnt);
    }

    public static boolean isOk(int day, Place p) {
        if ((day - p.x) % p.d == 0) {
            return true;
        }
        return false;
    }
}
