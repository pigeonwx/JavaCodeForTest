package com.test.qne;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test_0906_1 {
    public static int n = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.next();
        }
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                int index=0;
                while (index<o1.length()&&index<o2.length()) {
                    if (o1.charAt(index)!=o2.charAt(index)) {
                        return o2.charAt(index)-o1.charAt(index);
                    }else{
                        index++;
                    }
                }
                if(o1.length()>o2.length()){
                    String temp=o1;
                    o1=o2;
                    o2=temp;
                }
                while(index<o2.length()){
                    if(o2.charAt(index)!=o2.charAt(index-1)){
                        return -(o2.charAt(index-1)-o2.charAt(index));
                    }
                    index++;
                }
                return 0;
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.printf("%s ",arr[i]);
        }
    }
}
