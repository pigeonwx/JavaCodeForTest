package com.test.mt;

import java.util.*;

public class test_mt_0810_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        String s = in.next();
        int resLen = s.length();
        ArrayList<String> strList = new ArrayList<>();
        Set<String> st = new HashSet<>();
        int len = 0;
        while (n-- > 0) {
            String stemp = in.next();
            if (st.contains(stemp)) {
                continue;
            }
            strList.add(stemp);
            st.add(stemp);
        }
        Collections.sort(strList, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                } else {
                    return a.compareTo(b);
                }
            }
        });
        int mint = -1;
        int tcnt = 0;
        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).length() < resLen) {
                mint = i;
            } else if (strList.get(i).length() == resLen) {
                tcnt++;
            } else {
                break;
            }
        }
        System.out.printf("%d %d", mint + 2, mint + tcnt+1);
    }
}
