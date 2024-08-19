package com.test;

import java.util.*;

public class test_pdd_0811_1_p {
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
        Map<Integer, PriorityQueue<Place>> map = new HashMap<>();
        List<Integer> pList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int p = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            if (map.containsKey(p)) {
                PriorityQueue<Place> pq = map.get(p);
                Place place = new Place(p, x, d);
                map.get(p).add(place);
            } else {
                PriorityQueue<Place> pq = new PriorityQueue<>(new Comparator<Place>() {
                    public int compare(Place o1, Place o2) {
                        if (o1.x == o2.x) {
                            return o1.d - o2.d;
                        } else {
                            return o1.x - o2.x;
                        }
                    }
                });
                Place place = new Place(p, x, d);
                pq.add(place);
                map.put(p, pq);
                pList.add(p);
            }
        }
        int cnt = 0;
        Collections.sort(pList);
        for (int i = 0; i < pList.size(); i++) {
            PriorityQueue<Place> pq = map.get(pList.get(i));
            while (!pq.isEmpty()) {
                cnt++;
                Place place = pq.poll();
                if (cnt <= place.x) {
                    cnt = place.x;
                } else {
                    place.x += place.d;
                    cnt--;
                    pq.offer(place);
                }
            }
        }
        System.out.println(cnt);
    }
}
