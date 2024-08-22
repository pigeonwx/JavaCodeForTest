package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test_0821_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        int tk = k;
        for (int i = 0; i < n; ) {
            ArrayList<Integer> list = new ArrayList<>();
            tk = k;
            while (i < n && tk > 0) {
                list.add(in.nextInt());
                tk--;
                i++;
            }
            int index = -1;
            for (int t = 0; t < res.size(); t++) {
                if (list.equals(res.get(t))) {
                    cntMap.put(t, cntMap.getOrDefault(t, 0) + 1);
                    index = t;
                    break;
                }
            }
            if (index == -1) {
                res.add(list);
                cntMap.put(res.size() - 1, 1);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.printf("%d ", list.get(j));
            }
            System.out.printf("%d", cntMap.get(i));
            if (i != res.size() - 1) {
                System.out.printf(" ");
            }
        }
    }
}
