package test;

import java.util.*;

public class test {

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        HashMap<List<Integer>, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                list.add(in.nextInt());
            }
            if (cntMap.containsKey(list)) {
                cntMap.put(list, cntMap.get(list) + 1);
            } else {
                res.add(list);
                cntMap.put(list, 1);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.printf("%d ", list.get(j));
                ;
            }
            System.out.printf("%d", cntMap.get(list));
            if (i != res.size() - 1) {
                System.out.printf(" ");
            }
        }
    }

}
